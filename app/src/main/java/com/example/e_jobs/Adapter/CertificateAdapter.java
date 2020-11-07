package com.example.e_jobs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_jobs.R;
import com.example.e_jobs.Expert .UserExpert;

public class CertificateAdapter extends RecyclerView.Adapter<CertificateAdapter.RoomViewHolder>
{
    private UserExpert roomExpert;
    private Context context;
    private OnRoomListerner onRoomListerner;
    private String email;

    public CertificateAdapter(Context context, UserExpert roomExpert, OnRoomListerner onRoomListerner, String email)
    {
        this.context = context;
        this.roomExpert = roomExpert;
        this.onRoomListerner = onRoomListerner;
        this.email = email;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_shelf, parent, false);
        return new RoomViewHolder(view, onRoomListerner);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, final int position)
    {
        View view = holder.itemView;
        ImageView roomImage = view.findViewById(R.id.imageView1);
        //roomImage.setImageURI(roomExpert.getUser(email).getUserProfileUrl());
    }

    @Override
    public int getItemCount() {
        return roomExpert.getTotalUsers();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        View view;
        OnRoomListerner onRoomListerner;
        public RoomViewHolder(@NonNull View itemView, OnRoomListerner onRoomListerner)
        {
            super(itemView);
            this.view = itemView;
            this.onRoomListerner = onRoomListerner;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onRoomListerner.onRoomClick(getAdapterPosition());
        }
    }

    public interface OnRoomListerner
    {
        void onRoomClick(int position);
    }
}

