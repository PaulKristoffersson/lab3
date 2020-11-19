package com.example.lab4;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class ConnectionTest {


    ArrayList<String> result;
    int numberOfLinks = 8;


    public JSONObject makeConnection (int id, String search) throws IOException, JSONException {

        if (!search.isEmpty()) {
            String url = ("http://andla.pythonanywhere.com/getnames/" + id + "/" + search);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            Log.d("PRINTA", "\nSending 'GET' request to URL : " + url);
            Log.d("PRINTA", "Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject myResponse = new JSONObject(response.toString());
            return myResponse;
        }
    return null;

    }


}