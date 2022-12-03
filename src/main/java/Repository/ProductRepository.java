package Repository;

import Inheritance.and.extensibility.of.systems.NotFoundException;
import Inheritance.and.extensibility.of.systems.Product;

public class ProductRepository {
    protected Product[] products = new Product[0];

    public void save(Product product) {                              // Сохранение
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {                        //Удаление
        if (this.findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToId = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToId] = product;
                copyToId++;
            }
            products = tmp;
        }
    }


        public Product[] getProducts () {                      // Получить продукты
            return products;

        }

        public Product findById ( int id){                    // Найти по идентификатору
            for (Product product : products) {
                if (product.getId() == id) {
                    return product;
                }
            }
            return null;
        }


    }

