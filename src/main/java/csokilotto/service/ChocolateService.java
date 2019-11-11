package csokilotto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csokilotto.dbr.Chocolate;
import csokilotto.repository.ChocolateRepository;

@Service
public class ChocolateService {
	private ChocolateRepository chocorepo;

	@Autowired
	public void setChocorepo(ChocolateRepository chocorepo) {
		this.chocorepo = chocorepo;
	}

	/**
	 * Egy adott id alapján visszaadja a megfelelő rekordot
	 * @param id a keresett id
	 * @return a megkapott Chocolate rekord;
	 */
	public Chocolate findById(Long id) {

		return chocorepo.findById(id);
	}
	
	/**TODO
	 * csokik keresése név alapján
	 * @param name a keresett név
	 * @return
	 */
	public Chocolate findByName(String name) {

		return chocorepo.findByName(name);
	}

	/**
	 * Visszaadja a az összes csokit.
	 * @return a visszaadott csokik.
	 */
	public Iterable<Chocolate> findAll() {
		return chocorepo.findAll();
	}
}
