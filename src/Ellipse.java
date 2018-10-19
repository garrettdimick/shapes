import java.awt.*;

public class Ellipse extends Shape{
    private double xRadius;
    private double yRadius;

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

    @Override
    public void renderShape(Graphics g) {
        g.drawOval((int) this.getCenter().getX(), (int)this.getCenter().getY(), (int)this.xRadius, (int)this.yRadius);
    }

    public double getxRadius() {
        return xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public String toString(){
        return "Ellipse," + this.getCenter().toString() + "," + this.getxRadius() + "," + this.getyRadius() + "|";
    }
}