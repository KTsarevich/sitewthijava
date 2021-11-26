package com.example.demo.mod;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="zakaz")
public class Zakaz implements Serializable {
	public Zakaz() {
	}
	
	@Column(name="key_zakaz", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ZAKAZ_KEY_ZAKAZ_GENERATOR")	
	@GenericGenerator(name="ZAKAZ_KEY_ZAKAZ_GENERATOR", strategy="native")
	private int key_zakaz;
	
	@Column(name="adress", nullable=true, length=255)	
	private String adress;
	
	@OneToOne(mappedBy="key_zakazFK", targetEntity=Zakaz_rabotnik.class, fetch=FetchType.LAZY)	
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	private Zakaz_rabotnik zakaz_rabotnik;

	public int getKey_zakaz() {
		return key_zakaz;
	}

	public void setKey_zakaz(int key_zakaz) {
		this.key_zakaz = key_zakaz;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Zakaz(int key_zakaz, String adress) {
		this.key_zakaz = key_zakaz;
		this.adress = adress;
	}
}
