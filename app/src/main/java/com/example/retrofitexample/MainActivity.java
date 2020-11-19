package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textid);

        /**
         * Working with retrofit
         * Making retrofit builder
         *
         */
        Retrofit retrofit=new Retrofit.Builder().
                baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /**
         * Instances for interface
         */
        MyApiCall myApiCall=retrofit.create(MyApiCall.class);
        Call<DataModel> call=myApiCall.getData();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.code()!=200)
                {
                    textView.setText("Check Internet Connection");
                    return;
                }
                //Get data into textview
                String data="";
               data="ID=="+response.body().getId()+
                    "\n User Id=="+response.body().getUserId()+
                       "\n Title=="+response.body().getTitle()+
                       "\n Is completed=="+response.body().isCompleted();
               textView.append(data);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

    }
}