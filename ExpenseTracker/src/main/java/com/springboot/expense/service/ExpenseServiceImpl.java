package com.springboot.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.expense.model.Expense;
import com.springboot.expense.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense save(Expense expense) {
		expenseRepository.save(expense);
		return expense;
	}

	@Override
	public void add_new_expense(Expense expense) {
		expenseRepository.save(expense);
	}

}
