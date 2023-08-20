package FinalTest.zavrsniback.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Reprezentacija reprezentacijaA;

	@ManyToOne
	private Reprezentacija reprezentacijaB;

	@Column
	private int goloviA;

	@Column
	private int goloviB;

	public Utakmica() {
	}

	public Utakmica(Reprezentacija reprezentacijaA, Reprezentacija reprezentacijaB, int goloviA, int goloviB) {
		this.reprezentacijaA = reprezentacijaA;
		this.reprezentacijaB = reprezentacijaB;
		this.goloviA = goloviA;
		this.goloviB = goloviB;
	}

	public Utakmica(Long id, Reprezentacija reprezentacijaA, Reprezentacija reprezentacijaB, int goloviA, int goloviB) {
		this.id = id;
		this.reprezentacijaA = reprezentacijaA;
		this.reprezentacijaB = reprezentacijaB;
		this.goloviA = goloviA;
		this.goloviB = goloviB;
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
	 * @return the reprezentacijaA
	 */
	public Reprezentacija getReprezentacijaA() {
		return reprezentacijaA;
	}

	/**
	 * @param reprezentacijaA the reprezentacijaA to set
	 */
	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
	}

	/**
	 * @return the reprezentacijaB
	 */
	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}

	/**
	 * @param reprezentacijaB the reprezentacijaB to set
	 */
	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
	}

	/**
	 * @return the goloviA
	 */
	public int getGoloviA() {
		return goloviA;
	}

	/**
	 * @param goloviA the goloviA to set
	 */
	public void setGoloviA(int goloviA) {
		this.goloviA = goloviA;
	}

	/**
	 * @return the goloviB
	 */
	public int getGoloviB() {
		return goloviB;
	}

	/**
	 * @param goloviB the goloviB to set
	 */
	public void setGoloviB(int goloviB) {
		this.goloviB = goloviB;
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
		if (!(obj instanceof Utakmica)) {
			return false;
		}
		Utakmica other = (Utakmica) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", reprezentacijaA=" + reprezentacijaA + ", reprezentacijaB=" + reprezentacijaB
				+ ", goloviA=" + goloviA + ", goloviB=" + goloviB + "]";
	}

}
