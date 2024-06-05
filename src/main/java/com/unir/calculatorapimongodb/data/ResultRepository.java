package com.unir.calculatorapimongodb.data;

import com.unir.calculatorapimongodb.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {}
