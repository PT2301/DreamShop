package DreamShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import DreamShop.dto.MenuDTO;

@Service
public interface IMenuService {
	List<MenuDTO> findAll();

}
