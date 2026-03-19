package ap1.hancel.cardenas.repository;

import ap1.hancel.cardenas.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    
}