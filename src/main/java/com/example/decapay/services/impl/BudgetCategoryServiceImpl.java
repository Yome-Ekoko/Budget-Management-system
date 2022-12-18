package com.example.decapay.services.impl;

import com.example.decapay.exceptions.AuthenticationException;
import com.example.decapay.exceptions.ResourceNotFoundException;
import com.example.decapay.exceptions.UserNotFoundException;
import com.example.decapay.models.BudgetCategory;
import com.example.decapay.models.User;
import com.example.decapay.repositories.BudgetCategoryRepository;
import com.example.decapay.repositories.UserRepository;
import com.example.decapay.services.BudgetCategoryService;
import com.example.decapay.utils.UserUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BudgetCategoryServiceImpl implements BudgetCategoryService {
    UserUtil userUtil;
    UserRepository userRepository;
    BudgetCategoryRepository budgetCategoryRepository;
    @Override
    public void deleteBudgetCategory(Long budgetCategoryId) throws UserNotFoundException {

        User user = userRepository.findByEmail(userUtil.getAuthenticatedUserEmail())
                .orElseThrow(() -> new UserNotFoundException("specified user not found in the database"));

        BudgetCategory budgetCategory = budgetCategoryRepository.findById(budgetCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        HttpStatus.BAD_REQUEST, "Specified budget category not found"));

        if (budgetCategory.isDeleted()) {
            throw new ResourceNotFoundException(
                    HttpStatus.BAD_REQUEST, "Budget Category specified already deleted");
        }

        if (!(budgetCategory.getUser().getId().equals(user.getId()))){
            throw new AuthenticationException("Action Not Authorized");
        }

        budgetCategory.setDeleted(true);
        budgetCategoryRepository.save(budgetCategory);
    }

    }

