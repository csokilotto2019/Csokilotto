package csokilotto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import csokilotto.dbr.Chocolate;
import csokilotto.dbr.Message;

@Repository
public interface ChocolateRepository extends CrudRepository<Chocolate, Long> {

	// @Query(value = "select c from chocolate c where c.id = :id")
	// @Query(value = "select * from chocolate where id = ?1", nativeQuery = true)
	Chocolate findById(Long id);

	// @Query(value = "select s from chocolate s where s.name = :name")
	Chocolate findByName(String name);
	
}
