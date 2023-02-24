package DreamShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import DreamShop.dto.SlidesDTO;

@Service
public interface ISlidesService {
 List<SlidesDTO> findAll();
}
