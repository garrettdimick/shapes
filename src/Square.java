import java.awt.*;

public class Square extends Shape{
    private double sideLength;
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private Point vertex4;

    /**
     * Constructor for Square, point 1 is top left, point 2 is top right, point 3 is bottom right and point 4 is bottom left
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     * @throws ShapeException
     */
    public Square(Point v1, Point v2, Point v3, Point v4) throws ShapeException{
        super();
        Validator.validatePoint(v1, "Invalid side");
        Validator.validatePoint(v2, "Invalid side");
        Validator.validatePoint(v3, "Invalid side");
        Validator.validatePoint(v4, "Invalid side");
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;
        this.vertex4 = v4;

        Point c = squareCalcCenter();
        this.setCenter(c);
        this.sideLength = lineLength(vertex1, vertex2);
        Validator.validateSquare(this, "Invalid Square Construction");
    }

    public double computeArea(){
        return this.sideLength * this.sideLength;
    }

    @Override
    public void renderShape(Graphics g) {
        g.drawRect((int)this.vertex1.getX(), (int)this.vertex1.getY(), (int)this.getSideLength(), (int)this.getSideLength());
    }

    public Point squareCalcCenter() throws ShapeException{
        Point p = new Point((vertex1.getX() + vertex3.getX())/2,(vertex1.getY() + vertex3.getY())/2);
        return p;
    }

    public String toString(){
        return "Square," + this.getVertex1().toString() + "," + this.getVertex2().toString()
                + "," + this.getVertex3().toString() + "," + this.getVertex4().toString() + ",";
    }

    public double getSideLength(){
        return sideLength;
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

    public Point getVertex4() {
        return vertex4;
    }


}