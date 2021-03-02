package com.sip.gestibank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Converter {
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
    private String quotes;

    public Converter(String success) {
        this.success = success;
    }

    public Converter(String success, String terms, String privacy, String timestamp, String source, String  quotes) {
        this.success= success;
        this.terms= terms;
        this.privacy= privacy;
        this.timestamp= timestamp;
        this.source= source;
        this.quotes= quotes;
    }



}
