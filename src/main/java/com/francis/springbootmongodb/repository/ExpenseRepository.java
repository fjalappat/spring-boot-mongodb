package com.francis.springbootmongodb.repository;

import com.francis.springbootmongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
