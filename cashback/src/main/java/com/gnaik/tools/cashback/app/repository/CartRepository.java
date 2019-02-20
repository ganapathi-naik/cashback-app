package com.gnaik.tools.cashback.app.repository;

import com.gnaik.tools.cashback.app.documents.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, Long> {
}
