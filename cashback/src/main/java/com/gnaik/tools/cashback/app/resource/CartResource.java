package com.gnaik.tools.cashback.app.resource;

import com.gnaik.tools.cashback.app.documents.Cart;
import com.gnaik.tools.cashback.app.documents.Item;
import com.gnaik.tools.cashback.app.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartResource {

    private CartRepository cartRepository;

    public CartResource(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/{id}")
    public List<Item> getItems(@PathVariable Long id) {
        Optional<Cart> optionalCart = getCartById(id);
        return optionalCart.map(Cart::getItems).orElse(new LinkedList<>());
    }

    @PostMapping("/{id}")
    public void addItems(@PathVariable Long id, @RequestBody Item item) {
        Optional<Cart> optionalCart = getCartById(id);
        Cart cart = optionalCart.orElse(new Cart(id, null, new LinkedList<>()));
        cart.getItems().add(item);
        cartRepository.save(cart);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id, @RequestBody Item item) {
        Optional<Cart> optionalCart = getCartById(id);
        optionalCart.ifPresent(cart -> removeItemAndSaveCart(cart, item));
    }

    protected Optional<Cart> getCartById(@PathVariable Long id) {
        return cartRepository.findById(id);
    }

    private void removeItemAndSaveCart(Cart cart, Item item) {
        Optional.ofNullable(cart.getItems()).ifPresent(items -> items.remove(item));
        cartRepository.save(cart);
    }
}
