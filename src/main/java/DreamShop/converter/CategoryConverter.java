package DreamShop.converter;

import org.springframework.stereotype.Component;

import DreamShop.dto.CategoryDTO;
import DreamShop.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result=new CategoryDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
	public CategoryEntity toEntity(CategoryDTO d) {
		CategoryEntity e=new CategoryEntity();
		if(d.getId()!=0) {
			e.setId(d.getId());
		}
		e.setCode(d.getCode());
		e.setName(d.getName());
		return e;
	}

}
