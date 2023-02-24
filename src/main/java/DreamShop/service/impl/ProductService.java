package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import DreamShop.constant.SystemConstant;
import DreamShop.converter.ProductConverter;
import DreamShop.dto.ProductDTO;
import DreamShop.entity.ProductEntity;
import DreamShop.paging.IPaginateService;
import DreamShop.paging.Paginate;
import DreamShop.repository.ProductRepository;
import DreamShop.service.IProductService;
@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter  productConverter ;
	@Autowired
	private IProductService productService;
	@Autowired
	private IPaginateService paginateService;
	

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item: entities) {
			ProductDTO product = productConverter.toDto(item);
			models.add(product);
		}
		return models;
	}


	@Override
	public List<ProductDTO> findByHighLight() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findByHighLight();
		for (ProductEntity item: entities) {
			ProductDTO product = productConverter.toDto(item);
			models.add(product);
		}
		return models;
	}


	@Override
	public List<ProductDTO> findByCategory(Long categoryId) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findByCategory(categoryId);
		for (ProductEntity item: entities) {
			ProductDTO product = productConverter.toDto(item);
			models.add(product);
		}
		return models;
	}


	@Override
	public List<ProductDTO> ProductInPage( long id,long currentPage) {
		List<ProductDTO> allProductById = productService.findByCategory(id);
		List<ProductDTO> productInPage = new ArrayList<>();
		Paginate paginate =paginateService.GetInfoPaginate(allProductById.size(), SystemConstant.ProductInPage, currentPage);
		for(long i=paginate.getStart()-1;i<=paginate.getEnd()-1;i++) {
			productInPage.add(allProductById.get((int)i));
		}
		return productInPage;
	}


	@Override
	public ProductDTO findById(long id) {
		ProductEntity entity=productRepository.findById(id);
		ProductDTO product=productConverter.toDto(entity);
		return product;
	}


	@Override
	public long getTotalProduct() {    
		return productRepository.count();
	}


	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> model=new ArrayList<>();
		List<ProductEntity> list=productRepository.findAll(pageable).getContent();
		for(ProductEntity item :list) {
			 ProductDTO productDto=productConverter.toDto(item);
			 model.add(productDto);
		}
		return model;
	}


	@Override
	public ProductDTO save(ProductDTO dto) {
		ProductEntity product=new ProductEntity();
		if(dto.getId()!=null) {
			ProductEntity oldProduct=productRepository.findById(dto.getId());
			product=productConverter.toEntity(oldProduct,dto);			
		}else {
			product=productConverter.toEntity(dto);
		}
		return productConverter.toDto(productRepository.save(product));
	}


	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			productRepository.delete(id);
		}
		
	}
	@Override
	public List<ProductDTO> ProductInPage( String key,long currentPage) {
		List<ProductDTO> allProductById = productService.findByKey(key);
		List<ProductDTO> productInPage = new ArrayList<>();
		Paginate paginate =paginateService.GetInfoPaginate(allProductById.size(), SystemConstant.ProductInPage, currentPage);
		for(long i=paginate.getStart()-1;i<=paginate.getEnd()-1;i++) {
			productInPage.add(allProductById.get((int)i));
		}
		return productInPage;
	}


	@Override
	public List<ProductDTO> findByKey(String key) {
		List<ProductEntity> entity = (List<ProductEntity>)productRepository.findByKey(key);
		List<ProductDTO> dto = new ArrayList<>();
		for(ProductEntity item:entity) {
			dto.add(productConverter.toDto(item));
		}
		return dto;
	}
}
