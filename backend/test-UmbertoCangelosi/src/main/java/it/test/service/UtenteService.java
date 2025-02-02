package it.test.service;

import java.util.List;


import it.test.dto.UtenteDTO;
import it.test.dto.UtenteLoginRequestDTO;
import it.test.dto.UtenteRegistrazioneDTO;
import it.test.dto.UtenteShowDTO;
import it.test.model.Utente;

public interface UtenteService {

	void insert(UtenteRegistrazioneDTO utenteDTO);
	boolean existsByEmail(String email);
	void deleteUser(String email);
	UtenteDTO getUtenteByEmail(String email);
	//void updateUtenteByEmail(UtenteAggiornamentoDTO utenteDTO);
	List<UtenteShowDTO> getUsers();
	boolean loginUtente(UtenteLoginRequestDTO utenteLoginRequestDto);

}
