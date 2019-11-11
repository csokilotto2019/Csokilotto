package csokilotto.dbr;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;

import csokilotto.repository.MessageRepository;

/**
 * Minden üzenet egy csokihoz kapcsolódik amivel tudunk számolni hogy hány
 * csokit sorsoltunk ki és milyen fajtából.
 * 
 * @author Sanyi
 *
 */
@Entity
@Table(name = "smessage")
public class Message {

	/*
	 * TODO ha majd akarunk felhasználóhoz is kötni akkor a kapcsolat elkészítése
	 * itt szükséges.
	 */
	@GeneratedValue
	@Id
	private Long id;
	@Column(name = "mess_emailaddress")
	private String emailaddress;
	@Column(name = "mess_sended")
	@CreationTimestamp
	private Timestamp sended;
	
	/**
	 * A kapcsolt csoki rekord
	 */
	@ManyToOne
	@JoinColumn
	private Chocolate chocolate;

	public Message() {
	}

	public Message(String emailaddress, Chocolate chocolate) {
		this.emailaddress = emailaddress;
		this.chocolate = chocolate;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public Timestamp getSended() {
		return sended;
	}

	public void setSended(Timestamp sended) {
		this.sended = sended;
	}

	public Chocolate getChocolate() {
		return chocolate;
	}

	public void setChocolate(Chocolate chocolate) {
		this.chocolate = chocolate;
	}

}
