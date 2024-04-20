import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private String name;
    private Bun bun;
    private float price;
    @Before
    public void setUp() {
        name = "Карамелизированная булочка";
        price = 100.0f;
        bun = new Bun(name, price);
    }
    @Test
    public void bunGetNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        assertEquals(price, bun.getPrice(), 0.001);
    }
}