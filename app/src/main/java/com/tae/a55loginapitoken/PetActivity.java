package com.tae.a55loginapitoken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PetActivity extends AppCompatActivity {

    Pet pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        TextView idPet = findViewById(R.id.id);
        TextView namePet = findViewById(R.id.name);

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null) {
            pet = (Pet) bundle.getSerializable("pet");
            System.out.println("**************Name: "+pet.getName()+"ID: "+pet.getId());
        }
        idPet.setText(pet.getId().toString());
        namePet.setText(pet.getName().toString());


    }
}
