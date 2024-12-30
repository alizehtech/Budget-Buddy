package ca.sheridancollege.khaalize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.khaalize.beans.Income;
import ca.sheridancollege.khaalize.beans.Expense;
import ca.sheridancollege.khaalize.beans.Budget;
import ca.sheridancollege.khaalize.databaseAccess.DatabaseAccess;

@Controller
public class FinanceController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("income", new Income());
        model.addAttribute("expense", new Expense());
        model.addAttribute("budget", new Budget());
        model.addAttribute("incomeList", databaseAccess.getIncomeList());
        model.addAttribute("expenseList", databaseAccess.getExpenseList());
        model.addAttribute("budgetList", databaseAccess.getBudgetList());
        return "index";
    }

    @PostMapping("/addIncome")
    public String addIncome(Model model, @ModelAttribute Income income) {
        if (income.getId() != null && income.getId() > 0) {
            databaseAccess.updateIncome(income); 
        } else {
            databaseAccess.insertIncome(income); 
        }
        return index(model);
    }

    @GetMapping("/editIncomeById/{id}")
    public String editIncomeById(Model model, @PathVariable Long id) {
        Income income = databaseAccess.getIncomeById(id).get(0);
        model.addAttribute("income", income);
        model.addAttribute("incomeList", databaseAccess.getIncomeList());
        model.addAttribute("expense", new Expense());
        model.addAttribute("expenseList", databaseAccess.getExpenseList());
        model.addAttribute("budget", new Budget());
        model.addAttribute("budgetList", databaseAccess.getBudgetList());
        return "index";
    }

    @GetMapping("/deleteIncomeById/{id}")
    public String deleteIncomeById(Model model, @PathVariable Long id) {
        databaseAccess.deleteIncomeById(id);
        return index(model);
    }

    // Expense Operations
    @PostMapping("/addExpense")
    public String addExpense(Model model, @ModelAttribute Expense expense) {
        if (expense.getId() != null && expense.getId() > 0) {
            databaseAccess.updateExpense(expense); 
        } else {
            databaseAccess.insertExpense(expense); 
        }
        return index(model);
    }

    @GetMapping("/editExpenseById/{id}")
    public String editExpenseById(Model model, @PathVariable Long id) {
        Expense expense = databaseAccess.getExpenseById(id).get(0);
        model.addAttribute("expense", expense);
        model.addAttribute("income", new Income());
        model.addAttribute("incomeList", databaseAccess.getIncomeList());
        model.addAttribute("expenseList", databaseAccess.getExpenseList());
        model.addAttribute("budget", new Budget());
        model.addAttribute("budgetList", databaseAccess.getBudgetList());
        return "index";
    }

    @GetMapping("/deleteExpenseById/{id}")
    public String deleteExpenseById(Model model, @PathVariable Long id) {
        databaseAccess.deleteExpenseById(id);
        return index(model);
    }

    @PostMapping("/addBudget")
    public String addBudget(Model model, @ModelAttribute Budget budget) {
        if (budget.getId() != null && budget.getId() > 0) {
            databaseAccess.updateBudget(budget); 
        } else {
            databaseAccess.insertBudget(budget); 
        }
        return index(model);
    }

    @GetMapping("/editBudgetById/{id}")
    public String editBudgetById(Model model, @PathVariable Long id) {
        Budget budget = databaseAccess.getBudgetById(id).get(0);
        model.addAttribute("budget", budget);
        model.addAttribute("income", new Income());
        model.addAttribute("incomeList", databaseAccess.getIncomeList());
        model.addAttribute("expense", new Expense());
        model.addAttribute("expenseList", databaseAccess.getExpenseList());
        model.addAttribute("budgetList", databaseAccess.getBudgetList());
        return "index";
    }

    @GetMapping("/deleteBudgetById/{id}")
    public String deleteBudgetById(Model model, @PathVariable Long id) {
        databaseAccess.deleteBudgetById(id);
        return index(model);
    }
}

