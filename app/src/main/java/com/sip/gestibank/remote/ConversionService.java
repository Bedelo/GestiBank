package com.sip.gestibank.remote;

import com.google.gson.JsonObject;
import com.sip.gestibank.model.Converter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ConversionService {
    @GET("/")
    Call<JsonObject> getConversion();





}
