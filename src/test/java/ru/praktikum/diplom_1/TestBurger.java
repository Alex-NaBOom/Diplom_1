package ru.praktikum.diplom_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.praktikum.diplom_1.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientTwo;

    @Before // создание объекта бургер перед каждым тестом
    public void setup() {
        burger = new Burger();
    }

    @Test // проверка названия булочки
    public void shouldSetBuns() {
        burger.setBuns(bun);
        assertEquals("Неверное название булочки, ошибка!", bun, burger.bun);
    }

    @Test // проверка добавления ингредиента
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals("Ингредиент не добавился, ошибка!", List.of(ingredient), burger.ingredients);
    }

    @Test // проверка удаления ингредиента
    public void shouldRemoveIngredient() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не удалился, ошибка", List.of(), burger.ingredients);
    }

    @Test // проверка перемещения ингредиентов
    public void shouldMoveIngredient() {
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredientTwo));
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(ingredientTwo, ingredient));
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не переместился, ошибка!", actual, burger.ingredients);
    }

    @Test // проверка получения цены бургера
    public void shouldGetPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals("Стоимость не соответствует, ошибка!", 300F, burger.getPrice(), 0);
    }

    @Test // проверка получения рецепта бургера и его цены
    public void shouldGetReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                        ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals("Не правильный рецепта бургера или его цены, ошибка!", expected, burger.getReceipt());
    }

}
