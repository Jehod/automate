/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nik
 */
public class FilesWorker
{

    /**
     * list des fichiers par le debut du nom  avec un filtre
     * endsWith
     *
     * @param path path vers le dossier a lister
     * @param filtre string se trouvant en debut des fichiers a lister
     * @return 
     * @renvoie un string[] contenant les noms des fichiers
     */
    public static List ListerFilesByStart(String path, String filtre)
    {
        File f = new File(path);
        List list;// = new ArrayList();

        FilenameFilter filter = (File dir, String name) -> (name.startsWith(filtre));
        
        System.out.println("Fichiers commencant par: " + filtre);
        String[] noms = f.list(filter);
        list = Arrays.asList(noms);
        return list;
    }
    
    /**
     * list des fichiers par la fin du nom ou par l'extention avec un filtre
     * endsWith
     *
     * @param path path vers le dossier a lister
     * @param filtre string se trouvant en fin des fichiers a lister
     * @return 
     * @renvoie un string[] contenant les noms des fichiers
     */
    public static List ListerFilesByExt(String path, String filtre)
    {
        File f = new File(path);
        List list;// = new ArrayList();

        FilenameFilter filter = (File dir, String name) -> (name.endsWith(filtre));
        
        System.out.println("Fichiers finissant par: " + filtre);
        String[] noms = f.list(filter);
        list = Arrays.asList(noms);
        return list;
    }

    /**
     * list les dossiers ou fichier suivant un matcher
     *
     * @param path path vers le dossier a lister
     * @param form regex pour le match
     * @return 
     * @renvoie un string[] contenant les noms des fichiers
     */
    public static List ListerDirByform(String path, String form)
    {
        File f = new File(path);
        List list = new ArrayList();

        FilenameFilter filter = (File dir, String name) -> (name.matches(form));
        System.out.println("dossiers de forme:" + form);
        String[] noms = f.list(filter);
        list = Arrays.asList(noms);
       
        AfficheList( list,true);
        return list;
    }

    /**
     * renvoie une string du tableau concatener en une colonne
     *
     * @param list la liste a stringer
     * @return renvoie une string
     * @param bob mettre bob a true permet d'afficher la list dans la console
     * (parametre optionnel)
     *
     */
    public static String AfficheList(List list, boolean bob)
    {
        String str = "";

        for (int i = 0; list != null && i < list.size(); i++)
        {
            str = str +" "+  list.get(i);
            
        }

        if (bob)
        {
            System.out.println(str);
        }

        return str;
    }

    /**
     * renvoie une string du tableau concatener en une colonne
     *
     * @param list la liste a stringer
     * @return renvoie une string
     */
    public static String AfficheList(List list)
    {
        String str = "";

        for (int i = 0; list != null && i < list.size(); i++)
        {
            str = str + " " + list.get(i);
        }

        return str;
    }

     public static boolean editFiles(String file, File cible)
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
}
