package DreamShop.converter;

import org.springframework.stereotype.Component;

import DreamShop.dto.SlidesDTO;
import DreamShop.entity.SlidesEntity;

@Component
public class SlidesConverter {
	public SlidesDTO toDto(SlidesEntity entity) {
		SlidesDTO result=new SlidesDTO();
		result.setId(entity.getId());
		result.setImg(entity.getImg());
		result.setCaption(entity.getCaption());
		result.setContent(entity.getContent());
		return result;
	}

}
