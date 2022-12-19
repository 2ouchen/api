package com.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {



        private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
        private static Retrofit retrofit = null;
        public static Iapi getRetrofitClient(){


            if (retrofit==null){

                retrofit =new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            }

            return retrofit.create(Iapi.class);
        }

}
