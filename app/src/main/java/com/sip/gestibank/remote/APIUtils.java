package com.sip.gestibank.remote;

public class APIUtils {

    private APIUtils(){
    };

    public static  String API_URL =  "http://192.168.1.17/";
    public static  String API_CL = "http://api.currencylayer.com/";
    public static  String Empty_URL = "";

    public static ClientService userService(){
        return RetrofitClient.getClient(API_URL).create(ClientService.class);
    }

    public static ConversionService getConversionService(){
        return RetrofitClient.getClient(API_CL).create(ConversionService.class);
    }

    public static ConversionService getConversionServiceFill(String url){
        //Empty_URL= "http://api.currencylayer.com/live?access_key=84156eafd8c4c4c4c558362771cf6609&currencies="+url+"&format=1/";
        return RetrofitClient.getClient(url).create(ConversionService.class);
    }

}

