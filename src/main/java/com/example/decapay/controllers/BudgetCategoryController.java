package com.example.decapay.controllers;

import com.example.decapay.exceptions.UserNotFoundException;
import com.example.decapay.services.BudgetCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/budgets/categories")
public class BudgetCategoryController {

    private final BudgetCategoryService budgetCategoryService;

    @DeleteMapping("/{category_id}")
    public ResponseEntity<String> deleteBudgetCategory(@PathVariable Long category_id)
            throws UserNotFoundException {
        budgetCategoryService.deleteBudgetCategory(category_id);
        return ResponseEntity.ok("Category successfully deleted");
    }
}
