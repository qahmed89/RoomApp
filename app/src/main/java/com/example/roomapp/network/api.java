package com.example.roomapp.network;

import com.example.roomapp.network.http.Alsultanh;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {
    @GET("soltan_service/app/employee/getall")
    Call<Alsultanh> getDate();
}
