package com.example.arturmusayelyan.jsonexample1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayParsedJSON extends AppCompatActivity {
    private String valueFromCall;
    private List<Product> productList;

    private ExpandableListView expandableListView;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;
    private CustomExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parsed_json);
        expandableListView = findViewById(R.id.expandableListView);

        productList = new ArrayList<>();
        valueFromCall = getIntent().getExtras().getString("json_data");
        Log.d("ART  ", valueFromCall);

        try {
            JSONArray jsonArray = new JSONArray(valueFromCall);
            String id, name;
            int count;
            List<ChildrensProduct> childrensProductList;

            for (int i = 0; i < jsonArray.length(); i++) {
                childrensProductList = new ArrayList<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("category_id");
                name = jsonObject.getString("category_name");
                //count=jsonObject.getInt("category_count");
                count = jsonObject.optInt("category_count");

                JSONArray localJSONArray = jsonObject.getJSONArray("children_cats"); //kam jsonObject.optJSONArray("children_cats")
                if (localJSONArray != null) {
                    for (int j = 0; j < localJSONArray.length(); j++) {
                        JSONObject localJSONObject = localJSONArray.getJSONObject(j);
                        ChildrensProduct childrensProduct = new ChildrensProduct(localJSONObject.getString("category_id"), localJSONObject.getString("category_name"), localJSONObject.getString("category_count"));
                        childrensProductList.add(childrensProduct);
                    }
                }

                Product product = new Product(id, name, count, childrensProductList);
                productList.add(product);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("ART", productList.toString());

        adapter = new CustomExpandableListAdapter(this, productList);
        expandableListView.setAdapter(adapter);
    }


}
