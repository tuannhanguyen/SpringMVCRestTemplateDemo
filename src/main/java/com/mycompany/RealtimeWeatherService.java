package com.mycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class RealtimeWeatherService {

    @Value("${api.weather.realtime.get.uri}")
    private String realtimeWeatherURI;

    @Autowired
    private RestTemplate restTemplate;

    public RealtimeWeather getRealtimeWeather() throws RealtimeWeatherServiceException {
        try {

            return restTemplate.getForObject(realtimeWeatherURI, RealtimeWeather.class);

        } catch (RestClientResponseException e) {
            e.printStackTrace();
            throw new RealtimeWeatherServiceException("Error calling Get Realtime Weather API: " + e.getMessage());
        }
    }
}
