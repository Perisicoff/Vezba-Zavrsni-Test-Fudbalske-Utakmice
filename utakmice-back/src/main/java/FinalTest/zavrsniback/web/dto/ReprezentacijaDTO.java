package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ReprezentacijaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	@NotBlank
	private String naziv = "";

	@Size(min = 3, max = 3)
	private String skraceniNaziv = "";

	public ReprezentacijaDTO() {
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

}
