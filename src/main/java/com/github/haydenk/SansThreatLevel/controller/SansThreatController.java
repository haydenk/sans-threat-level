package com.github.haydenk.SansThreatLevel.controller;

import com.github.haydenk.SansThreatLevel.factory.SansThreatFactory;
import com.github.haydenk.SansThreatLevel.model.SansThreat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class SansThreatController {
    @GetMapping
    public SansThreat fetch() {

        String threatLevel;
        String sansUrl = "https://isc.sans.edu/infocon.txt";

        try {
            URL url = new URL(sansUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            threatLevel = content.toString();

        } catch (IOException e) {
            threatLevel = e.getMessage();
        }

        return SansThreatFactory.create(sansUrl, threatLevel);
    }
}
