package csokilotto.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class pa_Chocolate {

	private String name;
	private String taste;
	private String type;
	private float weight;
	private String manufacturer;
	private String picture;

	public pa_Chocolate() {
		super();
	}
	

	public pa_Chocolate(String name, String taste, String type, float weight, String manufacturer, String picture) {
		super();
		this.name = name;
		this.taste = taste;
		this.type = type;
		this.weight = weight;
		this.manufacturer = manufacturer;
		this.picture = picture;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
