package com.bogdanov.devhands.service;

import com.bogdanov.dev.hands.api.model.CreateProductRequest;
import com.bogdanov.dev.hands.api.model.ProductResponse;
import com.bogdanov.dev.hands.api.model.UpdateProductRequest;
import com.bogdanov.devhands.entity.Product;
import com.bogdanov.devhands.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse getProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> new ProductResponse()
                        .id(product.id())
                        .title(product.title())
                        .description(product.description()))
                .orElseThrow();
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        return Optional.of(productRepository.save(new Product()
                    .title(createProductRequest.getTitle())
                    .description(createProductRequest.getDescription())))
                .map(product -> new ProductResponse()
                    .id(product.id())
                    .title(product.title())
                    .description(product.description()))
                .orElseThrow();
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductResponse> findProducts(String filter) {
        List<Product> productList;
        if (filter == null || filter.isBlank() || filter.isEmpty()) {
            productList = productRepository.findAll();
        } else {
            productList = productRepository.findByTitleLike(filter);
        }

        return productList.stream()
                .map(product -> new ProductResponse()
                        .id(product.id())
                        .title(product.title())
                        .description(product.description()))
                .toList();
    }

    public ProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId())
                .orElseThrow();
        Product updatedProduct = productRepository.save(product
                .title(updateProductRequest.getTitle())
                .description(updateProductRequest.getDescription()));
        return new ProductResponse()
                .id(updatedProduct.id())
                .title(updatedProduct.title())
                .description(updatedProduct.description());
    }
}
