package com.tae.a55loginapitoken;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tae.a55loginapitoken.Controller.Api;
import com.tae.a55loginapitoken.Controller.Controller;
import com.tae.a55loginapitoken.Controller.Login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Api api;
    public EditText login;
    public EditText password;
    public AppCompatButton button;
    public String loginString;
    public String passwordString;
    public ArrayList <Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = Controller.createService(Api.class);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        button = findViewById(R.id.authenticate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
}

public void login() {
    loginString = login.getText().toString();
    passwordString = password.getText().toString();
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+loginString+"   "+passwordString);

Login login = new Login(loginString,passwordString);
    Call <ResponseBody> call = api.login (login);
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                String token = response.headers().get("access-token");
                PreferenceManager.setAuth(token);
                Toast.makeText(MainActivity.this, PreferenceManager.getAuth(), Toast.LENGTH_SHORT).show();
                list();

            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
        }
    });
}

    void list() {
        Call<List<Pet>> call = api.petList();
        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
                pets = new ArrayList<>();
                if (response.body()!= null ) {
                    pets.addAll(response.body());
                }
                Intent intent = new Intent(getApplicationContext(), MainActionClass.class);
            intent.putExtra("start", (Serializable) pets);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure list", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
