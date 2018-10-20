import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testValidConstruction() throws ShapeException{
        Line l1 = new Line(0,3, 2,2);
        Line l2 = new Line(2, 2, 1, 1);
        Line l3 = new Line(1, 1, 0, 3);

        Triangle myTriangle = new Triangle(l1, l2, l3);
        assertEquals(0, myTriangle.getVertex1().getX(), 0);
        assertEquals(3, myTriangle.getVertex1().getY(), 0);
        assertEquals(2, myTriangle.getVertex2().getX(), 0);
        assertEquals(2, myTriangle.getVertex2().getY(), 0);
        assertEquals(1, myTriangle.getVertex3().getX(), 0);
        assertEquals(1, myTriangle.getVertex3().getY(), 0);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException{

        try {
            Line l1 = new Line(0,3, 2,2);
            Line l2 = new Line(2, 2, 1, 1);
            Line l3 = new Line(1, Double.NaN, 0, 3);

            Triangle myTriangle = new Triangle(l1, l2, l3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }
    }

    @Test
    public void testTriangleCalcCenter() throws ShapeException{
        Line l1 = new Line(0,3, 2,2);
        Line l2 = new Line(2, 2, 1, 1);
        Line l3 = new Line(1, 1, 0, 3);

        Triangle myTriangle = new Triangle(l1, l2, l3);

        assertEquals(1, myTriangle.getCenter().getX(), 0);
        assertEquals(2, myTriangle.getCenter().getY(), 0);
    }

    @Test
    public void testComputeArea() throws ShapeException{
        Line l1 = new Line(0,3, 2,2);
        Line l2 = new Line(2, 2, 1, 1);
        Line l3 = new Line(1, 1, 0, 3);

        Triangle myTriangle = new Triangle(l1, l2, l3);
        assertEquals(1.5, myTriangle.computeArea(), .00001);
    }

}