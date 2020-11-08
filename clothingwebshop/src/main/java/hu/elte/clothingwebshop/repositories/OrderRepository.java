package hu.elte.clothingwebshop.repositories;

import hu.elte.clothingwebshop.entities.WsOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<WsOrder, Integer> {

}
