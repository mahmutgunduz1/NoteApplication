package com.example.noteapp.Adapter;



import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.noteapp.NoteHolder;
import com.example.noteapp.R;
import com.example.noteapp.models.Noteinfo;

import java.util.ArrayList;

public class EasyAdapter extends RecyclerView.Adapter<EasyAdapter.cardViewNesneTutucu> {
    private Context mcontex;
    private ArrayList<Noteinfo> noteinfos;




    public void setNoteInfo(ArrayList<Noteinfo> newList) {
        this.noteinfos = newList;
        notifyDataSetChanged();
    }


    public EasyAdapter(Context mcontex, ArrayList<Noteinfo> noteinfos) {
        this.mcontex = mcontex;
        this.noteinfos = noteinfos;
    }


    @NonNull
    @Override
    public cardViewNesneTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View tasarim = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new cardViewNesneTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewNesneTutucu holder, int position) {
        holder.textView.setText(noteinfos.get(position).getTextView());

        final int itemPosition = position;
        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeCard(itemPosition);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoteDetailPage(position);


            }
        });



    }

    private void openNoteDetailPage(int position) {
        Intent intentt = new Intent(mcontex, NoteHolder.class);
     mcontex.startActivity(intentt);
    }



    private void removeCard(int position) {

        if (position >= 0 && position < noteinfos.size()) {
            noteinfos.remove(position);
            notifyItemRemoved(position);
            notifyDataSetChanged();
        } else {

            Toast.makeText(mcontex, "gecersız", Toast.LENGTH_SHORT).show();
        }

    }




    @Override
    public int getItemCount() {
        return noteinfos.size();
    }

    public class cardViewNesneTutucu extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView deleteImage;

        public cardViewNesneTutucu(View v) {
            super(v);
            textView = v.findViewById(R.id.textView);
            deleteImage = v.findViewById(R.id.deleteImage);

        }
    }


}
