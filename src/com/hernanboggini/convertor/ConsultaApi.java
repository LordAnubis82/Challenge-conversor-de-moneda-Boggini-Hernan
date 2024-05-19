package com.hernanboggini.convertor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Divisas conseguirDivisas(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ac953a9ffa69c49a70ad1a19/latest/USD"))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        }catch (InterruptedException | IOException e){
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Divisas.class);





    }

}
