package com.homeproject.homeproject.codeforces;

import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Component
public class RetrofitUtil {

    private final Retrofit retrofit;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://codeforces.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        return RetrofitImpl.retrofitUtil.retrofit;
    }

    private static class RetrofitImpl {
        private static final RetrofitUtil retrofitUtil = new RetrofitUtil();
    }
}
