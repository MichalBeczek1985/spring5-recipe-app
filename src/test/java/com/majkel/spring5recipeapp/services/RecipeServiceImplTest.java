package com.majkel.spring5recipeapp.services;

import com.majkel.spring5recipeapp.converters.RecipeCommandToRecipe;
import com.majkel.spring5recipeapp.converters.RecipeToRecipeCommand;
import com.majkel.spring5recipeapp.domain.Recipe;
import com.majkel.spring5recipeapp.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);

    }
    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipiesData = new HashSet();
        recipiesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipiesData);

        Set<Recipe> recipies = recipeService.getRecipes();

        assertEquals(recipies.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    public void testDeleteById() throws Exception{
     /*   Long idToDelete = Long.valueOf(2L);
        recipeService.deleteById(idToDelete);

        verify(recipeRepository,times(1).deleteById(anyLong()));*/
    }
}