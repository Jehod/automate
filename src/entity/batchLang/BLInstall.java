/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.batchLang;

import java.util.ArrayList;

/**
 *
 * @author nrochas
 */
public class BLInstall {

    private String numMantis;
    private String numBatch;
    private ArrayList<String> listLangues = new ArrayList<>();
    private String versCliForm;
    private String versEpro;
    private String contrainte = 5 + "";

    private String corps;

    public BLInstall(String numMantis, String numBatch, ArrayList<String> listLangues, String versCliForm, String versEpro)
        {

        this.numMantis = numMantis;
        this.numBatch = numBatch;
        this.listLangues = listLangues;
        this.versCliForm = versCliForm;
        this.versEpro = versEpro;
        initCorps();
        }

    public String createFile()
        {
        return corps;
        }

    private String toListLang(ArrayList<String> listLangues)
        {
        String str = "";

        for (String lg : listLangues)
        {
            if (!str.equals(""))
            {
                str = str + ", ";
            }
            str = str + lg;
        }

        return str;
        }

    public String getNumMantis()
        {
        return numMantis;
        }

    public void setNumMantis(String numMantis)
        {
        this.numMantis = numMantis;
        }

    public String getNumBatch()
        {
        return numBatch;
        }

    public void setNumBatch(String numBatch)
        {
        this.numBatch = numBatch;
        }

    public ArrayList<String> getListLangues()
        {
        return listLangues;
        }

    public void setListLangues(ArrayList<String> listLangues)
        {
        this.listLangues = listLangues;
        }

    public String getVersCliForm()
        {
        return versCliForm;
        }

    public void setVersCliForm(String versCliForm)
        {
        this.versCliForm = versCliForm;
        }

    public String getVersEpro()
        {
        return versEpro;
        }

    public void setVersEpro(String versEpro)
        {
        this.versEpro = versEpro;
        }

    public String getContrainte()
        {
        return contrainte;
        }

    public void setContrainte(String contrainte)
        {
        this.contrainte = contrainte;
        }

    public String getCorps()
        {
        return corps;
        }

    public void setCorps(String corps)
        {
        this.corps = corps;
        }

    private void initCorps()
        {
        corps = "Mantis " + numMantis + " BATCH " + numBatch + ": rajout langues " + toListLang(listLangues) + "\n"
                + "------------------------------------------------\n"
                + "\n"
                + "1. Prérequis\n"
                + "- Dernières versions de Clin'form " + versCliForm + " et ePro " + versEpro + "\n"
                + "	\n"
                + "- Batch 1 et 2 installés\n"
                + "\n"
                + "- Profil Data Manager et Support doivent être créés\n"
                + "\n"
                + "2. Contraintes\n"
                + "\n"
                + "- Temps d'installation moyen : <" + contrainte + "min\n"
                + "\n"
                + "3. Sauvegarde avant installation\n"
                + "\n"
                + "4. Editer setupBatch" + numBatch + ".ini en se basant sur les commentaires\n"
                + "\n"
                + "5. LANCER UNE CONSOLE CMD EN MODE ADMINISTRATEUR, SE PLACER DANS LE REPERTOIRE CONTENANT LE FICHIER setupBatch" + numBatch + ".bat et lancer setupBatch" + numBatch + ".bat en ligne de commandes (~" + contrainte + " minutes)\n"
                + "  \n"
                + "6. Vérifier qu'il n'y a pas d'erreur dans le log. En cas d'échec, corriger l'erreur et relancer le setupBatch" + numBatch + ".bat";
        }

}
