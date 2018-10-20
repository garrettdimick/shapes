import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testValidConstruction() throws ShapeException{
        Point p1 = new Point(1,1);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException{

        try {

            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }
    }

    @Test
    public void testComputeArea() throws ShapeException{
        Point center = new Point(1,1);
        Line l1 = new Line(0,3, 2,3);
        Line l2 = new Line(2, 3, 2, -1);
        Line l3 = new Line(2, -1, 0, -1);
        Line l4 = new Line(0, -1, 0, 3);

        Rectangle myRectangle = new Rectangle(l1, l2, l3, l4);
        assertEquals(8, myRectangle.computeArea(), .0001);
    }

    @Test
    public void testRectangleCalcCenter() throws ShapeException{
        Line l1 = new Line(0,3, 2,3);
        Line l2 = new Line(2, 3, 2, -1);
        Line l3 = new Line(2, -1, 0, -1);
        Line l4 = new Line(0, -1, 0, 3);

        Rectangle myRectangle = new Rectangle(l1, l2, l3, l4);
        assertEquals(1, myRectangle.getCenter().getX(), 0);
        assertEquals(1, myRectangle.getCenter().getY(), 0);
    }
}