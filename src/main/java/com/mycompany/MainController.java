package com.mycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private RealtimeWeatherService service;

    @GetMapping("")
    public String viewHomePage(Model model) {
        try {
            RealtimeWeather realtimeWeather = service.getRealtimeWeather();
            model.addAttribute("realtimeWeather", realtimeWeather);

            return "index";
        } catch (RealtimeWeatherServiceException e) {
            model.addAttribute("message", e.getMessage());

            return "error";
        }
    }
}
