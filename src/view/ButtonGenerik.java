/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author nrochas
 */
public class ButtonGenerik extends JButton
{

    public ButtonGenerik()
    {
        super.setSize(140, 25);
        super.setForeground(params.ColorChart.colorFont);
        super.setFont(params.ColorChart.fontButton);
        super.setToolTipText("Ceci est un Bouton et cliquer dessus produira un effet (sans doute)");
    }

}
