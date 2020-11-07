package com.example.e_jobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.e_jobs.Adapter.MessageAdapter;
import com.example.e_jobs.Modal.Chat;
import com.example.e_jobs.Modal.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private static final String USER_ID = "user_id";
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    Intent intent;
    String userId;

    ImageButton imageButtonSend;
    EditText editText_Message;
    MessageAdapter messageAdapter;
    List<Chat> chatList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        userId = intent.getStringExtra(USER_ID);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        imageButtonSend = findViewById(R.id.send_button);
        editText_Message = findViewById(R.id.text_send);
        recyclerView = findViewById(R.id.recyclerView_Messages);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userId);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                readMessage(firebaseUser.getUid(), userId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        imageButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText_Message.getText().toString();
                if (!message.equals(""))
                {
                    sendMessage(firebaseUser.getUid(), userId, message);
                }
                else
                {
                    Toast.makeText(MessageActivity.this, "Please enter a valid text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMessage(String sender, String receiver, String message)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("sender", sender);
        hashMap.put("receiver", receiver);
        hashMap.put("message", message);

        databaseReference.child("chats").push().setValue(hashMap);

    }

    private void readMessage(final String myId, final String userId)
    {
        chatList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("chats");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chatList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Chat chat = snapshot.getValue(Chat.class);
                    if(chat.getReceiver().equals(myId) && chat.getSender().equals(userId) || chat.getReceiver().equals(userId) && chat.getSender().equals(myId))
                    {
                        chatList.add(chat);
                    }
                    messageAdapter = new MessageAdapter(MessageActivity.this, chatList);
                    recyclerView.setAdapter(messageAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}