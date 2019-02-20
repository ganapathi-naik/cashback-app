package com.gnaik.tools.cashback.app.config;

import com.gnaik.tools.cashback.app.documents.Cart;
import com.gnaik.tools.cashback.app.documents.Item;
import com.gnaik.tools.cashback.app.repository.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.LinkedList;

@Configuration
public class CashbackConfiguration {

    CartRepository cartRepository;

    public CashbackConfiguration(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

/*    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            cartRepository.save(new Cart(1L, new LinkedList<>(
                    Arrays.asList(new Item("Pen", 1, 10.0))
            )));
        };
    }*/
}
