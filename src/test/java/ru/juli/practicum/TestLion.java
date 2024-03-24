package ru.juli.practicum;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class TestLion extends BeforeTest{
    @Mock
    Feline feline;


    @Test
    public void doesHaveManeIfLionIsMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeIfLionIsFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructorIfSexIsInvalid() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test
    public void getKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }
    @Test
    public void getFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
    }
}