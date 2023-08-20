package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Igrac;
import FinalTest.zavrsniback.repository.IgracRepository;
import FinalTest.zavrsniback.service.IgracService;

@Service
public class JPAIgracService implements IgracService {

	@Autowired
	private IgracRepository igracRepository;

	@Override
	public Igrac findOne(Long id) {
		Optional<Igrac> opcijaIgrac = igracRepository.findById(id);
		if (opcijaIgrac.isPresent()) {
			return opcijaIgrac.get();
		}
		return null;
	}

	@Override
	public List<Igrac> findAll() {
		return igracRepository.findAll();
	}

	@Override
	public Igrac noviGo(Igrac igrac) {
		Igrac igracNoviGo = findOne(igrac.getId());
		if (igracNoviGo != null) {
			int stariGolovi = igracNoviGo.getPostignutiGolovi();
			int noviGolovi = stariGolovi + 1;
			igracNoviGo.setPostignutiGolovi(noviGolovi);
			igracRepository.save(igracNoviGo);
			return igracNoviGo;
		}
		return null;
	}

	@Override
	public List<Igrac> findByReprezentacijaId(Long reprezentacijaId) {
		return igracRepository.findByReprezentacijaId(reprezentacijaId);
	}

	@Override
	public Igrac najboljiStrelac() {
		List<Igrac> igraci = igracRepository.findAll();
		Igrac najboljiStrelac = null;
		int najviseGolova = 0;
		for (Igrac igrac1 : igraci) {
			if (igrac1.getPostignutiGolovi() > najviseGolova) {
				najviseGolova = igrac1.getPostignutiGolovi();
				najboljiStrelac = igrac1;
			}
		}

		return najboljiStrelac;
	}

}
