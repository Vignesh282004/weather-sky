package com.vignesh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.vignesh.Response.WeatherResponse;

@Controller
public class WeatherController {

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/")
	public String gethome() {
		return "index";
	}

	@GetMapping("/weather")
	public String getWeather(@RequestParam("city") String city, Model model) {
		  String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
		    RestTemplate restTemplate = new RestTemplate();
		    WeatherResponse weatherResponse = null;

		    try {
		        weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
		    } catch (Exception e) {
		        model.addAttribute("error", "Error occurred while fetching weather data. Please Enter Correct City / Country Name.");
		        return "weather";
		    }

		    if (weatherResponse != null && weatherResponse.getName() != null) {
		        model.addAttribute("city", weatherResponse.getName());
		        model.addAttribute("country", weatherResponse.getSys().getCountry());
		        model.addAttribute("weatherDescription", weatherResponse.getWeather().get(0).getDescription());
		        model.addAttribute("temperature", weatherResponse.getMain().getTemp());
		        model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
		        model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());

		        String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
		        model.addAttribute("weatherIcon", weatherIcon);
		    } else {
		        model.addAttribute("error", "City not found or invalid city name.");
		    }

		    return "weather";
	}
}