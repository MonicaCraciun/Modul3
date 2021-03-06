package com.application.modul3.exemplary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	// @Query(value = "SELECT exemplary FROM exemplary exemplary inner join
	// exemplary.book book WHERE book.id = ?1")
	List<Exemplary> findByBookId(Integer bookId);

	@Query(value = "SELECT exemplary FROM exemplary exemplary inner join exemplary.book book WHERE book.id = ?3 AND exemplary.id NOT IN (SELECT ex.id FROM appointment ap JOIN ap.exemplary ex WHERE (ap.startDate BETWEEN ?1 and ?2) OR (ap.endDate BETWEEN ?1 AND ?2) OR (?1 BETWEEN ap.startDate AND ap.endDate) OR (?2 BETWEEN ap.startDate AND ap.endDate))")
	List<Exemplary> getExemplariesForPeriod(LocalDate startDate, LocalDate endDate, Integer bookId);
}
