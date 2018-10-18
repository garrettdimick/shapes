public abstract class Shape {
    private Point center;

    /** Constructor
     *
     * @param cen - Point for center of Shape
     * @throws ShapeException - thrown if Point is not a valid Point
     */
    protected Shape(Point cen) throws ShapeException {
        if (cen==null)
            throw new ShapeException("Invalid center point");
        Validator.validatePoint(cen, "Invalid Point");
        center = new Point(cen.getX(), cen.getY());
    }

    /**
     * Constructor
     * @param x - x value for center of Shape
     * @param y - y value for center of Shape
     * @throws ShapeException - thrown if x or y are not valid doubles
     */
    protected Shape(double x, double y) throws ShapeException{
        Validator.validateDouble(x, "Invalid x-location");
        Validator.validateDouble(y, "Invalid y-location");
        center = new Point(x, y);
    }

    public Shape() throws ShapeException{
        this.center = new Point(0,0);
    }

    /**
     * abstract method computeArea(), will need to be defined for each class extending Shape
     * @return
     */
    public abstract double computeArea();
    public Point getCenter(){return center;}

    /**
     *  Set the center point for the Shape object
     * @param c
     * @throws ShapeException - thrown if Point is not a valid Point
     */
    public void setCenter(Point c) throws ShapeException {
        Validator.validatePoint(c, "Invalid Point");
        this.center = new Point(c.getX(), c.getY());
    }
    /**
     * Move a shape
     * @param deltaX            a delta change for the x-location of center of the shape
     * @param deltaY            a delta change for the y-location of center of the shape
     * @throws ShapeException   Exception thrown if either the delta x or y are not valid doubles
     */
    public void moveCenter(double deltaX, double deltaY) throws ShapeException {
        Validator.validateDouble(deltaX, "Invalid x value");
        Validator.validateDouble(deltaY, "Invalid y value");
        center.move(deltaX, deltaY);
    }
}