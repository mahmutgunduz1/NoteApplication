package com.example.noteapp.fragment;

import android.app.AlertDialog;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.example.noteapp.Adapter.EasyAdapter;

import com.example.noteapp.models.Noteinfo;
import com.example.noteapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class NoteFragment extends Fragment implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ArrayList<Noteinfo> noteinfos;

    private EasyAdapter easyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_note, container, false);
        FloatingActionButton fab = tasarim.findViewById(R.id.fabButton);
        fab.setOnClickListener(v -> {
            addNewCard();
       //     alertViewNoteAdd();
             getLayoutInflater().inflate(R.layout.activity_note_add, null);


            AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());

            alert.setView(tasarim);
            alert.setIcon(R.drawable.baseline_edit_note_24);
            alert.setPositiveButton("Kaydet", (dialog, which) -> {
            });
            alert.setNegativeButton("IPTAL", (dialog, which) -> {
            });
            alert.create().show();
        });

        recyclerView = tasarim.findViewById(R.id.recyclerView);
        noteinfos = new ArrayList<>();
        noteinfos.add(new Noteinfo("mahmut"));
        noteinfos.add(new Noteinfo("mustafa"));
        noteinfos.add(new Noteinfo("mustafa"));
        noteinfos.add(new Noteinfo("mustafa"));
        noteinfos.add(new Noteinfo("mustafa"));

        easyAdapter = new EasyAdapter(requireContext(), noteinfos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(easyAdapter);




        toolbar = tasarim.findViewById(R.id.toolbar);
        toolbar.setTitle("All notes");
        toolbar.setLogo(R.drawable.baseline_edit_note_24);
        // Toolbar'ı ActionBar olarak ayarla
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        // Options Menu kullanılacağını belirt
        setHasOptionsMenu(true);

        return tasarim;
    }

    private void addNewCard() {
        noteinfos.add(new Noteinfo("yeni kart"));
        easyAdapter.notifyItemInserted(noteinfos.size() - 1);
        // RecyclerView'a yeni bir öğe eklendiğinde kullanılır.
        easyAdapter.notifyDataSetChanged();
        easyAdapter.notifyItemInserted(noteinfos.size() - 1);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ArrayList<Noteinfo> yeniArray = new ArrayList<>();
        for (Noteinfo aa : noteinfos) {
            if (aa.getTextView().contains(newText)) {
                yeniArray.add(aa);
            }
        }
        easyAdapter.setNoteInfo(yeniArray);
        return true;
    }

}