package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Utakmica;
import FinalTest.zavrsniback.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDTO implements Converter<Utakmica, UtakmicaDTO> {

	@Override
	public UtakmicaDTO convert(Utakmica source) {
		UtakmicaDTO utakmicaDTO = new UtakmicaDTO();

		utakmicaDTO.setId(source.getId());
		utakmicaDTO.setReprezentacijaAId(source.getReprezentacijaA().getId());
		utakmicaDTO.setNazivReprezentacijaA(source.getReprezentacijaA().getNaziv());
		utakmicaDTO.setReprezentacijaBId(source.getReprezentacijaB().getId());
		utakmicaDTO.setNazivReprezentacijaB(source.getReprezentacijaB().getNaziv());
		utakmicaDTO.setGoloviA(source.getGoloviA());
		utakmicaDTO.setGoloviB(source.getGoloviB());

		return utakmicaDTO;
	}

	public List<UtakmicaDTO> convert(List<Utakmica> utakmice) {
		List<UtakmicaDTO> utakmiceDTOS = new ArrayList<>();

		for (Utakmica utakmica : utakmice) {
			utakmiceDTOS.add(convert(utakmica));
		}
		return utakmiceDTOS;
	}

}
