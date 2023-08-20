package FinalTest.zavrsniback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Utakmica;
import FinalTest.zavrsniback.service.UtakmicaService;
import FinalTest.zavrsniback.support.UtakmicaDTOToUtakmica;
import FinalTest.zavrsniback.support.UtakmicaToUtakmicaDTO;
import FinalTest.zavrsniback.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
public class UtakmicaController {

	@Autowired
	private UtakmicaService utakmicaService;

	@Autowired
	private UtakmicaToUtakmicaDTO toUtakmicaDTO;

	@Autowired
	private UtakmicaDTOToUtakmica toUtakmica;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<UtakmicaDTO>> get(@RequestParam(required = false, defaultValue = "") Long reprezentacijaAId,
			@RequestParam(required = false, defaultValue = "") Long reprezentacijaBId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Utakmica> takmicenja = utakmicaService.search(reprezentacijaAId, reprezentacijaBId, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(takmicenja.getTotalPages()));

		return new ResponseEntity<>(toUtakmicaDTO.convert(takmicenja.getContent()), headers, HttpStatus.OK);
	}

//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<UtakmicaDTO> get(@PathVariable Long id) {
		Utakmica utakmica = utakmicaService.findOne(id);

		if (utakmica != null) {
			return new ResponseEntity<>(toUtakmicaDTO.convert(utakmica), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> create(@Valid @RequestBody UtakmicaDTO utakmicaDTO) {
		Utakmica utakmica = toUtakmica.convert(utakmicaDTO);

		if (utakmica.getReprezentacijaA() == null || utakmica.getReprezentacijaB() == null || utakmica.getReprezentacijaA() == utakmica.getReprezentacijaB()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Utakmica sacuvanoUtakmica = utakmicaService.save(utakmica);

		return new ResponseEntity<>(toUtakmicaDTO.convert(sacuvanoUtakmica), HttpStatus.CREATED);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO utakmicaDTO) {

		if (!id.equals(utakmicaDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Utakmica utakmica = toUtakmica.convert(utakmicaDTO);
		Utakmica sacuvanoUtakmica = utakmicaService.update(utakmica);

		return new ResponseEntity<>(toUtakmicaDTO.convert(sacuvanoUtakmica), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Utakmica obrisanaUtakmica = utakmicaService.delete(id);

		if (obrisanaUtakmica != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/noviGoA")
	public ResponseEntity<Void> promenaRezultataA(@PathVariable Long id) {
		Utakmica utakmica = utakmicaService.findOne(id);
		
		if (utakmica == null || utakmica.getReprezentacijaA() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		int stariRezultat = utakmica.getGoloviA();
		int noviRezultat = stariRezultat + 1;
		utakmica.setGoloviA(noviRezultat);
		utakmicaService.save(utakmica);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/noviGoB")
	public ResponseEntity<Void> promenaRezultataB(@PathVariable Long id) {
		Utakmica utakmica = utakmicaService.findOne(id);
		
		if (utakmica == null || utakmica.getReprezentacijaB() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		int stariRezultat = utakmica.getGoloviB();
		int noviRezultat = stariRezultat + 1;
		utakmica.setGoloviB(noviRezultat);
		utakmicaService.save(utakmica);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
