package com.gnaik.tools.cashback.app.resource;

import com.gnaik.tools.cashback.app.documents.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cashback")
public class CashbackResource {

    private CartResource cartResource;

    public CashbackResource(CartResource cartResource) {
        this.cartResource = cartResource;
    }

    @GetMapping("/{id}")
    int cartCashbackPoints(@PathVariable Long id) {
        Optional<Cart> cart = cartResource.getCartById(id);
        return (int) (cart.map(Cart::getAmount).orElse(0.0) * 0.1);
    }

    @GetMapping("/orderCashbackPoints")
    int orderCashbackPoints() {
        return 0;
    }
}
