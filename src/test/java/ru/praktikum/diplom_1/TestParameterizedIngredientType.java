package ru.praktikum.diplom_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParameterizedIngredientType {
    private final IngredientType ingredientType;

    public TestParameterizedIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] dataIngredientType() {
        return new Object[][]
                {
                        {IngredientType.SAUCE},
                        {IngredientType.FILLING},
                };
    }

    @Test
    public void checkValuesEnumIngredientType() {
        IngredientType expected = ingredientType;
        assertEquals("Не правильный тип ингредиента, ошибка!", expected, IngredientType.valueOf(String.valueOf(ingredientType)));
    }
}

