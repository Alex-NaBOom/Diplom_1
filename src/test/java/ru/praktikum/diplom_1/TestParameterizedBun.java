package ru.praktikum.diplom_1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestParameterizedBun {
    private final String nameBun;
    private final float priceBun;

    public TestParameterizedBun(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters(name = "Название булочки и цена булочки: {0}, {1}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"", 988},
                {null, 988},
                {"Мясо бессмертных моллюсков Protostomia Мясо бессме", 988},
                {"*>`~@#$%", 988},
                {" Флюоресцентная булка R2-D3 ", 988},
                {"Флюоресцентная булка R2-D3", -0},
                {"Флюоресцентная булка R2-D3", 0},
                {" Флюоресцентная булка R2-D3 ", -988},
                {"Флюоресцентная булка R2-D3", -0.0f},
                {"Флюоресцентная булка R2-D3", 0.000000000000000000000000000000000000000000001f},
                {"Флюоресцентная булка R2-D3", -0.000000000000000000000000000000000000000000001f},
                {"Флюоресцентная булка R2-D3", 1.4E-45f},
                {"Флюоресцентная булка R2-D3", 3.4E38f}

        };
    }

    @Test
    public void getReturnCorrectName() {
        Bun bun = new Bun(nameBun, priceBun);
        String actual = bun.getName();
        String expected = nameBun;
        Assert.assertEquals("Проверка названия булочки", expected, actual);
    }

    @Test
    public void getReturnCorrectPrice() {
        Bun bun = new Bun(nameBun, priceBun);
        float actual = bun.getPrice();
        float expected = priceBun;
        Assert.assertEquals("Проверка цены булочки", expected, actual, 0.0);
    }

}
