package ca.sheridancollege.khaalize.databaseAccess;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.khaalize.beans.Income;
import ca.sheridancollege.khaalize.beans.Expense;
import ca.sheridancollege.khaalize.beans.Budget;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    // Income Methods
    public void insertIncome(Income income) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("amount", income.getAmount());
        String query = "INSERT INTO income(amount) VALUES (:amount)";
        jdbc.update(query, namedParameters);
    }

    public void updateIncome(Income income) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", income.getId());
        namedParameters.addValue("amount", income.getAmount());
        String query = "UPDATE income SET amount = :amount WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public List<Income> getIncomeList() {
        String query = "SELECT * FROM income";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Income.class));
    }

    public List<Income> getIncomeById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "SELECT * FROM income WHERE id = :id";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Income.class));
    }

    public void deleteIncomeById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM income WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    // Expense Methods
    public void insertExpense(Expense expense) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("amount", expense.getAmount());
        String query = "INSERT INTO expense(amount) VALUES (:amount)";
        jdbc.update(query, namedParameters);
    }

    public void updateExpense(Expense expense) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", expense.getId());
        namedParameters.addValue("amount", expense.getAmount());
        String query = "UPDATE expense SET amount = :amount WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public List<Expense> getExpenseList() {
        String query = "SELECT * FROM expense";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Expense.class));
    }

    public List<Expense> getExpenseById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "SELECT * FROM expense WHERE id = :id";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Expense.class));
    }

    public void deleteExpenseById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM expense WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    // Budget Methods
    public void insertBudget(Budget budget) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("amount", budget.getAmount());
        String query = "INSERT INTO budget(amount) VALUES (:amount)";
        jdbc.update(query, namedParameters);
    }

    public void updateBudget(Budget budget) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", budget.getId());
        namedParameters.addValue("amount", budget.getAmount());
        String query = "UPDATE budget SET amount = :amount WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public List<Budget> getBudgetList() {
        String query = "SELECT * FROM budget";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Budget.class));
    }

    public List<Budget> getBudgetById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "SELECT * FROM budget WHERE id = :id";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Budget.class));
    }

    public void deleteBudgetById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM budget WHERE id = :id";
        jdbc.update(query, namedParameters);
    }
}
