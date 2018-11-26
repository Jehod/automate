/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import static params.Params.langRef;
import static params.Params.pathLabel;

/**
 *
 * @author nik
 */
public class Formulaire
{

    ArrayList listFormulaire = new ArrayList();

    private Formulaire()
    {

        listFormulaire = listerFormulaire(langRef);
        
    }

    private static class PaysHolder
    {

        private static final Formulaire INSTANCE = new Formulaire();
    }

    public static Formulaire getInstance()
    {
        return PaysHolder.INSTANCE;
    }

    /**
     * renvoie la liste des formulaires les .xlsx present dans le dossier de langue ref
     * @return 
     */
    public ArrayList getListFormulaire()
    {
        return listFormulaire;
    }

    public void setListFormulaire(ArrayList listFormulaire)
    {
        this.listFormulaire = listFormulaire;
    }

    /**
     * va dans le dossier de langref, trie les xlsx et recup les noms des formulaires
     * @param langRef
     * @return 
     */
    private ArrayList listerFormulaire(String langRef)
    {
        ArrayList list = new ArrayList();
        List liTemp;
        String str;

        liTemp = Outils.FilesWorker.ListerFilesByExt(pathLabel + "/" + langRef, ".xlsx");
        System.out.println("taille de la liste de smeithde "+liTemp.size());
        for (int i = 0; i < liTemp.size(); i++)
        {
            str = (String) liTemp.get(i);
            str = str.replace("Label_", "");

            if (str.contains(".xlsx")) str = str.replace("_" + langRef + ".xlsx", "");
           
            
            System.out.println("le nom du fichier decoupé: " + str);
            list.add(str);
            

        }
        

        return list;
    }

}
