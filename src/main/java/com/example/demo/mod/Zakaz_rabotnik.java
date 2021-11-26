package com.example.demo.mod;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="zakaz_rabotnik")
public class Zakaz_rabotnik implements Serializable {
	public Zakaz_rabotnik() {
	}
	
	@PrimaryKeyJoinColumn	
	@OneToOne(optional=false, targetEntity=Zakaz.class, fetch=FetchType.LAZY)	
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value={ @JoinColumn(name="key_zakazFK", referencedColumnName="key_zakaz", nullable=false) })
	private Zakaz key_zakazFK;
	
	@Column(name="key_zakazFK", nullable=false, insertable=false, updatable=false)	
	@Id	
	@GeneratedValue(generator="ZAKAZ_RABOTNIK_KEY_ZAKAZFKID_GENERATOR")	
	@GenericGenerator(name="ZAKAZ_RABOTNIK_KEY_ZAKAZFKID_GENERATOR", strategy="foreign", parameters= @org.hibernate.annotations.Parameter(name="property", value="key_zakazFK"))
	private int key_zakazFKId;
	
	private void setKey_zakazFKId(int value) {
		this.key_zakazFKId = value;
	}
	
	public int getKey_zakazFKId() {
		return key_zakazFKId;
	}
	
	@ManyToOne(targetEntity=Rabotnik.class, fetch=FetchType.LAZY)	
	@Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value={ @JoinColumn(name="id_rabotnikFK", referencedColumnName="key_rabotnika", nullable=false) })

	private Rabotnik id_rabotnikFK;

	public Zakaz getKey_zakazFK() {
		return key_zakazFK;
	}

	public void setKey_zakazFK(Zakaz key_zakazFK) {
		this.key_zakazFK = key_zakazFK;
	}

	public Rabotnik getId_rabotnikFK() {
		return id_rabotnikFK;
	}

	public void setId_rabotnikFK(Rabotnik id_rabotnikFK) {
		this.id_rabotnikFK = id_rabotnikFK;
	}
}
