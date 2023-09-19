package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
    // Write your tests here.
    @Test
    @DisplayName("Check that addItem does not throw exception")
    public void addItem() {
        Store store = new Store();
        Item item = null;
        store.addItem(item);
        assertDoesNotThrow(() -> {
            store.addItem(item);
        });
    }

    @Test
    @DisplayName("Check that wrong index throws exception")
    public void getItemByIndex() {
        Store store = new Store();
        Item item = new Item("Test", 1.0, 1);
        store.addItem(item);
        assertDoesNotThrow(() -> {
            store.getItemByIndex(10);
        });
    }

    @Test
    @DisplayName("Check that wrong index returns null")
    public void getItemByIndexNull() {
        Store store = new Store();
        Item item = new Item("Test", 1.0, 1);
        store.addItem(item);
        assertEquals(null, store.getItemByIndex(10));
    }

    @Test
    @DisplayName("Check that cart item throws exception if stock is smaller than quantity")
    public void CartItem() {
        Item item = new Item("Test", 1.0, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            new CartItem(item, 5);
        });
    }

    @Test
    @DisplayName("Check that if quantity is negative, quantity is set to 1")
    public void cartItemNegative() {
        Item item = new Item("Test", 1.0, 1);
        CartItem cartItem = new CartItem(item, -1);
        assertEquals(1, cartItem.getQuantity());
    }

    @Test
    @DisplayName("Check that two users can't have same id")
    public void generateId() {
        User user1 = new User("Test", "Test");
        User user2 = new User("Test", "Test");
        assertNotEquals(user1.getId(), user2.getId());
    }

    @Test
    @DisplayName("Check that string representation of item is correct")
    public void toStringTest() {
        Item item = new Item("Test", 1.0, 1);
        assertEquals("name: Test, price: 1.0, stock: 1", item.toString());
    }

    @Test
    @DisplayName("Check that stock is reduced when item is added to cart")
    public void reduceItemByAmount() {
        Item item = new Item("Test", 1.0, 10);
        CartItem cartItem = new CartItem(item, 5);
        Cart cart = new Cart();
        cart.addItemToCart(cartItem);
        cart.reduceItemByAmount(cartItem, 1);
        assertEquals(6, item.getStock());
    }
}
