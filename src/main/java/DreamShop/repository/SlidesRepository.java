package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.SlidesEntity;
@Repository
public interface SlidesRepository extends JpaRepository<SlidesEntity,Long> {

}
