import java.util.ArrayList;
import java.util.Iterator;

public class CompositeShape extends Shape{
    ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public CompositeShape() throws ShapeException {
    }

    public void add(Shape s){
        shapeList.add(s);
    }

    public void remove(Shape s){
        shapeList.remove(s);
    }

    public Shape getChild(int i){
        return shapeList.get(i);
    }

    public double computeArea(){
        double area = 0;
        Iterator<Shape> iterator = shapeList.iterator();
        while(iterator.hasNext()){
            Shape shape = iterator.next();
            area += shape.computeArea();
        }
        return area;
    }


}
