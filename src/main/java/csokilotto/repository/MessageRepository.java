package csokilotto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import csokilotto.dbr.Chocolate;
import csokilotto.dbr.Message;

/**
 * Az adatázishoz való kommunikációhoz szükséges osztály
 * @author Sanyi
 *
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	
	List<Message> findAllByEmailaddress(String email);
	List<Message> findAll();
	List<Message> findByChocolate(Chocolate chocolate);
	
}
