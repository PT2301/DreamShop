package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.MenuEntity;
@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {

}
