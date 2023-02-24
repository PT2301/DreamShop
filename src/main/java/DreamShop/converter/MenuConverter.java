package DreamShop.converter;

import org.springframework.stereotype.Component;

import DreamShop.dto.MenuDTO;
import DreamShop.entity.MenuEntity;
@Component
public class MenuConverter {
	public MenuDTO toDto(MenuEntity entity) {
		MenuDTO result=new MenuDTO();
		result.setId(entity.getId());
		result.setUrl(entity.getUrl());
		result.setName(entity.getName());
		return result;
	}
}
