package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Igrac;
import FinalTest.zavrsniback.web.dto.IgracDTO;

@Component
public class IgracToIgracDTO implements Converter<Igrac, IgracDTO> {

	@Override
	public IgracDTO convert(Igrac source) {
		IgracDTO igracDTO = new IgracDTO();

		igracDTO.setId(source.getId());
		igracDTO.setIme(source.getIme());
		igracDTO.setPrezime(source.getPrezime());
		igracDTO.setPostignutiGolovi(source.getPostignutiGolovi());
		igracDTO.setReprezentacijaId(source.getReprezentacija().getId());
		igracDTO.setNazivReprezentacije(source.getReprezentacija().getNaziv());

		return igracDTO;
	}

	public List<IgracDTO> convert(List<Igrac> igraci) {
		List<IgracDTO> igracDTOS = new ArrayList<>();

		for (Igrac igrac : igraci) {
			igracDTOS.add(convert(igrac));
		}
		return igracDTOS;
	}

}
