package com.example.fampay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout llParent;
    RecyclerView rv1,rv2,rv3,rv4,rv5;
    List<HC6Card> HC6CardList;
    List<HC9Card> HC9CardList;
    List<HC1Card> HC1CardList;
    List<HC5Card> HC5CardList;
    List<HC3Card> HC3CardList;
    HC6Adapter HC6Adapter;
    HC9Adapter HC9Adapter;
    HC1Adapter HC1Adapter;
    HC5Adapter HC5Adapter;
    HC3Adapter HC3Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llParent=(LinearLayout)findViewById(R.id.llParent);

        rv1=(RecyclerView)findViewById(R.id.rv1);
        rv1.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        HC6CardList =new ArrayList<>();
        HC6Adapter =new HC6Adapter(MainActivity.this, HC6CardList);
        rv1.setAdapter(HC6Adapter);

        rv2=(RecyclerView)findViewById(R.id.rv2);
        rv2.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        HC9CardList =new ArrayList<>();
        HC9Adapter =new HC9Adapter(MainActivity.this, HC9CardList);
        rv2.setAdapter(HC9Adapter);

        rv3=(RecyclerView)findViewById(R.id.rv3);
        rv3.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        HC1CardList =new ArrayList<>();
        HC1Adapter =new HC1Adapter(MainActivity.this, HC1CardList);
        rv3.setAdapter(HC1Adapter);

        rv4=(RecyclerView)findViewById(R.id.rv4);
        rv4.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        HC5CardList =new ArrayList<>();
        HC5Adapter =new HC5Adapter(MainActivity.this, HC5CardList);
        rv4.setAdapter(HC5Adapter);

        rv5=(RecyclerView)findViewById(R.id.rv5);
        rv5.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        HC3CardList =new ArrayList<>();
        HC3Adapter =new HC3Adapter(MainActivity.this, HC3CardList);
        rv5.setAdapter(HC3Adapter);

        READ_JSON();

    }

    private void READ_JSON(){
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest result=new JsonObjectRequest(Request.Method.GET,URL.JSON_URL,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.i("Response",response.toString());
                    JSONArray jsonArray=response.getJSONArray("card_groups");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String DesignType=jsonObject.getString("design_type");

                            if(DesignType.equals("HC6")) {
                                JSONArray jsonArray1 = jsonObject.getJSONArray("cards");
                                for (int j = 0; j < jsonArray1.length(); j++) {
                                    JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                                    HC6Card hc6Card = new HC6Card();
                                    hc6Card.setText(jsonObject1.getString("title"));
                                    hc6Card.setURL(jsonObject1.getJSONObject("icon").getString("image_url"));
                                    Log.i("Text", hc6Card.getText());
                                    Log.i("URL", hc6Card.getURL());
                                    HC6CardList.add(hc6Card);
                                    HC6Adapter.notifyDataSetChanged();
                                }
                            }

                            if(DesignType.equals("HC9")) {
                                JSONArray jsonArray2 = jsonObject.getJSONArray("cards");
                                for (int j = 0; j < jsonArray2.length(); j++) {
                                    JSONObject jsonObject1 = jsonArray2.getJSONObject(j);
                                    HC9Card hc9Card = new HC9Card();
                                    hc9Card.setURL(jsonObject1.getJSONObject("bg_image").getString("image_url"));
                                    hc9Card.setRatio(jsonObject1.getJSONObject("bg_image").getDouble("aspect_ratio"));
                                    HC9CardList.add(hc9Card);
                                    HC9Adapter.notifyDataSetChanged();
                                }
                            }

                            if(DesignType.equals("HC1")) {
                                JSONArray jsonArray1 = jsonObject.getJSONArray("cards");
                                for (int j = 0; j < jsonArray1.length(); j++) {
                                    JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                                    HC1Card hc1Card = new HC1Card();
                                    hc1Card.setText(jsonObject1.getString("title"));
                                    hc1Card.setURL(jsonObject1.getJSONObject("icon").getString("image_url"));
                                    if(jsonObject1.has("bg_color")){
                                        hc1Card.setBgColor(jsonObject1.getString("bg_color"));
                                    }
                                    Log.i("Text", hc1Card.getText());
                                    Log.i("URL", hc1Card.getURL());
                                    HC1CardList.add(hc1Card);
                                    HC1Adapter.notifyDataSetChanged();
                                }
                            }

                            if(DesignType.equals("HC5")) {
                                JSONArray jsonArray2 = jsonObject.getJSONArray("cards");
                                for (int j = 0; j < jsonArray2.length(); j++) {
                                    JSONObject jsonObject1 = jsonArray2.getJSONObject(j);
                                    HC5Card hc5Card = new HC5Card();
                                    hc5Card.setText(jsonObject1.getString("name"));
                                    hc5Card.setColor(jsonObject1.getString("bg_color"));
                                    hc5Card.setURL(jsonObject1.getJSONObject("bg_image").getString("image_url"));
                                    HC5CardList.add(hc5Card);
                                    HC5Adapter.notifyDataSetChanged();
                                }
                            }

                            if(DesignType.equals("HC3")) {
                                JSONArray jsonArray2 = jsonObject.getJSONArray("cards");
                                for (int j = 0; j < jsonArray2.length(); j++) {
                                    JSONObject jsonObject1 = jsonArray2.getJSONObject(j);
                                    HC3Card hc3Card = new HC3Card();
                                    hc3Card.setText(jsonObject1.getString("title"));
                                    hc3Card.setDesc(jsonObject1.getString("description"));
                                    hc3Card.setURL(jsonObject1.getJSONObject("bg_image").getString("image_url"));
                                    hc3Card.setBgColor(jsonObject1.getJSONArray("cta").getJSONObject(0).getString("bg_color"));
                                    hc3Card.setTextColor(jsonObject1.getJSONArray("cta").getJSONObject(0).getString("text_color"));
                                    hc3Card.setButtontext(jsonObject1.getJSONArray("cta").getJSONObject(0).getString("text"));
                                    HC3CardList.add(hc3Card);
                                    HC3Adapter.notifyDataSetChanged();
                                }
                            }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        result.setRetryPolicy(new DefaultRetryPolicy(500000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(result);
    }
}