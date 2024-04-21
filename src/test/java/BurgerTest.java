import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;
    @Spy
    private Burger burger;

    public static final String RECEIPT = "(==== Карамельная ====)"
            + System.lineSeparator()
            + "= sauce кетчуп ="
            + System.lineSeparator()
            + "(==== Карамельная ====)"
            + System.lineSeparator()
            + System.lineSeparator()
            + "Price: 11.100000"
            + System.lineSeparator();
    @Test
    public void burgerRemoveIngredientTest() {
        when(ingredient.getPrice()).thenReturn(1f);
        when(ingredient.getName()).thenReturn("кетчуп");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("", burger.ingredients.stream().map(Object::toString).collect(Collectors.joining("")));
    }
    @Test
    public void burgerMoveIngredientTest() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(ingredient.getName()).thenReturn("Ингредиент 1");
        when(ingredient2.getName()).thenReturn("Ингредиент 2");
        when(ingredient3.getName()).thenReturn("Ингредиент 3");

        List<String> expectedIngredients = new ArrayList<>();
        expectedIngredients.add("Ингредиент 1");
        expectedIngredients.add("Ингредиент 3");
        expectedIngredients.add("Ингредиент 2");

        burger.moveIngredient(1, 2);

        List<String> actualIngredients = new ArrayList<>();
        for (Ingredient ingredient : burger.ingredients) {
            actualIngredients.add(ingredient.getName());
        }
        assertEquals(expectedIngredients, actualIngredients);
    }
    @Test
    public void burgerGetPriceTest() {
        when(bun.getPrice()).thenReturn(3.5f);
        when(ingredient.getPrice()).thenReturn(1f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(8f, burger.getPrice(), 0.001);
    }
    @Test
    public void burgerGetReceiptTest() {
        when(bun.getName()).thenReturn("Карамельная");
        when(ingredient.getName()).thenReturn("кетчуп");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(burger.getPrice()).thenReturn(11.1f);
        assertEquals(RECEIPT, burger.getReceipt());
    }
}
