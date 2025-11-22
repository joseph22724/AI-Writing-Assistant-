package org.example.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.example.util.ConfigManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class APIService {

    private final OkHttpClient client;
    private final Gson gson;
    private final String apiKey;
    private final String apiUrl;

    public APIService() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        this.gson = new Gson();
        this.apiKey = ConfigManager.getInstance().get("api.key");
        this.apiUrl = ConfigManager.getInstance().get("api.url");
    }

    public String generateText(String systemInstruction, String userText) throws IOException {
        // Gemini structure: { "contents": [ { "parts": [ { "text": "..." } ] } ] }

        JsonObject jsonBody = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonObject contentObj = new JsonObject();
        JsonArray partsArray = new JsonArray();
        JsonObject textPart = new JsonObject();


        String fullPrompt = systemInstruction + "\n\nUser Input:\n" + userText;

        textPart.addProperty("text", fullPrompt);
        partsArray.add(textPart);
        contentObj.add("parts", partsArray);
        contentsArray.add(contentObj);
        jsonBody.add("contents", contentsArray);

        String urlWithKey = apiUrl + "?key=" + apiKey;

        RequestBody body = RequestBody.create(jsonBody.toString(), MediaType.get("application/json"));
        Request request = new Request.Builder().url(urlWithKey).post(body).build();


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + " Body: " + response.body().string());
            }

            String responseBody = response.body().string();
            JsonObject responseJson = gson.fromJson(responseBody, JsonObject.class);

            // parse the nested json from gemini
            try{
                return responseJson.getAsJsonArray("candidates")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();

            } catch (Exception e) {
                return "Error parsing Gemini response. Raw: " + responseBody;
            }
        }
    }
}