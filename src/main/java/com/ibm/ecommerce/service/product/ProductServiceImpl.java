package com.ibm.ecommerce.service.product;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.repository.IProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private IProductRepository IProductRepository;

  @Override
  public Product save(Product product) {
    return IProductRepository.save(product);
  }

  @Override
  public Optional<Product> get(Integer id) {
    return IProductRepository.findById(id);
  }

  @Override
  public void update(Product product) {
    IProductRepository.save(product);
  }

  @Override
  public void delete(Integer id) {
    IProductRepository.deleteById(id);
  }

  @Override
  public List<Product> findAll() {
    return IProductRepository.findAll();
  }
}
