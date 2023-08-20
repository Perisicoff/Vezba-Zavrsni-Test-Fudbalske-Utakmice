package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class IgracDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String ime = "";

	private String prezime = "";

	private int postignutiGolovi;

	private Long reprezentacijaId;

	private String nazivReprezentacije = "";

	public IgracDTO() {
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
	 * @return the reprezentacijaId
	 */
	public Long getReprezentacijaId() {
		return reprezentacijaId;
	}

	/**
	 * @param reprezentacijaId the reprezentacijaId to set
	 */
	public void setReprezentacijaId(Long reprezentacijaId) {
		this.reprezentacijaId = reprezentacijaId;
	}

	/**
	 * @return the nazivReprezentacije
	 */
	public String getNazivReprezentacije() {
		return nazivReprezentacije;
	}

	/**
	 * @param nazivReprezentacije the nazivReprezentacije to set
	 */
	public void setNazivReprezentacije(String nazivReprezentacije) {
		this.nazivReprezentacije = nazivReprezentacije;
	}

}
