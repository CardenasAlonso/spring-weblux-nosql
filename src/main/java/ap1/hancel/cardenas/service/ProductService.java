package ap1.hancel.cardenas.service;

import ap1.hancel.cardenas.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> createProduct(Product product);
    Mono<Product> getProductById(String id);
    Flux<Product> getAllProducts();
    Mono<Product> updateProduct(String id, Product product);
    Mono<Void> deleteProduct(String id);
}