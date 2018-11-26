/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Outils.XmlTools;
import entity.DocLang;
import java.util.ArrayList;
import org.dom4j.Document;
import static params.Params.pathLabel;

/**
 *
 * @author nik
 */
public class DocLangManager
{
     private ArrayList<DocLang> listDocLang = new ArrayList<>(); // list des doclang autant que les langues fois les methodes ( courtes)
     
       /**
     * ouvre le xml de la langue et creer les DocLang liés 1 doclang par method
     * de la langue
     * OBSOLETE 25/11
     *
     * @param langue
     * @return
     */
    public ArrayList fillListDocLang(String langue)
        {
        ArrayList<DocLang> list = new ArrayList<>();

        String path = pathLabel + "Label_" + langue + ".xml";
        Document docu;

        docu = XmlTools.convertFileToDoc(path);

        if (docu != null) {
            list.addAll(Outils.XmlTools.docToListDocLang(docu, langue));
        }

        listDocLang.addAll(list);

        return listDocLang;
        }
    
}
