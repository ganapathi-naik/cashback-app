package com.gnaik.tools.cashback.app.repository;

import com.gnaik.tools.cashback.app.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
}
