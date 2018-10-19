import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class EmbeddedPicture extends Shape{
    final int xPixels = 20;
    final int yPixels = 20;


    public EmbeddedPicture(InputStream instream) throws ShapeException, IOException{
        BufferedImage image = ImageIO.read(instream);
        for(int y=1;y<yPixels;y++){
            for(int x=1;x<xPixels;x++){
                int color = image.getRGB(x,y);
            }
        }
    }

    @Override
    public double computeArea() {
        return xPixels * yPixels;
    }

    @Override
    public void renderShape(Graphics g) {
//        g.drawImage(getBitmap(), xPixels,yPixels);
    }


    @Override
    public String toString() {
        return null;
    }

}
