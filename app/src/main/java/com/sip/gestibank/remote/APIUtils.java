package com.sip.gestibank.remote;

import com.sip.gestibank.Conversion;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.43.165:86/api/";

    public static UserService getUserService(String myURL){
        return RetrofitClient.getClient(myURL).create(UserService.class);
    }

}
