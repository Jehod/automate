/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automate;

import entity.Methode;
import entity.Pays;

/**
 *
 * @author nik
 */
public class EcrivainScreenShot
{

    private Methode meth = Methode.getInstance();
    private Pays pay = Pays.getInstance();
    private MethodMatcher methMatch = new MethodMatcher();   

    public EcrivainScreenShot()
    {

    }


/**
 * lance le script suivant les lists, recupere la version a ce moment la et match la methode avec son formulaire
 * @return le text a copicoller dans le screenbuilder 
 */
    public String getScript()
    {
        String scr = "";
     

        for (String langue : pay.getListExt())
        {
            for (String fDEF : meth.getListMExt())
            {
                
                String formulaire = methMatch.matchMethodNform(fDEF);
                System.out.println("formulaire: "+formulaire+" methode: "+fDEF);
                String version = methMatch.GetVersionFromDoclang(langue, formulaire);
                
                //eProScreenBuilder.exe -output "Screenshots\AR_IL" -mode2 -workflow "FDEF.3_EQ5D5L:PRO" "FDEF.3_EQ5D5L:AR_IL(1.0.0)"
                
                scr = scr + "eProScreenBuilder.exe -output \"Screenshots\\" + langue + "\" -mode2 -workflow \"" + fDEF + ":PRO\" \"" + fDEF + ":" + langue + "(" + version + ")\"" + "\n";

            }
            scr += "\n";
        }
        return scr;
    }

}
