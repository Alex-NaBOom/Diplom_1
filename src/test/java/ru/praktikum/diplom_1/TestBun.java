package ru.praktikum.diplom_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBun {
    Bun bun;

    @Before
    public void setup() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test // проверка получения названия булочки
    public void shouldGetName() {
        String actual = "Флюоресцентная булка R2-D3";
        assertEquals("Неверное название булочки, ошибка!", actual, bun.getName());
    }

    @Test // проверка получения стоимости булочки
    public void shouldGetPrice() {
        float actual = 988;
        assertEquals("Неверная стоимость булочки, ошибка!", actual, bun.getPrice(), 0);
    }

}
