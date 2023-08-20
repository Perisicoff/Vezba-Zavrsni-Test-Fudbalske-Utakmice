package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Reprezentacija;

public interface ReprezentacijaService {

	Reprezentacija findOne(Long id);

	List<Reprezentacija> findAll();
}
