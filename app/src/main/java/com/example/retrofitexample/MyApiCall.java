package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/v3/    fix URL
    // 82d0d4a5-eda8-4aaf-8974-aa361d445aa1 this is variable
    @GET("v3/90fea295-8b4d-4e7c-be1e-f0788188102f")
    Call<DataModel> getData();

}
