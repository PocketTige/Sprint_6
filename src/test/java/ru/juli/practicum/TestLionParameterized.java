package ru.juli.practicum;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionParameterized {
    private final String sex;
    private boolean expectedHasMane;
    @Mock
    Feline feline;

    // Конструктор для параметров теста
    public TestLionParameterized(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    // Параметры для тестирования
    @Parameterized.Parameters
    public static Object[] testConditions() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
// проверяем правильно ли устанавливается флаг hasMane в зависимости от переданного пола
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}