/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.apache.log4j.Priority;
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
                Outils.Loggeur.logMessage("Ouverture du log", Priority.DEBUG_INT);
                params.Params.getInstance();
                params.ColorChart.getInstance();
                
               

               FenAccueil fa = new FenAccueil();
               
            }
        });
    }
}
