
package util;

import java.io.InputStream;
import javax.swing.ImageIcon;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Util class that serves as a resource loader. 
 */

public class ResourceLoader {
    
    
    public static ImageIcon getResourceIcon(String path, int size) {   
        ImageIcon original = new ImageIcon(ResourceLoader.class.getClassLoader().getResource(path));
        return ImageManager.getScaledImageIcon(original, size);
    }
    
    // Get the input stream from a path
    public static InputStream getResourceInputStream(String path) {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(path);
    }
    
}
