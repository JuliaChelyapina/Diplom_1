import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
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
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getName()).thenReturn("кетчуп");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("", burger.ingredients.stream().map(Object::toString).collect(Collectors.joining("")));
    }
    @Test
    public void burgerGetPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(3.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(8f, burger.getPrice(), 0.001);
    }
    @Test
    public void burgerGetReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Карамельная");
        Mockito.when(ingredient.getName()).thenReturn("кетчуп");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(burger.getPrice()).thenReturn(11.1f);
        assertEquals(RECEIPT, burger.getReceipt());
    }
}
