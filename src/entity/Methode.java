/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Outils.XmlTools;
import java.util.ArrayList;
import org.dom4j.Document;
import static params.Params.docRef;

/**
 *
 * @author nrochas
 */
public class Methode
{

    private ArrayList<String> listM = new ArrayList<>(); //liste des QI en nom court
    private ArrayList<String> listMExt = new ArrayList<>(); // liste des QI selectionné en FDEF
    private Document doc = docRef; // doc source pour avoir les FDEF et les versions
    private ArrayList<String> listFDEF = new ArrayList<>(); // list des FDEF

    private Methode()
    {
        if (doc == null)
        {
            initListERROR(listM);
        } else
        {
            listFDEF = XmlTools.getFDEF(doc);
            //listM = MethodsFromDocLang(listDocLang);
        }

    }

    public static Methode getInstance()
    {
        return MethodeHolder.INSTANCE;
    }

    private static class MethodeHolder
    {

        private static final Methode INSTANCE = new Methode();
    }

    /**
     * initie la liste en mode erreur
     *
     * @return
     */
    private void initListERROR(ArrayList<String> list)
    {
        list.add("ERROR");
    }

    /**
     * list des QI ecrit courts
     *
     * @return
     */
    public ArrayList<String> getListM()
    {
        return listM;
    }

    public void setListM(ArrayList<String> listM)
    {
        this.listM = listM;
    }

    
    /**
     * donne la liste des FDEF selectionnés
     *
     * @return
     */
    public ArrayList<String> getListMExt()
    {
        return listMExt;
    }

    public void setListMExt(ArrayList<String> listMExt)
    {
        this.listMExt = listMExt;
    }

    /**
     * renvoie la liste de tout les FormDEF
     *
     * @return
     */
    public ArrayList<String> getListFDEF()
    {
        return listFDEF;
    }

    public void setListFDEF(ArrayList<String> listFDEF)
    {
        this.listFDEF = listFDEF;
    }

   
}
