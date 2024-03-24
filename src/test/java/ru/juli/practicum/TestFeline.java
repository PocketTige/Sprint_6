package ru.juli.practicum;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TestFeline extends BeforeTest{
    private Feline feline;

    @Before
    public void init() {
        feline = Mockito.spy(new Feline());
    }
    @Test
    public void eatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // Act
        List<String> actualFood = feline.eatMeat();

        // Assert
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamily() {
        // Act
        String family = feline.getFamily();

        // Assert
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensWhenNoArgument() {
        // Act
        int kittensCount = feline.getKittens();

        // Assert
        assertEquals(1, kittensCount);
    }

    @Test
    public void getKittensWhenArgumentIs() {
        // Arrange
        int expectedKittensCount = 1;

        // Act
        int actualKittensCount = feline.getKittens(expectedKittensCount);

        // Assert
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}