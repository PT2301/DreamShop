package DreamShop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DreamShop.dto.ProductDTO;
import DreamShop.service.IProductService;

@RestController(value="productAPIOfAdmin")
public class ProductAPI {
	@Autowired
	private IProductService productService;
	@PostMapping("/api/product")
	public ProductDTO addProduct(@RequestBody ProductDTO dto) {
		return productService.save(dto);
	}
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
		return productService.save(dto);
	}
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody long[] ids) {
		 productService.delete(ids);
	}

}
