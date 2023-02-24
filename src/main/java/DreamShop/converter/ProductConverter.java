package DreamShop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DreamShop.dto.ColorDTO;
import DreamShop.dto.ProductDTO;
import DreamShop.entity.ColorEntity;
import DreamShop.entity.ProductEntity;
import DreamShop.service.ICategoryService;
@Component
public class ProductConverter {
	@Autowired
	private ColorConverter colorConverter;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private CategoryConverter categoryConverter;
		public ProductDTO toDto(ProductEntity e) {
			ProductDTO p=new ProductDTO();
			p.setId(e.getId());
			p.setImg(e.getImg());
			p.setCategoryId(e.getCategory().getId());
			p.setName(e.getName());
			p.setSize(e.getSize());
			p.setPrice(e.getPrice());
			p.setQuantity(e.getQuantity());
			p.setDetail(e.getDetail());
			p.setStatus(e.getStatus());
			p.setHighlight(e.getHighlight());
			p.setNewProduct(e.getNewProduct());
			p.setSale(e.getSale());
			p.setCategoryCode(e.getCategory().getCode());
			List<ColorDTO> list=new ArrayList<>();
			for(ColorEntity item:e.getColors()) {
				list.add(colorConverter.toDto(item));
			}
			p.setColor(list);
			return p;
		}
		public ProductEntity toEntity(ProductDTO d) {
			ProductEntity e=new ProductEntity();
			if(d.getId()!=null) {
				e.setId(d.getId());
			}
			e.setImg(d.getImg());
			e.setName(d.getName());
			e.setSize(d.getSize());
			e.setPrice(d.getPrice());
			e.setQuantity(d.getQuantity());
			e.setDetail(d.getDetail());
			e.setStatus(d.getStatus());
			e.setHighlight(d.getHighlight());
			e.setNewProduct(d.getNewProduct());
			e.setSale(d.getSale());
			e.setCategory(categoryConverter.toEntity(categoryService.findById(d.getCategoryId())));
			List<ColorEntity> list=new ArrayList<>();
			if(d.getColor()!=null) {
				for(ColorDTO item:d.getColor()) {
					list.add(colorConverter.toEntity(item));
				}
				e.setColors(list);
			}
			
			return e;
		}
		public ProductEntity toEntity(ProductEntity e,ProductDTO d) {
			if(d.getId()!=0) {
				e.setId(d.getId());
			}
			e.setImg(d.getImg());
			e.setName(d.getName());
			e.setSize(d.getSize());
			e.setPrice(d.getPrice());
			e.setQuantity(d.getQuantity());
			e.setDetail(d.getDetail());
			e.setStatus(d.getStatus());
			e.setHighlight(d.getHighlight());
			e.setNewProduct(d.getNewProduct());
			e.setSale(d.getSale());
			e.setCategory(categoryConverter.toEntity(categoryService.findById(d.getCategoryId())));
			return e;
		}

}
