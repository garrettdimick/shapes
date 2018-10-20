import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5, 4);
        assertEquals(5, myEllipse.getxRadius(), 0);
        assertEquals(4, myEllipse.getyRadius(),0);

        myEllipse = new Ellipse(1, 1, 3, 2);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(1, myEllipse.getCenter().getY(), 0);
        assertEquals(3, myEllipse.getxRadius(), 0);
        assertEquals(2, myEllipse.getyRadius(), 0);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException{
        try {
            new Ellipse(null, 4, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e){
            assertEquals("Invalid center point", e.getMessage());
        }

        try {
            new Ellipse(new Point(1,2), Double.POSITIVE_INFINITY, 2);
            fail("Expected exception not thrown");
        } catch (ShapeException e){
            assertEquals("Invalid X-Radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1,2), 2, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e){
            assertEquals("Invalid Y-Radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1,2), Double.NaN, 2);
            fail("Expected exception not thrown");
        } catch (ShapeException e){
            assertEquals("Invalid X-Radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1,2), 2, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e){
            assertEquals("Invalid Y-Radius", e.getMessage());
        }

    }

    @Test
    public void testComputeArea() throws ShapeException{
        Ellipse myEllipse = new Ellipse(2, 2, 4, 5);
        assertEquals(62.83185, myEllipse.computeArea(), .0001);
    }

}
