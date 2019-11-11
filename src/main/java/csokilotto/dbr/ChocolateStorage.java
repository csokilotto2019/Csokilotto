package csokilotto.dbr;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Ebben az osztályban tartjuk nyilván, hogy melyik csokiból hány darab van.
 * 
 * @author Sanyi
 *
 */
@Entity
public class ChocolateStorage {
	
	@GeneratedValue
	@Id
	private Long id;
	/**
	 * Megmaradt csokik száma
	 */
	private int remaining;
	private Timestamp lastmodify;
	
	
	

}
