package DreamShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import DreamShop.dto.CategoryDTO;
@Service
public interface ICategoryService {
	 List<CategoryDTO> findAll();
	 CategoryDTO findById(long id);
}
