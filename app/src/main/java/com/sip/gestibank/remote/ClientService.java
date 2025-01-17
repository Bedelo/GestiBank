package com.sip.gestibank.remote;

import com.sip.gestibank.model.Client;
import com.sip.gestibank.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.sip.gestibank.model.User;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.DELETE;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.PUT;
        import retrofit2.http.Path;


public interface ClientService {

    @GET("agent/list/attente")
    Call<List<User>> getAgents();

    @GET("agent/list/")
    Call<List<User>> listAgents();

    @POST("client/add/")
    Call<User> addClient(@Body User user);

    @GET("client/list/")
    Call<List<Client>>  getClients();

    @GET("client/list/")
    Call<List<User>>  listClients();

}