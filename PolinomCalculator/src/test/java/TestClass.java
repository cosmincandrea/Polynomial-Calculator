import Models.Monom;
import Models.Polynom;
import Models.PolyonmModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {

    private PolyonmModel model = new PolyonmModel();
    private Polynom pol1;
    private Polynom pol2;
    private Monom m1;
    private Monom m2;

    @BeforeEach
    private void init(){
        pol1 = model.constructPolynom("3x^3+2x^2+6x+7");
        pol2 = model.constructPolynom("+2x^2+7");
        m1 = new Monom(2, 5);
        m2 = new Monom(2, 4);
    }


    @Test
    void testAddMonom() {
        m1.add(m2);
        assertEquals(m1.getCoeficent(), 9);
    }
    @Test
    void testMulMonom() {
        Monom x =  m1.mul(m2);
        assertEquals(x.getCoeficent(), 20);
        assertEquals(x.getPower(), 4);
    }

    @Test
    void testSubMonom() {
        m1.diff(m2);
        assertEquals(m1.getCoeficent(), 1);
    }

    @Test
    void testDerivMonom() {
        m1.deriv();
        assertEquals(m1.getCoeficent(), 10);
        assertEquals(m1.getPower(), 1);
    }
}
