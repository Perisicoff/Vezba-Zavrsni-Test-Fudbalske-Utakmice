package FinalTest.zavrsniback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Igrac;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {

	List<Igrac> findByReprezentacijaId(Long reprezentacijaId);
}
