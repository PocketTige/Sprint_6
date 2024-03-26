package ru.juli.practicum;

import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestFeline {

Feline feline = new Feline();
    @Test
    public void eatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

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