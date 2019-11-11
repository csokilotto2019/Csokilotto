package csokilotto.service;

/**
 * Az üzenet adatbázimanupulációjához szükséges szolgáltatás
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csokilotto.dbr.Chocolate;
import csokilotto.dbr.Message;
import csokilotto.repository.MessageRepository;

@Service
public class MessageService {
	private MessageRepository messagerepo;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Beállítja a repository-t, hogy tudjuk használni.
	 * @param messagerepo
	 */
	@Autowired
	public void setMessagerepo(MessageRepository messagerepo) {
		this.messagerepo = messagerepo;
	}

	/**
	 * Elmentjük adatbázisba az üzenet rekordot.
	 * 
	 * @param message
	 *            üzenet rekord mely tartalmazza a chocolate objektumot is
	 *            kontextusában és ezáltal a kapcsolatot létrehozza az
	 *            adatbázirekordok között
	 * @return
	 */
	public String saveMess(Message message) {

		messagerepo.save(message);

		return "ok";
	}

	/**
	 * Visszadja egy listában az összes özenetet
	 * 
	 * @return az adatbázisban tárolt összes üzenet
	 */
	public List<Message> findAll() {
		return messagerepo.findAll();

	}

	/**
	 * Visszaadja azon üzenetek listáját melynek címzettjei megegyeznek a megkapott
	 * paraméter.
	 * 
	 * @param email
	 *            az email cím melyre szürni szeretnénk.
	 * @return
	 */
	public List<Message> findByEmail(String email) {
		return messagerepo.findAllByEmailaddress(email);
	}
	
	/**
	 * Egy adott csokihoz elküldött üzeneteket adja vissza.
	 * @param chocolate a csoki amelykhez keressük az üzeneteket
	 * @return a megkapott üzenetek.
	 */
	public List<Message> findByChocolate (Chocolate chocolate){
		return messagerepo.findByChocolate(chocolate);
	}

}
