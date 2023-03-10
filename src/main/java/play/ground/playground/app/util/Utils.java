package play.ground.playground.app.util;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    public static String httpGetRequest(String url, String token) throws IOException {
        URL url_obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) url_obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Authorization", "Token token=" + token);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Response Body:" + response);

        return response.toString();
    }

    public static Map parseJsonToMap(String jsonStr) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, Map.class);
    }

    public static <T> T parseJsonToObject(String jsonStr, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, clazz);
    }

    public static String readKeyboardInputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
