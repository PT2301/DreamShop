package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.converter.CategoryConverter;
import DreamShop.dto.CategoryDTO;
import DreamShop.entity.CategoryEntity;
import DreamShop.repository.CategoryRepository;
import DreamShop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService  {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result=new ArrayList<>();
		List<CategoryEntity> category=categoryRepository.findAll();
		for(CategoryEntity item:category) {
			result.add(categoryConverter.toDto(item));
		}
		return result;
	}

	@Override
	public CategoryDTO findById(long id) {
		return categoryConverter.toDto(categoryRepository.findById(id));
	}
	

}
