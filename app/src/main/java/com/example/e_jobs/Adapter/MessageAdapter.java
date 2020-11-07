package com.example.e_jobs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_jobs.Expert.UserExpert;
import com.example.e_jobs.Modal.Chat;
import com.example.e_jobs.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyCourseViewHolder>
{
    private Context context;
    private List<Chat> chats;
    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;
    private UserExpert userExpert;
    private TextView courseName;
    private ImageView imageView;

    FirebaseUser firebaseUser;

    public MessageAdapter(Context context, List<Chat> chats)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        if (viewType == MSG_TYPE_RIGHT) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.chat_item_right, parent, false);
            return new MyCourseViewHolder(view);
        }
        else
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.chat_item_left, parent, false);
            return new MyCourseViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseViewHolder holder, int position)
    {
        View view = holder.view;
        Chat chat = chats.get(position);
        holder.show_message.setText(chat.getMessage());


    }

    @Override
    public int getItemCount()
    {
        return chats.size();
    }

    public static class MyCourseViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        public TextView show_message;
        public ImageView profile_image;
        public MyCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            show_message = view.findViewById(R.id.show_message);
        }

    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(chats.get(position).getSender().equals(firebaseUser.getUid()))
        {
            return MSG_TYPE_RIGHT;
        }
        else
        {
            return MSG_TYPE_LEFT;
        }
    }
}
