package FinalTest.zavrsniback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Long> {

	@Query("SELECT u FROM Utakmica u WHERE"
			+ "(:reprezentacijaAId IS NULL OR u.reprezentacijaA.id LIKE :reprezentacijaAId) AND"
			+ "(:reprezentacijaBId IS NULL OR u.reprezentacijaB.id LIKE :reprezentacijaBId)")
	Page<Utakmica> search(@Param("reprezentacijaAId") Long reprezentacijaAId,
			@Param("reprezentacijaBId") Long reprezentacijaBId, Pageable pageable);
}
