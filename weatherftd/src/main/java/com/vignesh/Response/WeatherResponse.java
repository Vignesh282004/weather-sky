package com.vignesh.Response;

import java.util.List;

public class WeatherResponse {
	
	private String name;
	private Sys sys;
	private List<Weather> weather;
	private Main main;
	private Wind wind;
	
	   public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Sys getSys() {
	        return sys;
	    }

	    public void setSys(Sys sys) {
	        this.sys = sys;
	    }

	    public List<Weather> getWeather() {
	        return weather;
	    }

	    public void setWeather(List<Weather> weather) {
	        this.weather = weather;
	    }

	    public Main getMain() {
	        return main;
	    }

	    public void setMain(Main main) {
	        this.main = main;
	    }

	    public Wind getWind() {
	        return wind;
	    }

	    public void setWind(Wind wind) {
	        this.wind = wind;
	    }
}