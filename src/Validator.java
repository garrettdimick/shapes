import java.util.List;

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
        double side1 = Shape.lineLength(t.getVertex1(), t.getVertex2());
        double side2 = Shape.lineLength(t.getVertex2(), t.getVertex3());
        double side3 = Shape.lineLength(t.getVertex3(), t.getVertex1());
        if(side1 + side2 < side3){
            throw new ShapeException(errorMessage);
        }
        if(side2 + side3 < side1){
            throw new ShapeException(errorMessage);
        }
        if(side1 + side3 < side2){
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
        double side1 = Shape.lineLength(r.getVertex1(), r.getVertex2());
        double side2 = Shape.lineLength(r.getVertex2(), r.getVertex3());
        double side3 = Shape.lineLength(r.getVertex3(), r.getVertex4());
        double side4 = Shape.lineLength(r.getVertex4(), r.getVertex1());
        //Make sure parallel sides are the same length
        if(side1 != side3){
            throw new ShapeException(errorMessage);
        }
        if(side2 != side4){
            throw new ShapeException(errorMessage);
        }
        if(r.getVertex1().getX() != r.getVertex4().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getVertex1().getY() != r.getVertex2().getY()){
            throw new ShapeException(errorMessage);
        }
        if(r.getVertex2().getX() != r.getVertex3().getX()){
            throw new ShapeException(errorMessage);
        }
        if(r.getVertex3().getY() != r.getVertex4().getY()){
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
        double side1 = Shape.lineLength(s.getVertex1(), s.getVertex2());
        double side2 = Shape.lineLength(s.getVertex2(), s.getVertex3());
        double side3 = Shape.lineLength(s.getVertex3(), s.getVertex4());
        double side4 = Shape.lineLength(s.getVertex4(), s.getVertex1());
        //Make sure sides are same length
        if(side1 != side3){
            throw new ShapeException(errorMessage);
        }
        if(side1 != side2){
            throw new ShapeException(errorMessage);
        }
        if(side1 != side4){
            throw new ShapeException(errorMessage);
        }
        if(s.getVertex1().getX() != s.getVertex4().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getVertex1().getY() != s.getVertex2().getY()){
            throw new ShapeException(errorMessage);
        }
        if(s.getVertex2().getX() != s.getVertex3().getX()){
            throw new ShapeException(errorMessage);
        }
        if(s.getVertex3().getY() != s.getVertex4().getY()){
            throw new ShapeException(errorMessage);
        }
    }

    public static void validateInput(List<String> input, String errorMessage) throws ShapeException{
        if(input.get(0).equals("Circle")){
            if(input.size() != 4){
                throw new ShapeException(errorMessage);
            }
            return;
        }
        if(input.get(0).equals("Ellipse")){
            if(input.size() != 5){
                throw new ShapeException(errorMessage);
            }
            return;
        }
        if(input.get(0).equals("Rectangle")){
            if(input.size() != 9){
                throw new ShapeException(errorMessage);
            }
            return;
        }
        if(input.get(0).equals("Square")){
            if(input.size() != 9){
                throw new ShapeException(errorMessage);
            }
            return;
        }
        if(input.get(0).equals("Triangle")){
            if(input.size() != 7){
                throw new ShapeException(errorMessage);
            }
            return;
        }
        throw new ShapeException(errorMessage);
    }
}