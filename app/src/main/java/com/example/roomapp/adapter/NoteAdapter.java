package com.example.roomapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.roomapp.DetailsActivty;
import com.example.roomapp.R;
import com.example.roomapp.network.http.Emp;
import com.example.roomapp.room.Note;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private List<Emp> emps = new ArrayList<>();
    private Context context;
    private String basurl = "http://alsultanh.com/soltan_service/";

    public NoteAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteHolder holder, int position) {
        final Note currentNote = notes.get(position);

        holder.title_tv.setText(currentNote.getTitle());

        String x = notes.get(position).getImageUrl();
        Glide.with(context)
                .load(x)

                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into(holder.imge_tv);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivty.class);
                intent.putExtra("Title", currentNote.getTitle());
                intent.putExtra("Image", currentNote.getImageUrl());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView title_tv;
        private CircleImageView imge_tv;
        private CardView cardView;
        final ProgressBar progressBar;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.title);
            imge_tv = itemView.findViewById(R.id.profile_image);
            cardView = itemView.findViewById(R.id.menu_item_card_view);
            progressBar = itemView.findViewById(R.id.asd);
        }
    }
}
