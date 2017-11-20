package com.example.arturmusayelyan.jsonexample1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView tv_Json;
    private String stringFromJSON;
    private String valueFromRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Json = findViewById(R.id.json_tv);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.get_json_btn) {
            new BackgroundTask().execute();
        } else if (view.getId() == R.id.parse_json_btn) {
            if(valueFromRequest==null){
                Toast.makeText(this,"first get JSON ",Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(this, DisplayParsedJSON.class);
                intent.putExtra("json_data",valueFromRequest);
                startActivity(intent);
            }
        }
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "https://freemegalist.com/api.php/?action=categories";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((stringFromJSON = bufferedReader.readLine()) != null) {
                    stringBuilder.append(stringFromJSON + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            tv_Json.setText(result);
            valueFromRequest=result;
        }
    }
}
