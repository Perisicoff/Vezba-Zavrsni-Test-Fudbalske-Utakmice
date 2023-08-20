package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Reprezentacija;
import FinalTest.zavrsniback.service.ReprezentacijaService;
import FinalTest.zavrsniback.support.ReprezentacijaToReprezentacijaDTO;
import FinalTest.zavrsniback.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReprezentacijaController {

	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@Autowired
	private ReprezentacijaToReprezentacijaDTO toReprezentacijaDTO;

	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll() {

		List<Reprezentacija> formati = reprezentacijaService.findAll();

		return new ResponseEntity<>(toReprezentacijaDTO.convert(formati), HttpStatus.OK);
	}

}
