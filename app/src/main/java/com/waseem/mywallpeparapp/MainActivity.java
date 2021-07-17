package com.waseem.mywallpeparapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<String >list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        reference = FirebaseDatabase.getInstance().getReference().child("images");

        getImages();
    }

    private void getImages() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                list = new ArrayList<>();

                for (DataSnapshot data: snapshot.getChildren()){
                    String value = data.getValue().toString();
                    list.add(value);
                }
                GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new MyAdapter(list,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "error :"+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}