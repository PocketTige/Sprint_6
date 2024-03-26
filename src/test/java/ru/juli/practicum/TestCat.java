package ru.juli.practicum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCat{
    private Cat cat;
    Feline feline;
    @Before
    public void init() {
        feline = mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void GetSound() {
        assertEquals("Мяу", cat.getSound()); // Проверяем, что метод getSound() возвращает правильное значение
    }

    @Test
    public void GetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мыши", "Птицы");
        when(feline.eatMeat()).thenReturn(expectedFood); // Настраиваем мок, чтобы он возвращал ожидаемый результат
        assertEquals(expectedFood, cat.getFood()); // Проверяем, что метод getFood() возвращает правильное значение
    }
}