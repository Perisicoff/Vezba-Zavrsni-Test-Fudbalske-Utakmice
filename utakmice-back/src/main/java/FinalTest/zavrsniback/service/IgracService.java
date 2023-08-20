package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Igrac;

public interface IgracService {

	Igrac findOne(Long id);

	List<Igrac> findAll();

	Igrac noviGo(Igrac igrac);
	
	Igrac najboljiStrelac();
	
	List<Igrac> findByReprezentacijaId(Long reprezentacijaId);

}
