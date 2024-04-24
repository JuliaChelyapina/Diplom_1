import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }

    private final IngredientType type;
    private final String type2;
    public IngredientTypeParameterizedTest(IngredientType type, String type2) {
        this.type = type;
        this.type2 = type2;
    }
    @Test
    public void ingredientTypeValueTest() {
        assertEquals(type2, type.name());
    }
}