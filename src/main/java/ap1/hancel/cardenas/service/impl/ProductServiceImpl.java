package ap1.hancel.cardenas.service.impl;

import ap1.hancel.cardenas.model.Product;
import ap1.hancel.cardenas.repository.ProductRepository;
import ap1.hancel.cardenas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        log.info("Creating product: {}", product);
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> getProductById(String id) {
        log.info("Getting product by id: {}", id);
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> getAllProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> updateProduct(String id, Product product) {
        log.info("Updating product with id: {}", id);
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setPrice(product.getPrice());
                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        log.info("Deleting product with id: {}", id);
        return productRepository.deleteById(id);
    }
}
