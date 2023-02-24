package DreamShop.converter;

import org.springframework.stereotype.Component;

import DreamShop.dto.ColorDTO;
import DreamShop.entity.ColorEntity;

@Component
public class ColorConverter {
	public ColorDTO toDto(ColorEntity e) {
		ColorDTO c =new ColorDTO();
		c.setId(e.getId());
		c.setName(e.getName());
		c.setCode(e.getCode());
		c.setImg(e.getImg());
		return c;
	}
	public ColorEntity toEntity(ColorDTO d) {
		ColorEntity e =new ColorEntity();
		if(d.getId()!=0) {
			e.setId(d.getId());
		}
		e.setName(d.getName());
		e.setCode(d.getCode());
		e.setImg(d.getImg());
		return e;
	}

}
