package ru.praktikum.diplom_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIgredient {
    Ingredient ingredient;

    @Before // создаем ингредиент передкаждым тестом
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
    }

    @Test // проверка получения стоимости ингредиента
    public void shouldReturnPrice() {
        float expected = 90;
        assertEquals("Не правильная стоимость ингредиента, ошибка!", expected, ingredient.getPrice(), 0);
    }

    @Test  // проверка получения названия ингредиента
    public void shouldReturnName() {
        String expected = "Соус Spicy-X";
        assertEquals("Не правильное название ингредиента, ошибка!", expected, ingredient.getName());
    }

    @Test  // проверка получения типа ингредиента
    public void shouldReturnIngredientTypeSauce() {
        IngredientType expected = IngredientType.SAUCE;
        assertEquals("Не правильный тип ингредиента, ошибка!", expected, ingredient.getType());
    }

}
