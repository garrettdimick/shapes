import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeShapeTest {

    @Test
    public void testValidConstruction() throws ShapeException {

    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Circle(null, 2.5);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid center point", e.getMessage());
        }

        try {
            new Circle(new Point(1, 2), Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(new Point(1, 2), Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(new Point(1, 2), Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(Double.POSITIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Circle(Double.NEGATIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Circle(Double.NaN, 2, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Circle(1, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Circle(1, Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Circle(1, Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }


        try {
            new Circle(1, 2, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(1, 2, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(1, 2, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }
    }
    @Test
    public void testAdd(){
        Circle myCircle = new Circle(center, 5);
        Ellipse myEllipse = new Ellipse(center, 5, 4);

    }
}