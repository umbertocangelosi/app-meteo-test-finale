package it.test.service;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test.dao.UtenteDAO;
import it.test.dao.Weather_ForecastDAO;
import it.test.dto.UtenteRegistrazioneDTO;
import it.test.dto.Weather_ForecastDTO;
import it.test.model.Utente;
import it.test.model.Weather_Forecast;

@Service
public class Weather_ForecastServiceImp implements Weather_ForecastService {
	@Autowired
	private Weather_ForecastDAO meteoDao;
	
	@Autowired
	private UtenteDAO utenteDao;
	

	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public void insert(Weather_ForecastDTO meteoDTO) {
		
		Weather_Forecast meteo = new Weather_Forecast();
		
		meteo.setCity(meteoDTO.getCity());
	    meteo.setTemperature(meteoDTO.getTemperature());
	    meteo.setFeelsLike(meteoDTO.getFeelsLike());
	    meteo.setDescription(meteoDTO.getDescription());
	    meteo.setCloudiness(meteoDTO.getCloudiness());
	    meteo.setHumidity(meteoDTO.getHumidity());
	    meteo.setPressure(meteoDTO.getPressure());
	    meteo.setWindSpeed(meteoDTO.getWindSpeed());
	    meteo.setWindDirection(meteoDTO.getWindDirection());
	    meteo.setSunrise(meteoDTO.getSunrise());
	    meteo.setSunset(meteoDTO.getSunset());
	    meteo.setForecastDate(meteoDTO.getForecastDate());
	    meteo.setCreatedAt(new Date()); //
	    
	    
	    Optional<Utente> utenteDb =  utenteDao.findById(meteoDTO.getUserID());
	    
	    if(utenteDb.isPresent()) {
	    	Utente utente = utenteDb.get();
	    	meteo.setUser(utente);
	    }
	    
	    meteoDao.save(meteo);
	    
	    
		
		
			

		

	}
}
