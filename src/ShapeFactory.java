import java.io.InputStream;
import java.util.HashMap;

public class ShapeFactory {

    /**
     * shapeMap is a hashmap that will keep track of all of the Shapes that are created.
     * When the ShapeFactory receives a request to generate a new shape, it checks if that shape is in the hashmap
     * and if it is, it returns it. If not, it creates the new Shape.
     */
    private static final HashMap shapeMap = new HashMap();

//    public static CompositeShape getComposite() {
//
//    }

//    public static Shape getCircle(String id){
////        Circle c = (Circle)shapeMap.get(id);
////        if(c==null){
////            createCircleFromInput();
////
////        }
////        return
//    }

//    public void parseInput(){
//        InputStream in = new InputStream();
//    }
}
