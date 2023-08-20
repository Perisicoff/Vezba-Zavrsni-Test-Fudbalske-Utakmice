package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Reprezentacija;
import FinalTest.zavrsniback.repository.ReprezentacijaRepository;
import FinalTest.zavrsniback.service.ReprezentacijaService;

@Service
public class JPAReprezentacijaService implements ReprezentacijaService {

	@Autowired
	private ReprezentacijaRepository reprezentacijaRepository;

	@Override
	public Reprezentacija findOne(Long id) {
		Optional<Reprezentacija> opcijaReprezentacija = reprezentacijaRepository.findById(id);
		if (opcijaReprezentacija.isPresent()) {
			return opcijaReprezentacija.get();
		}
		return null;
	}

	@Override
	public List<Reprezentacija> findAll() {
		return reprezentacijaRepository.findAll();
	}

}
