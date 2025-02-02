package it.test.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;


import it.test.dto.UtenteRegistrazioneDTO;
import it.test.dto.Weather_ForecastDTO;
import it.test.model.Utente;
import it.test.service.Weather_ForecastService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("meteo")
public class Weather_ForecastController {

	@Autowired
	private Weather_ForecastService meteoService;

	@POST
	@Path("/registrazione")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response userRegistration(@RequestBody Weather_ForecastDTO meteoDTO) {

		try {
			meteoService.insert(meteoDTO);
			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {
			System.err.println(e);
			return Response.status(Status.BAD_REQUEST).build();
		}

	}
}
