package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Reprezentacija;
import FinalTest.zavrsniback.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDTO implements Converter<Reprezentacija, ReprezentacijaDTO> {

	@Override
	public ReprezentacijaDTO convert(Reprezentacija source) {
		ReprezentacijaDTO reprezentacijaDTO = new ReprezentacijaDTO();

		reprezentacijaDTO.setId(source.getId());
		reprezentacijaDTO.setNaziv(source.getNaziv());
		reprezentacijaDTO.setSkraceniNaziv(source.getSkraceniNaziv());

		return reprezentacijaDTO;
	}

	public List<ReprezentacijaDTO> convert(List<Reprezentacija> reprezentacije) {
		List<ReprezentacijaDTO> reprezentacijaDTOS = new ArrayList<>();

		for (Reprezentacija reprezentacija : reprezentacije) {
			reprezentacijaDTOS.add(convert(reprezentacija));
		}
		return reprezentacijaDTOS;
	}

}
