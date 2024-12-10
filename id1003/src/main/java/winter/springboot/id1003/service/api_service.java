package winter.springboot.id1003.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import winter.springboot.id1003.model.entity_class;
import winter.springboot.id1003.repository.stock_repository;

@Service
public class api_service {
    private String stringurl = "https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2024-12-09/2024-12-10?apiKey=Pj2sScjXDkRmxrVTEQNMKZv8xpDw2C8J";

    @Autowired
    private stock_repository repository;

    public void getDetails(){
        try{
            URL url = new URL(stringurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json, utf-8");
            System.out.println("Response Code: " + connection.getResponseCode());
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    response.append(inputLine);
                }

                reader.close();

                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootnode = mapper.readTree(response.toString());

                String stockname = rootnode.get("ticker").asText();
                JsonNode resultnode = rootnode.get("results").get(0);
                double openprice = resultnode.get("o").asDouble();
                double closeprice = resultnode.get("c").asDouble();

                entity_class entity = new entity_class();
                entity.setStockname(stockname);
                entity.setOpenprice(openprice);
                entity.setCloseprice(closeprice);

                repository.save(entity);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
