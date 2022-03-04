/**
 * ImageFiltering class provides methods for filtering images. The filters are:
 * shades of gray, inverter, redSunset - mine; (fragment, blur, sepia)
 * @author (your name) 
 * @version (a version number or a date)
    */

import edu.duke.*;
import java.io.*;

public class ImageFiltering {
    public ImageResource makeGray(ImageResource inImage) {
        //Make a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel : outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + green + blue
            //divide the sum by 3 and call it "average"
            int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            //Set pixel's red to average
            pixel.setRed(average);
            //Set pixel's green to average
            pixel.setGreen(average);
            //Set pixel's blue to average
            pixel.setBlue(average);
            
        }
        return outImage;
    }
    public ImageResource makeInversion(ImageResource inImage) {
        //Make a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel : outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's inversion for each pixel's red, green and blue values
            //set these values to pixels' values
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getGreen());
            pixel.setBlue(255 - inPixel.getBlue());
            
        }
        return outImage;
    }
    public ImageResource makeRedSunset(ImageResource inImage) {
        //Make a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel px : outImage.pixels()) {
            Pixel inPx = inImage.getPixel(px.getX(), px.getY());

            px.setRed(inPx.getRed() + 40);
            px.setGreen(inPx.getGreen() - 20);
            px.setBlue(inPx.getBlue() - 40);

        }
        return outImage;
    }

    public void applyToSelectedFiles() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeRedSunset(inImage);
            String fname = inImage.getFileName();
            String newName = "img/red_sunset-"+ fname;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
    public static void main(String[] args) {
        ImageFiltering obj1 = new ImageFiltering();
        obj1.applyToSelectedFiles();
    }
}
