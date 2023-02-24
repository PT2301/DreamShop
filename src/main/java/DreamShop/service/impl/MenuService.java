package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.converter.MenuConverter;
import DreamShop.dto.MenuDTO;
import DreamShop.entity.MenuEntity;
import DreamShop.repository.MenuRepository;
import DreamShop.service.IMenuService;
@Service
public class MenuService implements IMenuService {
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private MenuConverter  menuConverter;
	@Override
	public List<MenuDTO> findAll() {
		List<MenuDTO> result=new ArrayList<>();
		List<MenuEntity> menu=menuRepository.findAll();
		for(MenuEntity item:menu) {
			result.add(menuConverter.toDto(item));
		}
		return result;
	}

}
