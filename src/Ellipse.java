public class Ellipse extends Shape{
    private double xRadius;
    private double yRadius;

    /**
     * Constructor with x and y for the center
     * @param x
     * @param y
     * @param xRad
     * @param yRad
     * @throws ShapeException
     */
    public Ellipse(double x, double y, double xRad, double yRad) throws ShapeException{
        super(x,y);
        Validator. validatePositiveDouble(xRad, "Invalid X-Radius");
        Validator. validatePositiveDouble(yRad, "Invalid Y-Radius");
        this.xRadius = xRad;
        this.yRadius = yRad;
        Validator.validateEllipse(this, "Invalid Ellipse Construction");
    }

    /**
     * Constructor with a Point for the center
     * @param cen
     * @param xRad
     * @param yRad
     * @throws ShapeException
     */
    public Ellipse(Point cen, double xRad, double yRad) throws ShapeException{
        super(cen);
        Validator. validatePositiveDouble(xRad, "Invalid X-Radius");
        Validator. validatePositiveDouble(yRad, "Invalid Y-Radius");
        this.xRadius = xRad;
        this.yRadius = yRad;
        Validator.validateEllipse(this, "Invalid Ellipse Construction");
    }

    /**
     * Computes the area of an Ellipse, pi * a * b
     * @return
     */
    public double computeArea(){
        return Math.PI * this.xRadius * this.yRadius;
    }

    public double getxRadius() {
        return xRadius;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public void setyRadius(double yRadius) {
        this.yRadius = yRadius;
    }
}