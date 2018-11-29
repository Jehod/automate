/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.FenAccueil;
import view.Fenetre;
import view.FrameGenerik;

/**
 *
 * @author nrochas
 */
public class Automate
{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                params.Params.getInstance();
                
               

               FenAccueil fa = new FenAccueil();
                fa.setLocation(500, 200);
                fa.setSize(400, 400);
                fa.setVisible(true);
            }
        });
    }
}
