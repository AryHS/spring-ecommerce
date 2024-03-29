package com.ibm.ecommerce.service.product;

import com.ibm.ecommerce.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

  Product save(Product product);
  Optional<Product> get(Integer id); //Para validar si el producto que se llama de la Base de Datos existe o no.
  void update(Product product);
  void delete(Integer id);
  List<Product> findAll();

}
