package com.siteware.ecommerce.service.product;

import com.siteware.ecommerce.dao.product.ProductDAO;
import com.siteware.ecommerce.pojo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation of the ProductService interface.
 *
 * @author Antunes Dantas
 */
@Transactional
@Service
public class ProductBean implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAllProducts();
    }

    @Override
    public Product createProduct(Product product) {
        productDAO.persistProduct(product);

        return productDAO.findProductById(product.getId());
    }

    @Override
    public Product getProduct(Long id) {
        return productDAO.findProductById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}
