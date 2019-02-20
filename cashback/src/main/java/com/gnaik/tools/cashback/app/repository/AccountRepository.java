package com.gnaik.tools.cashback.app.repository;

import com.gnaik.tools.cashback.app.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {
}
