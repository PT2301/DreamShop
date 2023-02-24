package DreamShop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import DreamShop.dto.ProductDTO;
@Service
public interface IProductService {
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
	List<ProductDTO> findAll();
	List<ProductDTO> findByHighLight();
	List<ProductDTO> findByCategory(Long categoryId);
	List<ProductDTO> ProductInPage(long id,long currentPage);
	List<ProductDTO> ProductInPage(String key,long currentPage);
	ProductDTO findById(long id);
	long getTotalProduct();
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> findByKey(String key);

}
