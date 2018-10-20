import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest{

    @Test
    public void testValidConstruction() throws ShapeException{
        Line l1 = new Line(0,4, 4,4);
        Line l2 = new Line(4, 4, 4, 0);
        Line l3 = new Line(4, 0, 0, 0);
        Line l4 = new Line(0, 0, 0, 4);

        Square mySquare = new Square(l1, l2, l3, l4);
        assertEquals(mySquare.getVertex1().getX(), 0, 0);
        assertEquals(mySquare.getVertex1().getY(), 4, 0);
        assertEquals(mySquare.getVertex2().getX(), 4, 0);
        assertEquals(mySquare.getVertex2().getY(), 4, 0);
        assertEquals(mySquare.getVertex3().getX(), 4, 0);
        assertEquals(mySquare.getVertex3().getY(), 0, 0);
        assertEquals(mySquare.getVertex4().getX(), 0, 0);
        assertEquals(mySquare.getVertex4().getY(), 0, 0);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException{

        try {
            Line l1 = new Line(0,4, 4,4);
            Line l2 = new Line(4, 4, 4, 0);
            Line l3 = new Line(Double.NaN, 0, 0, 0);
            Line l4 = new Line(0, 0, 0, 4);
            new Square(l1, l2, l3, l4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }
    }

    @Test
    public void testComputeArea() throws ShapeException{
        Line l1 = new Line(0,4, 4,4);
        Line l2 = new Line(4, 4, 4, 0);
        Line l3 = new Line(4, 0, 0, 0);
        Line l4 = new Line(0, 0, 0, 4);

        Square mySquare = new Square(l1, l2, l3, l4);
        assertEquals(16, mySquare.computeArea(), .00001);
    }

    @Test
    public void testSquareCalcCenter() throws ShapeException{
        Line l1 = new Line(0,4, 4,4);
        Line l2 = new Line(4, 4, 4, 0);
        Line l3 = new Line(4, 0, 0, 0);
        Line l4 = new Line(0, 0, 0, 4);

        Square mySquare = new Square(l1, l2, l3, l4);
        assertEquals(2, mySquare.getCenter().getX(), 0);
        assertEquals(2, mySquare.getCenter().getY(), 0);
    }

}