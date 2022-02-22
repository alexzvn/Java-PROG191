package dev.alexzvn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;

import org.junit.Test;

import dev.alexzvn.utils.Collection;
import dev.alexzvn.warehouse.Product;
import dev.alexzvn.warehouse.Statistic;

public class StatisticTest {
    protected Statistic products;

    public StatisticTest() {
        Collection<Product> items = new Collection<Product>();

        items.push(Product.factory().id("1").name("item 1").description("example description 1").quantity(1).price(1.0).created_at(new Date()).updated_at(new Date()).build());
        items.push(Product.factory().id("2").name("item 2").description("example description 2").quantity(1).price(2.0).created_at(new Date()).updated_at(new Date()).build());

        products = new Statistic(items);
    }

    @Test
    public void shouldHasProduct() {
        assertEquals(2, products.items().count());
    }

    @Test
    public void shouldAddProduct() {
        Product item = Product.factory().id("3").name("item 3").description("example description 3").quantity(1).price(3.0).created_at(new Date()).updated_at(new Date()).build();

        int before = products.items().count();

        products.items().push(item);

        assertEquals(before + 1, products.items().count());
    }

    @Test
    public void shouldRemoveProduct() {
        int before = products.items().count();

        products.items().remove(products.items().first());

        assertEquals(before - 1, products.items().count());
    }

    @Test
    public void shouldEditableProduct() {
        Product item = products.items().first();

        item.name = "new name";

        assertEquals("new name", products.items().first().name);
    }

    @Test
    public void canSearchProduct() {
        assertEquals(1, products.search("1").count());
        assertEquals(0, products.search("ansdkjan").count());
    }

    @Test
    public void canSaveToFile() {
        products.saveTo("test.txt");

        File file = new File("test.txt");

        assertTrue(file.exists());
    }

    @Test
    public void canLoadFromFile() {
        Statistic products = Statistic.loadFrom("test.txt");

        assertEquals(2, products.items().count());
    }
}
