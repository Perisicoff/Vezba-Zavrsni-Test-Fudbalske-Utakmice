package FinalTest.zavrsniback.service;

import org.springframework.data.domain.Page;

import FinalTest.zavrsniback.model.Utakmica;

public interface UtakmicaService {

	Utakmica findOne(Long id);

	Page<Utakmica> findAll(int brojStranice);
	
	Page<Utakmica> search(Long reprezentacijaAId, Long reprezentacijaBId, int brojStranice);

	Utakmica save(Utakmica utakmica);

	Utakmica update(Utakmica utakmica);
	
	Utakmica promenaRezultataA(Utakmica utakmica);
	
	Utakmica promenaRezultataB(Utakmica utakmica);

	Utakmica delete(Long id);
}
