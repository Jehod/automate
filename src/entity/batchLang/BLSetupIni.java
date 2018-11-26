/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.batchLang;

/**
 *
 * @author nrochas
 */
public class BLSetupIni {

    private String corps;
    private String nomEtude;
    private String numTomcat; //T7xI07

    public BLSetupIni(String nomEtude, String numTomcat)
        {
        this.nomEtude = nomEtude;
        this.numTomcat = numTomcat;
        initCorps();
        }

    private void initCorps()
        {
        corps = "# Repertoire racine de ClinForm, exemple : D:\\FAS\\NovartisF2308\n"
                + "FPH_HOME=D:\\Platforms\\DEV\\" + nomEtude + "\n"
                + "# Nom du service tomcat, exemple : KAYxT7xI07\n"
                + "TOMCAT_SERVICE=KAYx" + numTomcat + "\n"
                + "# Delai d'attente avant redemarrage du tomcat (secondes)\n"
                + "TOMCAT_DELAY=30\n"
                + "REPLAY_MAX_RETRY=3";
        }

    public String createFile()
        {
        return corps;
        }
}
