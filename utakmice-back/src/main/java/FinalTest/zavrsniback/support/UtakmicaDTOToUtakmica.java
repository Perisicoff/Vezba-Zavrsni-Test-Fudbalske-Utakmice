package FinalTest.zavrsniback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Utakmica;
import FinalTest.zavrsniback.service.ReprezentacijaService;
import FinalTest.zavrsniback.service.UtakmicaService;
import FinalTest.zavrsniback.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDTOToUtakmica implements Converter<UtakmicaDTO, Utakmica> {

	@Autowired
	private UtakmicaService utakmicaService;

	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@Override
	public Utakmica convert(UtakmicaDTO source) {
		Utakmica entity = null;

		if (source.getId() == null) {
			entity = new Utakmica();
		} else {
			Utakmica UtakmicaOptional = utakmicaService.findOne(source.getId());
			if (UtakmicaOptional != null) {
				entity = UtakmicaOptional;
			}
		}

		if (entity != null) {
			entity.setReprezentacijaA(reprezentacijaService.findOne(source.getReprezentacijaAId()));
			entity.setReprezentacijaB(reprezentacijaService.findOne(source.getReprezentacijaBId()));
			entity.setGoloviA(0);
			entity.setGoloviB(0);
		}

		return entity;
	}

}
