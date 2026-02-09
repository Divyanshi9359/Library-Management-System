package ui;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel
{

    private Image image;

    public BackGroundPanel(String imagePath)
    {

        // Try classpath resource
        var url = getClass().getResource(imagePath);
        System.out.println("getResource URL = " + url);

        if (url != null)
        {
            image = new ImageIcon(url).getImage();
        }
        else
        {
            System.out.println("Resource not found, trying fallback path");

            // fallback: relative path to src folder
            image = new ImageIcon("src/main/resources/images/pict.png").getImage();

            // check if file exists
            System.out.println("Image width: " + image.getWidth(null));
        }
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
