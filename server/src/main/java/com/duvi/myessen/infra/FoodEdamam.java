package com.duvi.myessen.infra;

import com.duvi.myessen.adapters.FoodGateway;
import com.duvi.myessen.domain.Food;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FoodEdamam  implements FoodGateway {
    // //dotev to use .env variables
    // private static Dotenv dotenv = Dotenv.load();
    // //using .env variables
    // private static String APP_ID = dotenv.get("APP_ID");
    // private static String API_KEY = dotenv.get("API_KEY");
    // private static String API_URL = dotenv.get("API_URL");
    private static HttpClient client = HttpClient.newHttpClient();
    //parsing response to Food object using Jackson
    private static Optional<Food> parseResults(byte[] results) {
        Food food = new Food();
        Optional<Food> opt = Optional.ofNullable(food);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> foodData = new HashMap<String, String>();
        //handling exceptions
        try { 
        JsonNode info = mapper.readValue(results, JsonNode.class);
        JsonNode parsedInfo = info.get("parsed").get(0);
        if (parsedInfo != null) {
            JsonNode foodInfo = parsedInfo.get("food");
            JsonNode nutrientInfo = foodInfo.get("nutrients");
            String foodName = foodInfo.get("label").asText();
            String foodKcal = nutrientInfo.get("ENERC_KCAL").asText();
            foodData.put("name", foodName);
            foodData.put("kcal", foodKcal);
            food.setName(foodName);
            food.setKcal(Long.parseLong(foodKcal));
        }
        } catch (StreamReadException exception ){
            exception.printStackTrace();
        } catch (DatabindException exception ) {
            exception.printStackTrace();
        } catch (IOException exception ) {
            exception.printStackTrace();
        }
        return opt;
} 
    public Optional<Food> getFoodByName(String name) {
        // String query = String.format("?app_id=%1$s&api_key=%2$s&ingr=%3$s", APP_ID, API_KEY, name);
        URI uri = URI.create("https://api.edamam.com/api/food-database/v2/parser?app_id=33252eb3&app_key=f5148fc312d4430ece92f86f9ae27e01&ingr="+name);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            byte[] results = response.body();
            Optional<Food> food = parseResults(results);
            return food;
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    };
}