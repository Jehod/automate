/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package params;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author nrochas
 */
public class ColorChart {
    
    
    public static Color colorBack;
    public static Color colorFont;
    public static Color colorFront;
    public static Font titre1;
    public static Font titre3;
    public static Font titre2;
     public static Font fontCorps;

    private ColorChart() {
        colorBack = new Color(0,156,180);
        colorFont = new Color(251,187,0);
        colorFront = new Color(76,79,83);
        titre1 = new Font("TAHOMA",Font.BOLD, 13);
    }

   
    
    
    
    public static ColorChart getInstance() {
        return ColorChartHolder.INSTANCE;
    }
    
    private static class ColorChartHolder {

        private static final ColorChart INSTANCE = new ColorChart();
    }
}