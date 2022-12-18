package com.example.decapay.services.impl;


import com.example.decapay.exceptions.UserNotFoundException;
import com.example.decapay.models.BudgetCategory;
import com.example.decapay.models.User;
import com.example.decapay.repositories.BudgetCategoryRepository;
import com.example.decapay.repositories.UserRepository;
import com.example.decapay.utils.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BudgetCategoryServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BudgetCategoryRepository budgetCategoryRepository;

    @Mock
    UserUtil userUtil;

    User user;
    BudgetCategory budgetCategory;
    @InjectMocks
    BudgetCategoryServiceImpl budgetCategoryService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        user = new User();
        budgetCategory = new BudgetCategory();

        //stub user object
        user.setId(1L);;
        user.setDeleted(false);
        user.setEmail("testing@gmail.com");

        //stub budgetCategory object
        budgetCategory.setId(1L);
        budgetCategory.setDeleted(false);
        budgetCategory.setUser(user);
    }

    @Test
     final void testDeleteBudgetCategory() throws UserNotFoundException {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(userUtil.getAuthenticatedUserEmail()).thenReturn("testing@gmail.com");
        when(budgetCategoryRepository.findById(1L)).thenReturn(Optional.of(budgetCategory));

        budgetCategoryService.deleteBudgetCategory(budgetCategory.getId());
        verify(budgetCategoryRepository).save(budgetCategory);
        assertThat(budgetCategory.isDeleted()).isTrue();
        verify(budgetCategoryRepository,times(1)).save(any(BudgetCategory.class));
    }






}
