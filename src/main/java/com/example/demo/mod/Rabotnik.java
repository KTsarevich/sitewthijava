package com.example.demo.mod;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="rabotnik")
public class Rabotnik {
	public Rabotnik() {
	}
	
	@Column(name="fio", nullable=true, length=255)	
	private String fio;
	
	@Column(name="zarpalta", nullable=true, length=10)	
	private Integer zarpalta;
	
	@Column(name="staj", nullable=true, length=10)	
	private Integer staj;
	
	@ManyToOne(targetEntity=Doljnost.class)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	@JoinColumns(value={ @JoinColumn(name="key_doljFK", referencedColumnName="key_dolj", nullable=false) })
	private Doljnost key_doljFK;
	
	@Column(name="key_rabotnika", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="RABOTNIK_KEY_RABOTNIKA_GENERATOR")	
	@GenericGenerator(name="RABOTNIK_KEY_RABOTNIKA_GENERATOR", strategy="native")
	private Integer key_rabotnika;
	
	@OneToMany(mappedBy="id_rabotnikFK", targetEntity=Zakaz_rabotnik.class)	
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Zakaz_rabotnik> zakaz_rabotnik;

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public Integer getZarpalta() {
		return zarpalta;
	}

	public void setZarpalta(Integer zarpalta) {
		this.zarpalta = zarpalta;
	}

	public Integer getStaj() {
		return staj;
	}

	public void setStaj(Integer staj) {
		this.staj = staj;
	}

	public Doljnost getKey_doljFK() {
		return key_doljFK;
	}

	public void setKey_doljFK(Doljnost key_doljFK) {
		this.key_doljFK = key_doljFK;
	}

	public int getKey_rabotnika() {
		return key_rabotnika;
	}


	public Rabotnik(String fio, Integer zarpalta, Integer staj, Doljnost key_doljFK, Integer key_rabotnika) {
		this.fio = fio;
		this.zarpalta = zarpalta;
		this.staj = staj;
		this.key_doljFK = key_doljFK;
		this.key_rabotnika = key_rabotnika;
	}

	public void setKey_rabotnika(int key_rabotnika) {
		this.key_rabotnika = key_rabotnika;
	}
}
