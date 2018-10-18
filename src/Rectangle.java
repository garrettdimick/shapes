public class Rectangle extends Shape{
    private double height;
    private double width;
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private Point vertex4;

    /**
     * Constructor with a Point for the center, and four points for the corners
     * Ensures that point 1 is top left, point 2 is top right, point 3 is bottom right and point 4 is bottom left
     * @param v1,
     * @param v2
     * @param v3
     * @param v4
     * @throws ShapeException
     */

    public Rectangle(Point v1, Point v2, Point v3, Point v4) throws ShapeException{
        super();
        Validator.validatePoint(v1, "Invalid side");
        Validator.validatePoint(v2, "Invalid side");
        Validator.validatePoint(v3, "Invalid side");
        Validator.validatePoint(v4, "Invalid side");
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;
        this.vertex4 = v4;

        Point c = this.rectangleCalcCenter();
        this.setCenter(c);
        this.height = lineLength(vertex1, vertex4);
        this.width = lineLength(vertex1, vertex2);
        Validator.validateRectangle(this, "Invalid rectangle construction");
    }

    public Point rectangleCalcCenter() throws ShapeException{
        Point p = new Point((vertex1.getX() + vertex3.getX())/2,(vertex1.getY() + vertex3.getY())/2);
        return p;
    }

    public double computeArea(){
        return this.height * this.width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
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