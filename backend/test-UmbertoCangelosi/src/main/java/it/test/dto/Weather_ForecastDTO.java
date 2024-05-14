package it.test.dto;

import java.util.Date;

import it.test.model.Utente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Weather_ForecastDTO {

	

	private int userID;

	private String city;

	private Double temperature;

	private Double feelsLike;

	private String description;

	private Double cloudiness;

	private Double humidity;

	private Double pressure;

	private Double windSpeed;

	private Double windDirection;

	private Date sunrise;

	private Date sunset;

	private Date forecastDate;

	private Date createdAt;



	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(Double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(Double cloudiness) {
		this.cloudiness = cloudiness;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Double windDirection) {
		this.windDirection = windDirection;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
