import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ShapeFactory is a factory class that creates
 */
public class ShapeFactory {

    /**
     * shapeMap is a hashmap that will keep track of all of the Shapes that are created.
     * When the ShapeFactory receives a request to generate a new shape, it checks if that shape is in the hashmap
     * and if it is, it returns it. If not, it creates the new Shape.
     */
    private static final HashMap shapeMap = new HashMap();

    public static Shape generateShape(String k) throws ShapeException {
        Shape shape = (Shape) shapeMap.get(k);
        if(shapeMap.containsKey(k)){
//            System.out.println("SHAPE WAS IN THE HASH MAP DUDE!");
            return (Shape) shapeMap.get(k);
        }
        if(shape == null) {
            List<String> input = parseInput(k);
            Validator.validateInput(input, "Invalid Input.");
            if(input.get(0).equals("Circle")){

                Point c = new Point(Double.parseDouble(input.get(1)), Double.parseDouble(input.get(2)));
                shape = new Circle(c, Double.parseDouble(input.get(3)));
                shapeMap.put(shape.toString(), shape);
                return shape;
            }
            if(input.get(0).equals("Ellipse")){
                Point c = new Point(Double.parseDouble(input.get(1)), Double.parseDouble(input.get(2)));
                shape = new Ellipse(c, Double.parseDouble(input.get(3)), Double.parseDouble(input.get(3)));
                shapeMap.put(shape.toString(), shape);
                return shape;
            }
            if(input.get(0).equals("Rectangle")){
                Point p1 = new Point(Double.parseDouble(input.get(1)), Double.parseDouble(input.get(2)));
                Point p2 = new Point(Double.parseDouble(input.get(3)), Double.parseDouble(input.get(4)));
                Point p3 = new Point(Double.parseDouble(input.get(5)), Double.parseDouble(input.get(6)));
                Point p4 = new Point(Double.parseDouble(input.get(7)), Double.parseDouble(input.get(8)));
                shape = new Rectangle(p1, p2, p3, p4);
                shapeMap.put(shape.toString(), shape);
                return shape;
            }
            if(input.get(0).equals("Square")){
                Point p1 = new Point(Double.parseDouble(input.get(1)), Double.parseDouble(input.get(2)));
                Point p2 = new Point(Double.parseDouble(input.get(3)), Double.parseDouble(input.get(4)));
                Point p3 = new Point(Double.parseDouble(input.get(5)), Double.parseDouble(input.get(6)));
                Point p4 = new Point(Double.parseDouble(input.get(7)), Double.parseDouble(input.get(8)));
                shape = new Square(p1, p2, p3, p4);
                shapeMap.put(shape.toString(), shape);
                return shape;
            }
            if(input.get(0).equals("Triangle")){
                Point p1 = new Point(Double.parseDouble(input.get(1)), Double.parseDouble(input.get(2)));
                Point p2 = new Point(Double.parseDouble(input.get(3)), Double.parseDouble(input.get(4)));
                Point p3 = new Point(Double.parseDouble(input.get(5)), Double.parseDouble(input.get(6)));
                shape = new Triangle(p1, p2, p3);
                shapeMap.put(shape.toString(), shape);
                return shape;
            }
//            if(input.get(0).equals("Composite")){
//                CompositeShape cs = new CompositeShape();
//                input.remove(0);
//                System.out.println("INPUT WILL BE: " + backToString(input));
//                cs.add(generateShape(backToString(input)));
//            }
        }
        return null;
    }

    /**
     * This method takes an input string and returns it as a String array which allows for easier processing by the
     * ShapeFactory
     * @param s
     * @return
     */
    public static List<String> parseInput(String s){
        String[] splitInput = s.split(",");
        List<String> inputList = new ArrayList<String>();
        for(String str : splitInput){
            inputList.add(str);
        }
        return inputList;
    }

    public static String backToString(List<String> l){
        String s = "";
        for(String i : l){
            s += i;
            s += ",";
        }
        return s;
    }

    public static byte[] loadInputStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream is = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while((length = inStream.read(buffer))!=-1){
            is.write(buffer, 0, length);
        }
        return is.toByteArray();
    }

    public static Shape loadShapeFromFile(String filepath) throws ShapeException, IOException{
        InputStream in = null;
        try {
            in = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = ShapeFactory.loadInputStream(in);
        String inputString = new String(bytes);
        Shape newShape = generateShape(inputString);
        return newShape;
    }
}
