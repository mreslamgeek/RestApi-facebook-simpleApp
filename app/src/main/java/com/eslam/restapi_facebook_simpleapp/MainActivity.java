package com.eslam.restapi_facebook_simpleapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView post_title = findViewById(R.id.post_title_txt);

        //Post post = new Post(10, "My Post Request", "eslam mohamed post request test");
        HashMap<Object , Object> map =new HashMap<>();
        map.put("title" , "Israa");
        map.put("body" , "hi, this is my second post request");
        map.put("userId" , 1001);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        //Get request
       /*
        Call<List<Post>> call = apiInterface.getPost("1");
        //Call<Post> call = apiInterface.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                post_title.setText(response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                post_title.setText(t.getMessage());

            }
        });
*/

        /*call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                post_title.setText(response.body().getTitle());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                post_title.setText(t.getMessage());

            }
        });*/

        //Post Request
       // Call<Post> call = apiInterface.storePost(post);
        Call<Post> call = apiInterface.storePost(map);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                post_title.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                post_title.setText(t.getMessage());
            }
        });

    }
}