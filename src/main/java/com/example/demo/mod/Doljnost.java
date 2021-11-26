package com.example.demo.mod;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="doljnost")
public class Doljnost {

	@Column(name = "key_dolj", nullable = false, length = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int key_dolj;

	@Column(name = "name", nullable = true, length = 255)
	private String name;

	@OneToMany(mappedBy = "key_doljFK", targetEntity = Rabotnik.class)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Rabotnik> rabotnik;

	private void setKey_dolj(int value) {
		this.key_dolj = value;
	}

	public int getKey_dolj() {
		return key_dolj;
	}

	public String getName() {
		return name;
	}
	public Doljnost() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public Doljnost(int key_dolj, String name) {
		this.key_dolj = key_dolj;
		this.name = name;
	}
}
