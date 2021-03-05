package com.sip.gestibank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

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
    private Object quotes;

   /*  public  Currency(){

    }

   public  Currency(String success, String terms, String privacy, String timestamp, String source, Object quotes){
        this.privacy = privacy;
        this.quotes = quotes;
        this.source = source;
        this.success = success;
        this.terms = terms;
        this.timestamp = timestamp;
    }*/

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getQuotes() {
        return quotes;
    }

    public void setQuotes(Object quotes) {
        this.quotes = quotes;
    }
}
