import org.junit.Test;
import org.mockito.Spy;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
public class IngredientTest {
    @Spy
    private Ingredient ingredient;
    @Test
    public void ingredientGetPriceTest() {
        float price = 3.99f;
        ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, 0.001);
    }

    @Test
    public void ingredientGetNameTest() {
        String name = "Лук";
        ingredient = new Ingredient(IngredientType.FILLING, name, 1.5f);
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void ingredientGetTypeTest() {
        IngredientType type = IngredientType.FILLING;
        ingredient = new Ingredient(type, "Котлета", 4.99f);
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }
}
