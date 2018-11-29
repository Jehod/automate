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
public class ButtonGenerik extends JButton{
    

    

    @Override
    public void setForeground(Color fg) {
        super.setForeground(params.ColorChart.colorFont); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFont(Font font) {
        super.setFont(params.ColorChart.fontButton); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setToolTipText(String text) {
        super.setToolTipText("Ceci est un Bouton et cliquer dessus produira un effet (sans doute)"); //To change body of generated methods, choose Tools | Templates.
    }

    
}
