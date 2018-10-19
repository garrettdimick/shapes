import java.awt.*;

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
     * @param cen            The Point of the center of the circle -- must be a valid point
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point cen, double radius) throws ShapeException {
        super(cen);
        Validator.validateDouble(radius, "Invalid radius");
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

    @Override
    public void renderShape(Graphics g) {
        g.drawOval((int) this.getCenter().getX(), (int)this.getCenter().getY(), (int)this.radius, (int)this.radius);
    }

    public String toString(){
        return "Circle," + this.getCenter().toString() + "," + this.getRadius() + "|";
    }

}
