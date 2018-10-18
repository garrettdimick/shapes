/**
 * Circle
 *
 * This class represents circle objects that can be moved and scaled.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle extends Shape{
    private double radius;

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the circle -- must be a valid point
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double radius) throws ShapeException {
        super(center);
        Validator.validateDouble(radius, "Invalid radius");
        if (center==null)
            throw new ShapeException("Invalid center point");
        this.radius = radius;
    }

    /**
     * @return  The radius of the circle
     */
    public double getRadius() { return radius; }

    /**
     * @return  The area of the circle.
     */
    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
