package com.taluna.logging.product;

import com.google.common.collect.Lists;
import com.taluna.logging.product.aop.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class ProductRepository {

    private static Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    private Map<Long, Product> products;

    public ProductRepository(){
        products = new ConcurrentHashMap<>();
    }

    @LogExecutionTime
    public void add(Product product){
        logger.debug("BEFORE - add a product");

        products.putIfAbsent(product.getId(), product);

        logger.debug("AFTER - add a product");
    }

    public void update(Product product){
        logger.debug("BEFORE - update a product");

        Product p = products.get(product.getId());
        if(p!=null){
            products.remove(product.getId());
            products.putIfAbsent(product.getId(),product);
        }

        logger.debug("AFTER - update a product");
    }

    public void delete(Long id){
        logger.debug("BEFORE - delete a product");

        products.remove(id);

        logger.debug("AFTER - delete a product");
    }

    @LogExecutionTime
    public List<Product> findAll(){
        return Lists.newArrayList(products.values());

    }

}
