package com.example.william.hackathonproject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class getJson {

    public static void main(String[] args) throws IOException {

        boolean isA = true;
        boolean isB = false;
        boolean isC = false;
        String scode = "";
        if (isA == true) {
            scode = "HARD_ACCELERATION";
        }
        if (isB == true) {
            scode = "HARD_BRAKE";
        }
            StringBuilder urlBuilder = new StringBuilder("https://developer.gm.com/api/v1/fleet/vehicles/{vin}/data/services/{service_code}".replace("{vin}", URLEncoder.encode("1G6DH5E53C0000003", "UTF-8")).replace("{service_code}", URLEncoder.encode(scode, "UTF-8")));
            urlBuilder.append("?");
            urlBuilder.append(URLEncoder.encode("from","UTF-8") + "=" + URLEncoder.encode("2011-10-05T18:00:00.000Z", "UTF-8") + "&");
            urlBuilder.append(URLEncoder.encode("to","UTF-8") + "=" + URLEncoder.encode("2011-10-05T19:00:00.000Z", "UTF-8") + "&");
            urlBuilder.append(URLEncoder.encode("offet","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&");
            urlBuilder.append(URLEncoder.encode("limit","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            conn.setRequestProperty("Authorization", "Bearer ae60098a-dbff-48a8-9a06-18b6459bfb19");
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
        String s = sb.toString();
        String f = sb.toString();
        int index = s.indexOf("HardBrake");
        int count = 0;
        while (index != -1) {
            count++;
            s = s.substring(index + 1);
            index = s.indexOf("HardBrake");
        }
        System.out.println("No of *HardBrake* in the input is : " + count);
        int index2 = f.indexOf("HardAcceleration");
        int counts = 0;
        while (index2 != -1) {
            counts++;
            f = f.substring(index2 + 1);
            index2 = f.indexOf("HardAcceleration");
        }
        System.out.println("No of *HardAcceleration* in the input is : " + counts);
    }
}
