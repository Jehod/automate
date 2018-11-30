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
public class ColorChart
{

    public static Color colorBack;
    public static Color colorFont;
    public static Color colorFront;
    public static Font fontCorps;
    public static Font fontButton;
    public static Font titre3;
    public static Font titre2;
    public static Font titre1;
    public static Font fontCorpsReduit;

    private ColorChart()
    {
        colorBack = new Color(0, 156, 180);
        colorFront = new Color(251, 187, 0);
        colorFont = new Color(76, 79, 83);
        fontCorps = new Font("Tekton pro Ext", Font.PLAIN, 12);
        titre3 = fontCorps.deriveFont(Font.BOLD, 13);

        fontButton = fontCorps.deriveFont(13);
        titre2 = fontCorps.deriveFont(Font.BOLD,15);
        titre1 = fontCorps.deriveFont(Font.BOLD,18);
        fontCorpsReduit = fontCorps.deriveFont(7);
    }

    public static ColorChart getInstance()
    {
        return ColorChartHolder.INSTANCE;
    }

    private static class ColorChartHolder
    {

        private static final ColorChart INSTANCE = new ColorChart();
    }
}
