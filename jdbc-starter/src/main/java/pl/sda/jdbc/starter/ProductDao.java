package pl.sda.jdbc.starter;

import java.util.List;

public interface ProductDao {

    void save(Product p);

    void update (Product p);

    void delete (String id);

    Product find (String id);

    List<Product> findAll();

}
