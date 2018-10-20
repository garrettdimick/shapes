import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.*;
import javax.imageio.ImageIO;

public class EmbeddedPicture extends Shape{
    final int xPixels = 100;
    final int yPixels = 100;
    private BufferedImage bm;


    public EmbeddedPicture(InputStream instream) throws ShapeException, IOException{
        bm = ImageIO.read(instream);
    }

    @Override
    public double computeArea() {
        return xPixels * yPixels;
    }

    @Override
    public void renderShape(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        float[] scales = {1f, 1f, 1f, 0.5f};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
//        g2D.scale(xPixels, yPixels);
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setRect(xPixels, yPixels, xPixels, yPixels);
        g2D.setClip(rect);
        g2D.drawImage(bm, rop, xPixels, yPixels);
    }

    @Override
    public String toString() {
        return "Bitmap," + "," + xPixels + "," + yPixels;
    }
}
