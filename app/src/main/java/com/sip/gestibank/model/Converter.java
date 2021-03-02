package com.sip.gestibank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import retrofit2.Call;

public class Converter extends JSONObject {
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("terms")
    @Expose
    private String terms;

    @SerializedName("privacy")
    @Expose
    private String privacy;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("quotes")
    @Expose
    private JSONObject quotes;

    @SerializedName("jsonResponse")
    @Expose
    private JSONObject jsonResponse;

    public Converter() {
        {}
    }

    /*public Converter(String success, String terms, String privacy, String timestamp, String source, JSONObject  quotes) {
        this.success= success;
        this.terms= terms;
        this.privacy= privacy;
        this.timestamp= timestamp;
        this.source= source;
        this.quotes= quotes;
    }*/



}
