package com.example.e_jobs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.Expert.DoctorExpert;
import com.example.e_jobs.MessageActivity;
import com.example.e_jobs.R;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorsHolder>
{
    public Context context;
    private DoctorExpert doctorExpert;
    OnDoctorListener onDoctorListener;
    public DoctorAdapter(Context context, DoctorExpert doctorExpert, OnDoctorListener onDoctorListener)
    {
        this.context = context;
        this.doctorExpert = doctorExpert;
        this.onDoctorListener = onDoctorListener;
    }
    @NonNull
    @Override
    public DoctorsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_sigleview_card,parent,false);
        return new DoctorsHolder(view, onDoctorListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsHolder holder, int position) {
        TextView docName = holder.view.findViewById(R.id.doc_name);
        ImageView docImage = holder.view.findViewById(R.id.doc_profileImage);

        docName.setText(doctorExpert.getDoctorByPos(position).getDoctorName());
        docImage.setImageURI(Uri.parse(Uri.decode(doctorExpert.getDoctorByPos(position).getDoctorProfileUri())));
    }

    @Override
    public int getItemCount() {
        return doctorExpert.getTotalDoctors();
    }

    public static class DoctorsHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        View view;
        OnDoctorListener onDoctorListener;
        public DoctorsHolder(@NonNull View itemView, OnDoctorListener onDoctorListener) {
            super(itemView);
            this.view = itemView;
            this.onDoctorListener = onDoctorListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onDoctorListener.onDoctorClick1(getAdapterPosition());
        }
    }
    public interface OnDoctorListener
    {
        void onDoctorClick1(int position);
    }
}