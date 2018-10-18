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
        validateLine(t.getSide1(), "Invalid Line for a Triangle");
        validateLine(t.getSide2(), "Invalid Line for a Triangle");
        validateLine(t.getSide3(), "Invalid Line for a Triangle");
        if(t.getVertex1().getX() == t.getVertex2().getX()){
            if(t.getVertex1().getX() == t.getVertex3().getX()){
                throw new ShapeException(errorMessage);
            }
        }
        if(t.getSide1().computeLength() + t.getSide2().computeLength() < t.getSide3().computeLength()){
            throw new ShapeException(errorMessage);
        }
        if(t.getSide2().computeLength() + t.getSide3().computeLength() < t.getSide1().computeLength()){
            throw new ShapeException(errorMessage);
        }
        if(t.getSide1().computeLength() + t.getSide3().computeLength() < t.getSide2().computeLength()){
            throw new ShapeException(errorMessage);
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
        validateLine(r.getSide1(), "Invalid side for this rectangle");
        validateLine(r.getSide2(), "Invalid side for this rectangle");
        validateLine(r.getSide3(), "Invalid side for this rectangle");
        validateLine(r.getSide4(), "Invalid side for this rectangle");
        //Make sure parallel sides are the same length
        if(r.getSide1().computeLength() != r.getSide3().computeLength()){
            throw new ShapeException(errorMessage);
        }
        if(r.getSide2().computeLength() != r.getSide4().computeLength()){
            throw new ShapeException(errorMessage);
        }
        //Corner 1 check
        if(r.getSide1().getPoint2().getX() != r.getSide2().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getSide1().getPoint2().getY() != r.getSide2().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //Corner 2 check
        if(r.getSide2().getPoint2().getX() != r.getSide3().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getSide2().getPoint2().getY() != r.getSide3().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //corner 3 check
        if(r.getSide3().getPoint2().getX() != r.getSide4().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getSide3().getPoint2().getY() != r.getSide4().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //corner 4 check
        if(r.getSide4().getPoint2().getX() != r.getSide1().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getSide4().getPoint2().getY() != r.getSide1().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
    }

    /**
     * Check if a square is valid
     * All sides must be the same length, positive values, connect to each other in the appropriate way
     * @param s
     * @param errorMessage
     * @throws ShapeException
     */
    public static void validateSquare(Square s, String errorMessage) throws ShapeException{
        validateLine(s.getSide1(), "Invalid side for this square");
        validateLine(s.getSide2(), "Invalid side for this square");
        validateLine(s.getSide3(), "invalid side for this square");
        validateLine(s.getSide4(), "Invalid side for this square");
        //Make sure all sides are the same length
        if(s.getSide1().computeLength() != s.getSide2().computeLength()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide1().computeLength() != s.getSide3().computeLength()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide1().computeLength() != s.getSide4().computeLength()){
            throw new ShapeException(errorMessage);
        }
        //Corner 1 check
        if(s.getSide1().getPoint2().getX() != s.getSide2().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide1().getPoint2().getY() != s.getSide2().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //Corner 2 check
        if(s.getSide2().getPoint2().getX() != s.getSide3().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide2().getPoint2().getY() != s.getSide3().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //corner 3 check
        if(s.getSide3().getPoint2().getX() != s.getSide4().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide3().getPoint2().getY() != s.getSide4().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
        //corner 4 check
        if(s.getSide4().getPoint2().getX() != s.getSide1().getPoint1().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getSide4().getPoint2().getY() != s.getSide1().getPoint1().getY()){
            throw new ShapeException(errorMessage);
        }
    }
}