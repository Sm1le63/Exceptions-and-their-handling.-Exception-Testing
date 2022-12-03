package Repository;

import Inheritance.and.extensibility.of.systems.*;
import Manager.ProductManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product product1 = new Book(1, "Книга", 100, "Автор 1");
    Product product2 = new Book(2, "Книга", 200, "Автор 2");
    Product product3 = new Smartphone(3, "Модель 1", 300, "Произв. 1");
    Product product4 = new Smartphone(4, "Модель 2", 400, "Произв. 2");


    @Test

    public void testSave() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);


        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);


        repo.removeById(product1.getId());
        repo.removeById(product4.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNoneProductsFit() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Модель 7");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfOneItemFits() {
        manager.add(product1);
        manager.add(product4);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Модель 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfMultipleProductsFound() {
        manager.add(product1);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfMultipleOptions() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkRemoveByIdMethodExistingElement() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);


        repo.removeById(product2.getId());
        repo.removeById(product3.getId());

        Product[] expected = {product1, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkRemoveByIdMethodNoExistingElement() {

        repo.save(product1);
        repo.save(product2);

       Assertions.assertThrows(NotFoundException.class, () -> {
           repo.removeById(product4.getId());
               });
    }

}







