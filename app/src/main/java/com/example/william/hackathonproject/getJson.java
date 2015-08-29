package com.example.william.hackathonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class getJson {
    public static void main(String[] args) throws IOException {
        boolean isA = false;
        boolean isB = true;
        boolean isC = false;
        String scode = "";
        if (isA == true) {
            scode = "TELEMETRY";
        }
        if (isB == true) {
            scode = "HARD_BRAKE";
        }
        StringBuilder urlBuilder = new StringBuilder("https://developer.gm.com/api/v1/fleet/vehicles/{vin}/data/services/{service_code}".replace("{vin}", URLEncoder.encode("1G6DH5E53C0000003", "UTF-8")).replace("{service_code}", URLEncoder.encode(scode, "UTF-8")));
        urlBuilder.append("?");
        urlBuilder.append(URLEncoder.encode("from","UTF-8") + "=" + URLEncoder.encode("2011-10-05T18:00:00.000Z", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("to","UTF-8") + "=" + URLEncoder.encode("2014-10-05T19:00:00.000Z", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("offet","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("limit","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        conn.setRequestProperty("Authorization", "Bearer 11accbbc-79a6-44d9-b3c9-d7657814cc84");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}