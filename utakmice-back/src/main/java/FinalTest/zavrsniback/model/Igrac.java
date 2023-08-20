package FinalTest.zavrsniback.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Igrac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String ime = "";

	@Column(nullable = false)
	private String prezime = "";

	@Column
	private int postignutiGolovi;

	@ManyToOne
	private Reprezentacija reprezentacija;

	public Igrac() {
	}

	public Igrac(String ime, String prezime, int postignutiGolovi, Reprezentacija reprezentacija) {
		this.ime = ime;
		this.prezime = prezime;
		this.postignutiGolovi = postignutiGolovi;
		this.reprezentacija = reprezentacija;
	}

	public Igrac(Long id, String ime, String prezime, int postignutiGolovi, Reprezentacija reprezentacija) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.postignutiGolovi = postignutiGolovi;
		this.reprezentacija = reprezentacija;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * @param prezime the prezime to set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * @return the postignutiGolovi
	 */
	public int getPostignutiGolovi() {
		return postignutiGolovi;
	}

	/**
	 * @param postignutiGolovi the postignutiGolovi to set
	 */
	public void setPostignutiGolovi(int postignutiGolovi) {
		this.postignutiGolovi = postignutiGolovi;
	}

	/**
	 * @return the reprezentacija
	 */
	public Reprezentacija getReprezentacija() {
		return reprezentacija;
	}

	/**
	 * @param reprezentacija the reprezentacija to set
	 */
	public void setReprezentacija(Reprezentacija reprezentacija) {
		this.reprezentacija = reprezentacija;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Igrac)) {
			return false;
		}
		Igrac other = (Igrac) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", postignutiGolovi=" + postignutiGolovi
				+ ", reprezentacija=" + reprezentacija + "]";
	}

}
