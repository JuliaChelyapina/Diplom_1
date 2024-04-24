import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    private Database database;
    @Mock
    private Bun mockBun1;
    @Mock
    private Bun mockBun2;
    @Mock
    private Bun mockBun3;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;
    @Mock
    private Ingredient mockIngredient3;
    @Mock
    private Ingredient mockIngredient4;
    @Mock
    private Ingredient mockIngredient5;
    @Mock
    private Ingredient mockIngredient6;
    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void dbAvailableBunsTest() {
        when(mockBun1.getName()).thenReturn("black bun");
        when(mockBun2.getName()).thenReturn("white bun");
        when(mockBun3.getName()).thenReturn("red bun");

        List<Bun> availableBuns = database.availableBuns();

        assertNotNull(availableBuns);
        assertEquals(3, availableBuns.size());
        assertEquals("black bun", availableBuns.get(0).getName());
        assertEquals("white bun", availableBuns.get(1).getName());
        assertEquals("red bun", availableBuns.get(2).getName());
    }
    @Test
    public void dbAvailableIngredientsTest() {
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("sour cream");
        when(mockIngredient3.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient3.getName()).thenReturn("chili sauce");
        when(mockIngredient4.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient4.getName()).thenReturn("cutlet");
        when(mockIngredient5.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient5.getName()).thenReturn("dinosaur");
        when(mockIngredient6.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient6.getName()).thenReturn("sausage");

        List<Ingredient> availableIngredients = database.availableIngredients();

        assertNotNull(availableIngredients);
        assertEquals(6, availableIngredients.size());
        assertEquals(IngredientType.SAUCE, availableIngredients.get(0).getType());
        assertEquals("hot sauce", availableIngredients.get(0).getName());
        assertEquals(IngredientType.SAUCE, availableIngredients.get(1).getType());
        assertEquals("sour cream", availableIngredients.get(1).getName());
        assertEquals(IngredientType.SAUCE, availableIngredients.get(2).getType());
        assertEquals("chili sauce", availableIngredients.get(2).getName());
        assertEquals(IngredientType.FILLING, availableIngredients.get(3).getType());
        assertEquals("cutlet", availableIngredients.get(3).getName());
        assertEquals(IngredientType.FILLING, availableIngredients.get(4).getType());
        assertEquals("dinosaur", availableIngredients.get(4).getName());
        assertEquals(IngredientType.FILLING, availableIngredients.get(5).getType());
        assertEquals("sausage", availableIngredients.get(5).getName());
    }
}
