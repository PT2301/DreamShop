package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.converter.SlidesConverter;
import DreamShop.dto.SlidesDTO;
import DreamShop.entity.SlidesEntity;
import DreamShop.repository.SlidesRepository;
import DreamShop.service.ISlidesService;

@Service
public class SlidesService implements ISlidesService {
    @Autowired
    private SlidesRepository slidesRepository;
    @Autowired
    private SlidesConverter slidesConverter;
	@Override
	public List<SlidesDTO> findAll() {
		List<SlidesDTO> models = new ArrayList<>();
		List<SlidesEntity> entities = slidesRepository.findAll();
		for (SlidesEntity item: entities) {
			SlidesDTO slides = slidesConverter.toDto(item);
			models.add(slides);
		}
		return models;
	}

}
