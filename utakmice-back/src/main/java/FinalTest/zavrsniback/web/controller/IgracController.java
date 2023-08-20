package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Igrac;
import FinalTest.zavrsniback.service.IgracService;
import FinalTest.zavrsniback.support.IgracToIgracDTO;
import FinalTest.zavrsniback.web.dto.IgracDTO;

@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {

	@Autowired
	private IgracService igracService;

	@Autowired
	private IgracToIgracDTO toIgracDTO;

	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll() {
		List<Igrac> igraci = igracService.findAll();
		return new ResponseEntity<>(toIgracDTO.convert(igraci), HttpStatus.OK);
	}
	
	@GetMapping(value = "/reprezentacije")
	public ResponseEntity<List<IgracDTO>> getAllByReprezentacijaId(@RequestParam Long reprezentacijaId) {
		List<Igrac> igraci = igracService.findByReprezentacijaId(reprezentacijaId);
		return new ResponseEntity<>(toIgracDTO.convert(igraci), HttpStatus.OK);
	}
	
	@GetMapping(value = "/najboljiStrelac")
	public ResponseEntity<IgracDTO> najboljiStrelac() {
		Igrac najboljiStrelac = igracService.najboljiStrelac();
		return new ResponseEntity<>(toIgracDTO.convert(najboljiStrelac), HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/noviGoIgraca")
	public ResponseEntity<Void> promenaRezultataB(@PathVariable Long id) {
		Igrac igrac = igracService.findOne(id);
		
		if (igrac == null || igrac.getReprezentacija() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		igracService.noviGo(igrac);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
