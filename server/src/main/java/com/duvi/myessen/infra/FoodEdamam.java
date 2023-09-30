package com.duvi.myessen.infra;

import com.duvi.myessen.adapters.FoodGateway;
import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.FoodNotFoundException;
import com.fasterxml.jackson.core.JsonFactory;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.bson.json.JsonObject;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JsonParser;

import java.net.URI;

public class FoodEdamam  implements FoodGateway {
    Dotenv dotenv = Dotenv.load();
    
    private String APP_ID = dotenv.get("APP_ID");
    private String API_KEY = dotenv.get("API_KEY");
    private String API_URL = dotenv.get("API_URL");
    private HttpClient client = HttpClient.newHttpClient();

    public parseResults(String results) {
        JsonParser parser;
        JsonFactory e;
        JsonObjectSerializer json = e.createParser(results);
    }
    public Food searchFood(String name) throws FoodNotFoundException {
        String query = String.format("?app_id=%1$s&api_key=%2$s&ingr=%3$s", APP_ID, API_KEY, name);
        URI uri = URI.create(API_URL+query);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String results = response.body();


}
}
