package com.example.decapay.services;

import com.example.decapay.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface BudgetCategoryService{

    public void deleteBudgetCategory (Long budgetCategoryId) throws UserNotFoundException;
}
