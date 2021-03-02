package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.sip.gestibank.model.Converter;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ConversionService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Conversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] devises = {"EUR", "GBP", "TND"};
    Spinner spin;
    String url = "" ;
    List[] result ;
    ConversionService conversionService;
    TextView textViewRes;
    String text = "USD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        textViewRes = findViewById(R.id.textViewRes);

        conversionService = APIUtils.getConversionService();


        this.spin = (Spinner) findViewById(R.id.spinner_vers);
        this.spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,devises);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        text = this.spin.getSelectedItem().toString();
        textViewRes.setText(text);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
           // Toast.makeText(getApplicationContext(), devises[position], Toast.LENGTH_LONG).show();
        text = this.spin.getSelectedItem().toString();
        url = "http://api.currencylayer.com/live?access_key=84156eafd8c4c4c4c558362771cf6609&currencies="+text+"&format=1/";
        textViewRes.setText(text);
        conversionService = APIUtils.getConversionServiceFill(url);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getConverter(View v){
        conversionService = APIUtils.getConversionServiceFill(url);
        Call<JsonObject> call = conversionService.getConversion();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if(response.isSuccessful()){


                    Log.i("Data: ", response.body().toString());

                    StringBuffer buffer=new StringBuffer();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        //textViewRes.setText(result.toString());
    }

}