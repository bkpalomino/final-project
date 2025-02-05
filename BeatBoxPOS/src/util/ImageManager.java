package util;

import java.awt.Image;
import javax.swing.ImageIcon;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Util class that serves as an image creation / image manipulator (Resizing) service. 
 */
public class ImageManager {

    public static final int SIZE_ICON = 17;
    public static final int SIZE_PREVIEW = 200;
    public static final int SIZE_CART_VIEW = 75;
    public static final int SIZE_LARGE = 500;

    // Gets scaled icon from imageicon
    public static ImageIcon getScaledImageIcon(ImageIcon icon, int size) {
        Image originalImage = icon.getImage();

        // Scale the image appropriatly, keeping proper aspect ratio
        double aspectX = icon.getIconWidth();
        double aspectY = icon.getIconHeight();

        double previewScaleFactorX = size / aspectX;
        double previewScaleFactorY = size / aspectY;

        double scaleFactor = Math.min(previewScaleFactorX, previewScaleFactorY);

        int scaledX = ((int) (aspectX * scaleFactor));
        int scaledY = ((int) (aspectY * scaleFactor));

        Image scaledImage = originalImage.getScaledInstance(scaledX, scaledY, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    // Gets scaled icon from byte[]
    public static ImageIcon getScaledImageIcon(byte[] byteArray, int size) {
        ImageIcon scaledIcon = null;

        try {
            // Crop the image to a square doing the following                    
            ImageIcon icon = new ImageIcon(byteArray);
            Image originalImage = icon.getImage();

            // Scale the image appropriatly, keeping proper aspect ratio
            double aspectX = icon.getIconWidth();
            double aspectY = icon.getIconHeight();

            double previewScaleFactorX = size / aspectX;
            double previewScaleFactorY = size / aspectY;

            double scaleFactor = Math.min(previewScaleFactorX, previewScaleFactorY);

            int scaledX = ((int) (aspectX * scaleFactor));
            int scaledY = ((int) (aspectY * scaleFactor));

            Image scaledImage = originalImage.getScaledInstance(scaledX, scaledY, Image.SCALE_SMOOTH);

            scaledIcon = new ImageIcon(scaledImage);

        } catch (Exception ex) {

        }

        return scaledIcon;
    }


}
