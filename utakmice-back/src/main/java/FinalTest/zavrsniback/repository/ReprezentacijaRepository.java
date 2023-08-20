package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Reprezentacija;

@Repository
public interface ReprezentacijaRepository extends JpaRepository<Reprezentacija, Long> {

}
