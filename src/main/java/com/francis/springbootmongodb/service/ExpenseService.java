package com.francis.springbootmongodb.service;

import com.francis.springbootmongodb.model.Expense;
import com.francis.springbootmongodb.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }
    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Id %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(()
                -> new RuntimeException(String.format("Cannot FInd Expense by Name %s", name)));
    }
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
