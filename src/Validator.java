public class Validator {
    public static void validateDouble(double value, String errorMessage) throws ShapeException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new ShapeException(errorMessage);
    }

    public static void validatePositiveDouble(double value, String errorMessage) throws ShapeException {
        validateDouble(value, errorMessage);
        if (value<=0)
            throw new ShapeException(errorMessage);
    }

    public static void validatePoint(Point p, String errorMessage) throws ShapeException {
        validateDouble(p.getX(), errorMessage);
        validateDouble(p.getY(), errorMessage);
        if(p == null){
            throw new ShapeException(errorMessage);
        }
    }

    public static void validateLine(Line l, String errorMessage) throws ShapeException {
        validatePoint(l.getPoint1(), errorMessage);
        validatePoint(l.getPoint2(), errorMessage);
        if(l.getPoint1() == null){
            throw new ShapeException(errorMessage);
        }
        if(l.getPoint2() == null){
            throw new ShapeException(errorMessage);
        }
        if(l.computeLength( )< 0.00000001)
            throw new ShapeException(errorMessage);
    }

    /**
     * Check if a Triangle is a valid Triangle
     * No edge should have zero length, vertices cannot all be in the same line, length of an edge cannot be > than the
     * sum of the other two
     * @param t
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateTriangle(Triangle t, String errorMessage) throws ShapeException{

        if(t.getVertex1().getX() == t.getVertex2().getX()){
            if(t.getVertex1().getX() == t.getVertex3().getX()){
                throw new ShapeException(errorMessage);
            }
        }
    }

    /**
     * Check if an Ellipse is a valid Ellipse
     * Area cannot be zero, must have positive x and y radius lengths
     * @param e
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateEllipse(Ellipse e, String errorMessage)throws ShapeException{
        validatePositiveDouble(e.getxRadius(), "Invalid x radius");
        validatePositiveDouble(e.getyRadius(), "Invalid y radius");
        if(e.computeArea() <= 0){
            throw new ShapeException(errorMessage);
        }
    }

    /**
     * Check if a Circle is valid
     * No zero area, must have positive radius value
     * @param c
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateCircle(Circle c, String errorMessage) throws ShapeException{
        validatePositiveDouble(c.getRadius(), "Invalid Radius");
        if(c.computeArea() <= 0){
            throw new ShapeException(errorMessage);
        }
    }

    /**
     * Check if a Rectangle is valid
     * Edges must have a positive length and connect to one another in the appropriate way
     * @param r
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateRectangle(Rectangle r, String errorMessage) throws ShapeException{

    }

    /**
     * Check if a square is valid
     * All sides must be the same length, positive values, connect to each other in the appropriate way
     * @param s
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateSquare(Square s, String errorMessage) throws ShapeException{

    }
}