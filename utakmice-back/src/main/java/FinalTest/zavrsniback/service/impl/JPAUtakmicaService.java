package FinalTest.zavrsniback.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Utakmica;
import FinalTest.zavrsniback.repository.UtakmicaRepository;
import FinalTest.zavrsniback.service.UtakmicaService;

@Service
public class JPAUtakmicaService implements UtakmicaService {

	@Autowired
	private UtakmicaRepository utakmicaRepository;

	@Override
	public Utakmica findOne(Long id) {
		Optional<Utakmica> opcijaUtakmica = utakmicaRepository.findById(id);
		if (opcijaUtakmica.isPresent()) {
			return opcijaUtakmica.get();
		}
		return null;
	}

	@Override
	public Page<Utakmica> findAll(int brojStranice) {
		return utakmicaRepository.findAll(PageRequest.of(brojStranice, 3));
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica delete(Long id) {
		Utakmica utakmica = findOne(id);
		if (utakmica != null) {
			utakmicaRepository.deleteById(id);
			return utakmica;
		}
		return null;
	}

	@Override
	public Utakmica promenaRezultataA(Utakmica utakmica) {
		Utakmica utakmicaZaIzmenu = findOne(utakmica.getId());
		if (utakmicaZaIzmenu != null) {
			int stariRezumtat = utakmicaZaIzmenu.getGoloviA();
			int noviRezultat = stariRezumtat + 1;
			utakmicaZaIzmenu.setGoloviA(noviRezultat);
			utakmicaRepository.save(utakmicaZaIzmenu);
			return utakmicaZaIzmenu;
		}
		return null;
	}

	@Override
	public Utakmica promenaRezultataB(Utakmica utakmica) {
		Utakmica utakmicaZaIzmenu = findOne(utakmica.getId());
		if (utakmicaZaIzmenu != null) {
			int stariRezumtat = utakmicaZaIzmenu.getGoloviB();
			int noviRezultat = stariRezumtat + 1;
			utakmicaZaIzmenu.setGoloviB(noviRezultat);
			utakmicaRepository.save(utakmicaZaIzmenu);
			return utakmicaZaIzmenu;
		}
		return null;
	}

	@Override
	public Page<Utakmica> search(Long reprezentacijaAId, Long reprezentacijaBId, int brojStranice) {
		return utakmicaRepository.search(reprezentacijaAId, reprezentacijaBId, PageRequest.of(brojStranice, 2));
	}

}
