package it.test.dao;

import org.springframework.data.repository.CrudRepository;


import it.test.model.Weather_Forecast;

public interface Weather_ForecastDAO extends CrudRepository<Weather_Forecast,Integer> {

}
