package com.tae.a55loginapitoken;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActionClass extends AppCompatActivity{

RecyclerView recyclerView;
public ArrayList <Pet> pets;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_class);

//            pets = new ArrayList<>();
            Bundle bundle = getIntent().getExtras();
            if (bundle!=null) {
            pets = (ArrayList<Pet>) bundle.getSerializable("start");
            }
            recyclerView= findViewById(R.id.pets_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new PetAdapter(pets));
        }
    }