package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ConversionService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Conversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] devises = {"EUR", "GBP", "TND"};
    Spinner spin;
    String url;
    JSONObject result;
    ConversionService conversionService;
    TextView textViewRes;
    String text = "USD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
         this.spin = (Spinner) findViewById(R.id.spinner_vers);
        this.spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,devises);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spin.setAdapter(aa);
        text = this.spin.getSelectedItem().toString();

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
           // Toast.makeText(getApplicationContext(), devises[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void urlToConvertisseur(){
        String text = this.spin.getSelectedItem().toString();
        this.url = "http://api.currencylayer.com/live?access_key=84156eafd8c4c4c4c558362771cf6609&currencies="+ text +"&format=1/";
        conversionService = APIUtils.getConversionService(this.url);
    }

    public void getConversion(View v){
        textViewRes = findViewById(R.id.textViewRes);
        APIUtils.getConversionService(this.url);
        Call<JSONObject> call = conversionService.getConverter();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if(response.isSuccessful()){
                    result= response.body();
                    Log.i("Data: ", result.toString());
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        //textViewRes.setText(result.toString());
    }

}