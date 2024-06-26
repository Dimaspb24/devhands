package com.bogdanov.devhands.controller;

import com.bogdanov.dev.hands.api.delegate.ProductCrudOperationsApi;
import com.bogdanov.dev.hands.api.model.CreateProductRequest;
import com.bogdanov.dev.hands.api.model.ProductResponse;
import com.bogdanov.dev.hands.api.model.UpdateProductRequest;
import com.bogdanov.devhands.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductCrudOperationsApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductResponse> createProduct(CreateProductRequest createProductRequest) {
        return ResponseEntity.created(null).body(productService.createProduct(createProductRequest));
    }

    @Override
    public ResponseEntity<ProductResponse> getProduct(Long productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ProductResponse>> findProducts(String filter) {
        return ResponseEntity.ok(productService.findProducts(filter));
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(productService.updateProduct(updateProductRequest));
    }
}
