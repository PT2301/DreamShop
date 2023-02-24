package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
	CategoryEntity findById(long id);
	
}
