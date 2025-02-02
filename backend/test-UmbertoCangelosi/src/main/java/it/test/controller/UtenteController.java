package it.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.glassfish.jersey.server.ContainerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.security.Keys;

import it.test.dto.UtenteDTO;
import it.test.dto.UtenteLoginRequestDTO;
import it.test.dto.UtenteLoginResponseDTO;
import it.test.dto.UtenteRegistrazioneDTO;
import it.test.dto.UtenteShowDTO;
import it.test.service.UtenteService;
import io.jsonwebtoken.*;
import java.security.Key;
import java.time.LocalDateTime;


import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Path("/utenti") //prima utente
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	

	
	@POST
	@Path("/registrazione")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response userRegistration(@Valid @RequestBody UtenteRegistrazioneDTO utenteDTO) {
		
		try {
			if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}", utenteDTO.getPassword())) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			if(utenteService.existsByEmail(utenteDTO.getEmail())) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			utenteService.insert(utenteDTO);
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
			System.err.println(e);
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	

	@GET
	@Path("utente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selezionaUtenteByEmail(@QueryParam("email") String email) {
	    try {
	        if (email != null && !email.isEmpty()) {
	            // Se l'email non è vuota o nulla, chiamiamo il servizio per ottenere l'utente
	            UtenteDTO utenteDto = utenteService.getUtenteByEmail(email);
	            // Restituiamo una risposta OK con l'oggetto UtenteDTO come corpo della risposta
	            return Response.ok().entity(utenteDto).build();
	        }
	        // Se l'email è vuota o nulla, restituiamo una risposta BAD_REQUEST
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    } catch (Exception e) {
	        // Se si verifica un'eccezione durante l'esecuzione, restituiamo una risposta BAD_REQUEST
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	}
	

	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllUsers() {
		try {
			List<UtenteShowDTO> utenti = utenteService.getUsers();
			return Response.ok().entity(utenti).build();
		} catch (Exception e) {

			Response.status(Response.Status.BAD_REQUEST).build();
		}

		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(UtenteLoginRequestDTO utenteLoginRequestDto){
		try {
			if(utenteService.loginUtente(utenteLoginRequestDto)) {
				return Response.ok(issueToken(utenteLoginRequestDto.getEmail())).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	
	
	private UtenteLoginResponseDTO issueToken(String email){
		// eseguiamo una cifratura attraverso l'algoritmo di crittografia HMAC
		byte[] secretKey= "asocbaseisufvnqunauaouaishdfoabf122373573771796798271314".getBytes();
		
		//crittografia
		Key key = Keys.hmacShaKeyFor(secretKey);
		
		UtenteDTO utente = utenteService.getUtenteByEmail(email);
		
		//claims (informazioni)
		Map<String, Object> map = new HashMap<>();
		map.put("id",utente.getId());
		map.put("email", email);
		map.put("nome",utente.getNome());
		map.put("cognome",utente.getCognome());
		map.put("citta",utente.getCitta());

		Date creationDate = new Date();
		Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));
		// craezione del token firmato con la chiave segreta creata sopra
		String jwtToken = Jwts.builder()
			.setClaims(map) //cosa
			.setIssuer("http://localhost:8080") //dove
			.setIssuedAt(creationDate) //quando viene creato
			.setExpiration(end) //quando finisce
			.signWith(key) //firma con la mia classe segreta 
			.compact(); //compattiamo il token
		
		UtenteLoginResponseDTO token = new UtenteLoginResponseDTO();
		
		token.setToken(jwtToken);
		token.setTokenCreationTime(creationDate);
		token.setTtl(end);
		
		return token;
	}

	
	
	
}