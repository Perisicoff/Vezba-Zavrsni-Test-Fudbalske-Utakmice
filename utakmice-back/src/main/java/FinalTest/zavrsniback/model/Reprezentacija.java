package FinalTest.zavrsniback.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reprezentacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String naziv = "";

	@Column(unique = true, nullable = false)
	private String skraceniNaziv = "";

	@OneToMany(mappedBy = "reprezentacija")
	private List<Igrac> igraci = new ArrayList<>();

	@OneToMany(mappedBy = "reprezentacijaA")
	private List<Utakmica> utakmiceA = new ArrayList<>();

	@OneToMany(mappedBy = "reprezentacijaB")
	private List<Utakmica> utakmiceB = new ArrayList<>();

	public Reprezentacija() {
	}

	public Reprezentacija(String naziv, String skraceniNaziv, List<Igrac> igraci, List<Utakmica> utakmiceA,
			List<Utakmica> utakmiceB) {
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.igraci = igraci;
		this.utakmiceA = utakmiceA;
		this.utakmiceB = utakmiceB;
	}

	public Reprezentacija(Long id, String naziv, String skraceniNaziv, List<Igrac> igraci, List<Utakmica> utakmiceA,
			List<Utakmica> utakmiceB) {
		this.id = id;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.igraci = igraci;
		this.utakmiceA = utakmiceA;
		this.utakmiceB = utakmiceB;
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
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * @param naziv the naziv to set
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * @return the skraceniNaziv
	 */
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	/**
	 * @param skraceniNaziv the skraceniNaziv to set
	 */
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	/**
	 * @return the igraci
	 */
	public List<Igrac> getIgraci() {
		return igraci;
	}

	/**
	 * @param igraci the igraci to set
	 */
	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}

	/**
	 * @return the utakmiceA
	 */
	public List<Utakmica> getUtakmiceA() {
		return utakmiceA;
	}

	/**
	 * @param utakmiceA the utakmiceA to set
	 */
	public void setUtakmiceA(List<Utakmica> utakmiceA) {
		this.utakmiceA = utakmiceA;
	}

	/**
	 * @return the utakmiceB
	 */
	public List<Utakmica> getUtakmiceB() {
		return utakmiceB;
	}

	/**
	 * @param utakmiceB the utakmiceB to set
	 */
	public void setUtakmiceB(List<Utakmica> utakmiceB) {
		this.utakmiceB = utakmiceB;
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
		if (!(obj instanceof Reprezentacija)) {
			return false;
		}
		Reprezentacija other = (Reprezentacija) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reprezentacija [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", igraci="
				+ igraci + ", utakmiceA=" + utakmiceA + ", utakmiceB=" + utakmiceB + "]";
	}

}
