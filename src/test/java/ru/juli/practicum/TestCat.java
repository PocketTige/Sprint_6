package ru.juli.practicum;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

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
        verify(feline).eatMeat(); // Проверяем, что метод eatMeat() был вызван ровно один раз
    }
}