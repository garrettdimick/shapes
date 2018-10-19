import java.awt.*;
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

    public void removeAll(){
        for(Shape s : shapeList){
            shapeList.remove(s);
        }
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

    @Override
    public void renderShape(Graphics g) {
        Iterator<Shape> iterator = shapeList.iterator();
        while(iterator.hasNext()){
            Shape shape = iterator.next();
            shape.renderShape(g);
        }
    }

    public String toString(){
        String compositeStr = "Composite[";
        Iterator<Shape> iterator = shapeList.iterator();
        while(iterator.hasNext()){
            Shape shape = iterator.next();
            compositeStr += shape.toString();
        }
        compositeStr+="]";
        return compositeStr;
    }
}
