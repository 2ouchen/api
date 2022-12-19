package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;
    PostAdapter postAdapter;
    List<Posts> postsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myrecycler);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        postAdapter = new PostAdapter(postsList,this);
        recyclerView.setAdapter(postAdapter);

        fetchposts();


    }


    private void fetchposts() {



        retrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    postsList.addAll(response.body());
                    postAdapter.notifyDataSetChanged();



                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Error mate", Toast.LENGTH_SHORT).show();


            }
        });
    }
}