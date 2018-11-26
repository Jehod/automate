/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outils;


import entity.Formulaire;
import entity.Methode;
import java.util.ArrayList;

/**
 *
 * @author nrochas
 */
public class ToolsString
{


    /**
     * iter une list pour trouver un contenu cible
     *
     *
     * @param list
     * @param cible
     * @return true si la cible a été trouvé
     */
    public static boolean searchInList(ArrayList<String> list, String cible)

    {
        boolean bob = false;

        for (String str : list)
        {
            if (str.equals(cible))
            {
                bob = true;
            }

        }

        return bob;
    }


}
