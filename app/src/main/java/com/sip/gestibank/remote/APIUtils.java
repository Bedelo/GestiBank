package com.sip.gestibank.remote;

public class APIUtils {

    private APIUtils(){
    };

    public static  String API_URL =  "http://192.168.1.17/api/";

    public static ConversionService getUserService(){
        return RetrofitClient.getClient(API_URL).create(ConversionService.class);
    }

    public static ConversionService getConversionService(String url){
        return RetrofitClient.getClient(url).create(ConversionService.class);
    }

}
