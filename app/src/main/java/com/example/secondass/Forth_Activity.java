package com.example.secondass;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Forth_Activity extends AppCompatActivity {

    private RequestQueue queue1;
    private TextView powerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        queue1 = Volley.newRequestQueue(this);
        powerList = findViewById(R.id.textViewForthActivity);


        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://www.freetogame.com/api/games?platform=pc";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle the JSON response
                        processData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        powerList.setText("Error: " + error.getMessage());
                    }
                }
        );

        queue.add(request);
    }

    private void processData(JSONArray response) {

        StringBuilder data = new StringBuilder();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject post = response.getJSONObject(i);
                String title = post.getString("title");

                data.append("Title: ").append(title).append("\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        powerList.setText(data.toString());
    }
}

