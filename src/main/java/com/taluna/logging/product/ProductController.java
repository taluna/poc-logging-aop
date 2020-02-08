package com.taluna.logging.product;

import com.taluna.logging.product.exception.ProductMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase useCase;

    public ProductController(ProductUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public List<Product> getAllBooks() {
        return useCase.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product){
        useCase.add(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product){
        if(Objects.isNull(id))
            throw new ProductMismatchException("ID não pode ser nulo");
        useCase.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        throw new ProductMismatchException("ID não pode ser nulo");
        //useCase.delete(id);
    }

}
