import React, { useState, useEffect, useContext } from 'react';
import { AuthContext } from '../../context/AuthContext';
import { getWeatherData, saveWeatherData } from '../../services/RESTService';

export function WeatherComponent() {
  const { user } = useContext(AuthContext);
  const city = user ? user.citta : null;

  const [weatherData, setWeatherData] = useState(null);
  const [error, setError] = useState(null);
  const [saveSuccess, setSaveSuccess] = useState(false); // State per gestire il successo del salvataggio

  const API_KEY = 'd7b42419d9bb06df90bae5efffa2a333'; // Sostituisci 'YOUR_API_KEY' con la tua chiave API OpenWeatherMap

  useEffect(() => {
    if (city) {
      fetchWeatherData();
    }
  }, [city]);

  const fetchWeatherData = async () => {
    try {
      const response = await getWeatherData(city, API_KEY);
      const data = await response.json();
      setWeatherData(data);
      setError(null);
    } catch (error) {
      setError(error.message);
    }
  };

  const handleSaveToDatabase = async () => {
    if (weatherData) {
      const formatDate = (dateString) => {
        const date = new Date(dateString);
        return date.toISOString();
      };
  
      const jsonData = {
        userID: user.id,
        city: city,
        temperature: weatherData.main.temp,
        feelsLike: weatherData.main.feels_like,
        description: weatherData.weather[0].description,
        cloudiness: weatherData.clouds.all,
        humidity: weatherData.main.humidity,
        pressure: weatherData.main.pressure,
        windSpeed: weatherData.wind.speed,
        windDirection: weatherData.wind.deg,
        sunrise: formatDate(weatherData.sys.sunrise * 1000),
        sunset: formatDate(weatherData.sys.sunset * 1000),
        forecastDate: formatDate(new Date()),
        createdAt: formatDate(new Date())
      };
  
      try {
        const response = await saveWeatherData(jsonData);
        if (response.ok) {
          console.log("Dati salvati nel database con successo!");
          setSaveSuccess(true); // Imposta il successo del salvataggio
        } else {
          console.error("Errore durante il salvataggio dei dati nel database:", response.statusText);
        }
      } catch (error) {
        console.error("Si è verificato un errore durante la chiamata API:", error.message);
      }
    } else {
      console.error("Impossibile salvare i dati nel database: weatherData non definito");
    }
  };

  return (
    <div className="container">
      <h2 className="mt-3">Weather in {city}</h2>
      <table className="table">
        <thead className="thead-dark">
          <tr>
            <th>Temperature (°C)</th>
            <th>Feels like (°C)</th>
            <th>Description</th>
            <th>Cloudiness (%)</th>
            <th>Humidity (%)</th>
            <th>Pressure (hPa)</th>
            <th>Wind Speed (m/s)</th>
            <th>Wind Direction (°)</th>
            <th>Sunrise</th>
            <th>Sunset</th>
            <th>Actions</th> {/* Nuova colonna per il bottone */}
          </tr>
        </thead>
        <tbody>
          {weatherData && (
            <tr>
              <td>{weatherData.main.temp}</td>
              <td>{weatherData.main.feels_like}</td>
              <td>{weatherData.weather[0].description}</td>
              <td>{weatherData.clouds.all}</td>
              <td>{weatherData.main.humidity}</td>
              <td>{weatherData.main.pressure}</td>
              <td>{weatherData.wind.speed}</td>
              <td>{weatherData.wind.deg}</td>
              <td>{new Date(weatherData.sys.sunrise * 1000).toLocaleTimeString()}</td>
              <td>{new Date(weatherData.sys.sunset * 1000).toLocaleTimeString()}</td>
              <td>
                <button className="btn btn-primary" onClick={handleSaveToDatabase}>Save</button>
              </td> {/* Bottone per salvare i dati nel database */}
            </tr>
          )}
        </tbody>
      </table>
      {saveSuccess && <p className="text-success">Salvataggio avvenuto con successo!</p>} {/* Messaggio di successo */}
      {error && <p>Error: {error}</p>}
    </div>
  );
}
