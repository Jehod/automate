/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automate;

import Outils.ToolsString;
import entity.batchLang.BLCreateB;
import entity.batchLang.BLInstall;
import entity.batchLang.BLSetupBat;
import entity.batchLang.BLSetupIni;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nrochas
 */
public class EcrivainBatchLang {
    
    
    
    public boolean editFiles(String file, File cible)
        {
        boolean bob = false;

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(cible));
            // normalement si le fichier n'existe pas, il est crée à la racine du projet
            writer.write(file);
            bob = true;
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ToolsString.class.getName()).log(Level.SEVERE, null, ex);
            bob = false;
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ToolsString.class.getName()).log(Level.SEVERE, null, ex);
                bob = false;
            }
        }
        return bob;
        }

    public boolean editBatch(String nomEtude, String numBatch, String versBatch, 
            String versClinf, String versEpro, String numMantis, ArrayList<String> listLangues, 
            ArrayList<String> listMethodes, String numTomCat  )
        {
            BLCreateB bLcr = new BLCreateB(numBatch, listLangues, listMethodes, versBatch, nomEtude);
            BLInstall bLin = new BLInstall(numMantis, numBatch, listLangues, versClinf, versEpro);
            BLSetupBat bLstp = new BLSetupBat(nomEtude, listLangues, numBatch);
            BLSetupIni bLIni = new BLSetupIni(nomEtude, numTomCat);
            
            editFiles( bLcr.createFile(),new File("createBatch"+numBatch+".ps1"));
            editFiles(bLin.createFile(),new File("installBatch"+numBatch+".txt"));
            editFiles(bLstp.createFile(), new File("setupBatch"+numBatch+".bat"));
            editFiles(bLIni.createFile(), new File("setupBatch"+numBatch+".ini"));
            
            return true;
        }
}
