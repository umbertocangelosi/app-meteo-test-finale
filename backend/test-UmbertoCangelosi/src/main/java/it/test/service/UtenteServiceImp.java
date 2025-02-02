package it.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import it.test.dao.UtenteDAO;

import it.test.dto.UtenteDTO;
import it.test.dto.UtenteLoginRequestDTO;
import it.test.dto.UtenteRegistrazioneDTO;
import it.test.dto.UtenteShowDTO;

import it.test.model.Utente;

@Service
public class UtenteServiceImp implements UtenteService {

	@Autowired
	private UtenteDAO utenteDao;
	

	

	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public void insert(UtenteRegistrazioneDTO utenteDTO) {
		
		Utente utente = new Utente();
		
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setEmail(utenteDTO.getEmail());
		utente.setCitta(utenteDTO.getCitta());
		
		String sha256hex=DigestUtils.sha256Hex(utenteDTO.getPassword());
		utente.setPassword(sha256hex);
		
		utenteDao.save(utente);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return utenteDao.existsByEmail(email);
	}

	@Override
	public void deleteUser(String email) {

		
		Utente utente = utenteDao.findByEmail(email);
		int id=utente.getId();
		
		Optional<Utente> utenteOption = utenteDao.findById(id);
		
		if(utenteOption.isPresent()) {
			utenteDao.delete(utenteOption.get());
		}
	}	
		

	@Override
	public UtenteDTO getUtenteByEmail(String email) {
	
		Utente utente = utenteDao.findByEmail(email);
		return mapper.map(utente, UtenteDTO.class);
		
	}
		
	
	

	

	@Override
	public List<UtenteShowDTO> getUsers() {
		
		List<Utente> listaUtenti = (List<Utente>) utenteDao.findAll();
		
		List<UtenteShowDTO> listaUtentiDTO = new ArrayList<>();
		
		listaUtenti.forEach(u-> listaUtentiDTO.add(mapper.map(u,UtenteShowDTO.class)));
		
		return listaUtentiDTO;
	}

	@Override
	public boolean loginUtente(UtenteLoginRequestDTO utenteLoginRequestDto) {
		Utente utente = new Utente();
		System.out.println("1");
		utente.setEmail(utenteLoginRequestDto.getEmail());
		System.out.println("2");
		utente.setPassword(utenteLoginRequestDto.getPassword());
		System.out.println("3");
		String sha256hex=DigestUtils.sha256Hex(utente.getPassword());
		System.out.println(sha256hex);
		//tramite il getPassword di utente recupero la password e la passo al metodo che me la hasha
		Utente credenzialiUtente = utenteDao.findByEmailAndPassword(utente.getEmail(), sha256hex);
		System.out.println(credenzialiUtente.getNome());
		System.out.println("5");
		// operatore ternario
		return credenzialiUtente != null ? true : false;
		
	}


	
	
}