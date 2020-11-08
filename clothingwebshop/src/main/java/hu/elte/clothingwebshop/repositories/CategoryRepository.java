package hu.elte.clothingwebshop.repositories;

import hu.elte.clothingwebshop.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
