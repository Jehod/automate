/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automate;

import Outils.ToolsString;
import Outils.XmlTools;
import entity.DocLang;
import entity.Formulaire;
import entity.Methode;
import entity.Pays;
import java.util.ArrayList;
import org.dom4j.Document;
import params.Params;
import static params.Params.langRef;
import view.FenManualSelect;

/**
 *
 * @author nik
 */
public class MethodMatcher
{

    private ArrayList<String> listLang = new ArrayList<>();
    private ArrayList<DocLang> listDocLangRef = new ArrayList<>();
    private ArrayList<String> listForm = new ArrayList<>();
    private ArrayList<String> listMethod = new ArrayList<>();
    private ArrayList<ArrayList<DocLang>> listAllDocLang = new ArrayList<>(); // list des doclang autant que les langues fois les methodes 
    private Document doc = Params.docRef;

    //private HashMap<String, String> hmMethFDEF = new HashMap(); //table de conversion des  Formdef en formulaire 
    public MethodMatcher()
    {
        listForm = Formulaire.getInstance().getListFormulaire();
        listMethod = Methode.getInstance().getListFDEF();
        listDocLangRef = Outils.XmlTools.docToListDocLang(doc, langRef);

    }

    /**
     * les doclang pour prendre celui qui a la langue et la methode
     * correspondante le fdef est passé dans la hashmap pour trouver la methode
     * courte
     *
     * @param langue
     * @param fDEF
     * @return
     */
    public String GetVersionFromDoclang(String langue, String fDEF)
    {
        listLang = Pays.getInstance().getListExt();
        listAllDocLang = Outils.XmlTools.doctoListAllDocLang(listLang);
        String method = fDEF;// = hmMethFDEF.get(fDEF); //transcription grace a la hashtable
        String version = "0.0.0";
        System.out.println("getversion? " + listAllDocLang.size() + " size?");

        for (ArrayList<DocLang> listDocLang : listAllDocLang)
        {

            for (DocLang dl : listDocLang)
            {
                System.out.println("listDocLang size: " + listDocLang.size() + " langue: " + langue);

                if (dl.getLang().equals(langue) && dl.getMethod().equals(method))
                {
                    version = dl.getVersion();
                }

                System.out.println("dl.getmethode " + dl.getMethod() + " fedef " + method + " dl.getLang " + dl.getLang());

            }
        }
        return version;
    }

    public String matchMethodNform(String method)
    {
        String formulaire = "";

        if (method != null && !method.isEmpty())
        {
            formulaire = Outils.XmlTools.searchFormulaireOfMethod(method);
            if (formulaire.equals(""))
            {
                formulaire = "notFound";
            }
        }
        return formulaire;
    }

    /**
     * mapping manuel des methodes et de form
     */
    public void mapMethodMatcher()
    {
        ArrayList li = XmlTools.listMappedMethod("method");
        for (String method : listMethod)
        {
            if (!ToolsString.searchInList(li, method))
            {
                for (String form : listForm)
                {
                    if (method.contains(form))
                    {
                        XmlTools.addToParams(method, form);
                    } else
                    {
                        
                       /* FenManualSelect fms = new FenManualSelect(listForm, method);
                        fms.setLocation(500, 200);
                        fms.setSize(1000, 400);
                        fms.setVisible(true);*/
                    }
                }
            }
        }
    }

}
