package DreamShop.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DreamShop.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
	ProductEntity findById(long id);
	@Query(value = "SELECT * FROM product WHERE highlight=1", nativeQuery = true)
	Collection<ProductEntity> findByHighLight();
	@Query(value = "SELECT * FROM product WHERE category_id=?1", nativeQuery = true)
	Collection<ProductEntity> findByCategory(Long categoryId);
	@Query(value = "SELECT * FROM product WHERE name LIKE %?1%", nativeQuery = true)
	Collection<ProductEntity> findByKey(String key);
	


}
