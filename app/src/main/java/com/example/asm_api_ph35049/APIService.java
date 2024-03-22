package com.example.asm_api_ph35049;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
   public   String DOMAIN =" http://192.168.1.7:3000/";
   @GET("/api/list")
   Call<List<PhoneModel>> getPhones();
}
