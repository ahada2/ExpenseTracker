package com.springboot.expense.service;

import java.util.List;

import com.springboot.expense.model.Expense;

public interface ExpenseService {
	List<Expense> findAll();
	Expense save(Expense expense);
	//for jsp
	void add_new_expense(Expense expense);
}
