package com.springboot.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.springboot.expense.model.Expense;
import com.springboot.expense.service.ExpenseService;

@RestController
@RequestMapping("/api/v1")

public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	// This method is for jsp
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Expense> listExpenses = expenseService.findAll();
		mav.addObject("listExpenses", listExpenses);
		return mav;
	}

	// This method is for jsp
	@RequestMapping("/addexpense")
	public ModelAndView addexpense() {
		ModelAndView mav = new ModelAndView("add_new_expense");
		mav.addObject("new_expense_obj", new Expense());
		return mav;
	}

	// This method is for jsp
	@RequestMapping(value = "/save_new_expense", method = RequestMethod.POST)
	public String save_new_expense(@ModelAttribute("new_expense_obj") Expense expense) {
		expenseService.add_new_expense(expense);
		return "redirect:/http://localhost:8080/api/v1/";
	}

	// This method is for angular
	@GetMapping("/expenses")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Expense>> get() {
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
	}

	// This method is for angular
	@PostMapping("/add_expenses")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Expense> save(@RequestBody Expense expense) {
		Expense exp = expenseService.save(expense);
		return new ResponseEntity<Expense>(exp, HttpStatus.OK);
	}

}
