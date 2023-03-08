package aegtool;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class FontSize {
    public static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);

        for (Enumeration keys = UIManager.getDefaults().keys();

             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();

            Object value = UIManager.get(key);

            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);

            }

        }

    }
}
