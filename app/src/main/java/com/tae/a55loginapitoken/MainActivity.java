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


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + loginString + "   " + passwordString);

        Login login = new Login(loginString, passwordString);

        api.login(login).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResultslogin, this::handleError);

    }
    private void handleResultslogin(Response<ResponseBody> responseBody) {
    String token = responseBody.headers().get("access-token");
        PreferenceManager.setAuth(token);
        Toast.makeText(MainActivity.this, PreferenceManager.getAuth(), Toast.LENGTH_SHORT).show();
        list();
    }


    void list() {
        api.petList()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(List<Pet> petsNew) {
        pets = new ArrayList<>();
        if (petsNew != null ) {
            pets.addAll(petsNew);
        }
        Intent intent = new Intent(getApplicationContext(), MainActionClass.class);
        intent.putExtra("start", (Serializable) pets);
        startActivity(intent);
    }


    private void handleError(Throwable throwable) {
        Toast.makeText(MainActivity.this, "Failure list", Toast.LENGTH_SHORT).show();
    }
}