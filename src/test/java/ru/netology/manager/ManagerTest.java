package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    Product book1 = new Book(1, "Гарри Поттер и филосовский камень", 100, "Дж.К.Роулинг");
    Product book2 = new Book(2, "Таня Гроттер", 200, "Д.А.Емец");
    Product book3 = new Book(3, "Пори Гаттер", 300, "А.В.Жвалевский");
    Product book4 = new Book(3, "Гарри Поттер и тайная комната", 400, "Дж.К.Роулинг");
    Product phone1 = new Smartphone(5, "Samsung", 5000, "China");
    Product phone2 = new Smartphone(6, "Iphone", 10000, "USA");
    Product phone3 = new Smartphone(7, "YandexPhone", 15000, "Russia");
    Product phone4 = new Smartphone(8, "SamsungS21", 150000, "China");
    Product anotherProduct = new Product(9, "abc", 543);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(anotherProduct);
    }

    @Test
    void testAnother() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("def");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Библия");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookFromList() {
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Пори Гаттер");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthorNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Яхве");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthorFromList() {
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Д.А.Емец");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchTwoBookFromList() {
        Product[] expected = new Product[]{book1, book4};
        Product[] actual = manager.searchBy("Дж.К.Роулинг");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchPhoneNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchPhoneFromList() {
        Product[] expected = new Product[]{phone4};
        Product[] actual = manager.searchBy("SamsungS21");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchTwoPhoneFromList() {
        Product[] expected = new Product[]{phone1, phone4};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchManufacturerNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Ukraine");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchManufacturerFromList() {
        Product[] expected = new Product[]{phone3};
        Product[] actual = manager.searchBy("Russia");
        assertArrayEquals(expected, actual);
    }


}