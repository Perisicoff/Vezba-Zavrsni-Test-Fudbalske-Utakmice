package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class UtakmicaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private Long reprezentacijaAId;

	private Long reprezentacijaBId;

	private String nazivReprezentacijaA = "";

	private String nazivReprezentacijaB = "";

	private int goloviA;

	private int goloviB;

	public UtakmicaDTO() {
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
	 * @return the reprezentacijaAId
	 */
	public Long getReprezentacijaAId() {
		return reprezentacijaAId;
	}

	/**
	 * @param reprezentacijaAId the reprezentacijaAId to set
	 */
	public void setReprezentacijaAId(Long reprezentacijaAId) {
		this.reprezentacijaAId = reprezentacijaAId;
	}

	/**
	 * @return the reprezentacijaBId
	 */
	public Long getReprezentacijaBId() {
		return reprezentacijaBId;
	}

	/**
	 * @param reprezentacijaBId the reprezentacijaBId to set
	 */
	public void setReprezentacijaBId(Long reprezentacijaBId) {
		this.reprezentacijaBId = reprezentacijaBId;
	}

	/**
	 * @return the nazivReprezentacijaA
	 */
	public String getNazivReprezentacijaA() {
		return nazivReprezentacijaA;
	}

	/**
	 * @param nazivReprezentacijaA the nazivReprezentacijaA to set
	 */
	public void setNazivReprezentacijaA(String nazivReprezentacijaA) {
		this.nazivReprezentacijaA = nazivReprezentacijaA;
	}

	/**
	 * @return the nazivReprezentacijaB
	 */
	public String getNazivReprezentacijaB() {
		return nazivReprezentacijaB;
	}

	/**
	 * @param nazivReprezentacijaB the nazivReprezentacijaB to set
	 */
	public void setNazivReprezentacijaB(String nazivReprezentacijaB) {
		this.nazivReprezentacijaB = nazivReprezentacijaB;
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

}
