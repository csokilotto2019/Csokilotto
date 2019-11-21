package csokilotto.dbr;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

/**
 * Colors that can be used
 */
enum Choc_Type {
	/**
	 * Milk chocolate 1
	 */
	MILK,
	/**
	 * Dark chocolate 2
	 */
	DARK,
	/**
	 * White chocolate 3
	 */
	WHITE,;
}

@Entity
public class Chocolate {
	@GeneratedValue
	@Id
	// @Column(name = "choc_id")
	private Long id;
	@Column(name = "choc_name")
	private String name;
	@Column(name = "choc_taste")
	private String taste;
	@Column(name = "choc_type")
	@Enumerated(EnumType.STRING)
	private Choc_Type type;
	@Column(name = "choc_weight")
	private float weight;
	@Column(name = "choc_manufacturer")
	private String manufacturer;
	@Column(name = "choc_pic")
	private String picture;
	@Column(name = "choc_remaining")
	private int remaining;

	@OneToMany(mappedBy = "chocolate", cascade = CascadeType.ALL)
	private List<Message> messages;

	public Chocolate() {

	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public Long getId() {
		return id;
	}

	public Chocolate(String name, String taste, Choc_Type type, float weight, String manufacturer) {
		this.name = name;
		this.taste = taste;
		this.type = type;
		this.weight = weight;
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public String getTaste() {
		return taste;
	}

	public Choc_Type getType() {
		return type;
	}
	public String getTypetoString() {
		return type.toString();
	}

	public float getWeight() {
		return weight;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	

	public String getPicture() {
		return picture;
	}

	@Override
	public String toString() {
		return "Chocolate [name=" + name + ", taste=" + taste + ", type=" + type + ", weight=" + weight
				+ ", manufacturer=" + manufacturer + "]";
	}
	

}
