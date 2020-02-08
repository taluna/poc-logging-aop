package com.taluna.logging.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase {

    private final ProductRepository repository;

    public ProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void add(Product product){
       repository.add(product);
    }

    public void delete(Long id){
        repository.delete(id);
    }

    public void update(Product product){
        repository.update(product);
    }
}
