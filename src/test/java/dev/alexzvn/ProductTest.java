package dev.alexzvn;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import dev.alexzvn.warehouse.Product;

public class ProductTest {

    @Test
    public void shouldSerializeAndDeserialize() {
        Product product = Product.factory()
                .id("1")
                .name("name")
                .description("description")
                .quantity(1)
                .price(1.0)
                .created_at(new Date())
                .updated_at(new Date())
                .build();

        String serialized = product.toString();
        Product deserialized = Product.fromString(serialized);

        assertEquals(serialized, deserialized.toString());
    }
}
