/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package params;

import Outils.XmlTools;
import java.io.File;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 *
 * @author nik
 */
public class Params
{

    private final String pathParams = "automate_settings.xml";
    
    public static String pathXmlLabel;
    public static String pathLabel;
    public static String langRef;
    public static Document docRef;
    //public static HashMap matchMethod;
    public static Document docParams;

    private Params()
    {
        docParams = XmlTools.convertFileToDoc(pathParams);
        if (docParams == null)
        {
            createDocParams();
        }
        pathLabel = XmlTools.getValueFromDoc(docParams, "pathLabel");
        pathXmlLabel = XmlTools.getValueFromDoc(docParams, "pathXml");
        langRef = XmlTools.getValueFromDoc(docParams, "langRef");
        docRef = XmlTools.convertFileToDoc(pathLabel + "Label_" + langRef + ".xml");
        XmlTools.changeValueOnAttribute(docParams, "langRef", "EN_UK");

        //matchMethod = XmlTools.docToMapMethod(docParams);
    }

    public static Params getInstance()
    {
        return ParamsHolder.INSTANCE;
    }

    public static String getLangRef()
    {
        return langRef;
    }

    public static void setLangRef(String langRef)
    {
        Params.langRef = langRef;
    }

    private void createDocParams()
    {
        String init = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<params>\n"
                + "	<langRef langRef=\"EN_US\" />\n"
                + "	<pathLabel pathLabel=\"Label/\"/>\n"
                + "	<pathXml pathXml=\"\"/>\n"
                + "	<MapMethod method=\"noMethod\" formulaire=\"noForm\"/>\n"
                + "\n"
                + "</params>";

        if (Outils.FilesWorker.editFiles(init, new File("automate_settings.xml")))
        {
            docParams = XmlTools.convertFileToDoc(pathParams);
        }else{System.out.println("un probleme mec");};

    }

    private static class ParamsHolder
    {

        private static final Params INSTANCE = new Params();
    }

    public static Document getDocParams()
    {
        return docParams;
    }

    public static void setDocParams(Document docParams)
    {
        Params.docParams = docParams;
    }

    public static String getPathLabel()
    {
        return pathLabel;
    }

    public static void setPathLabel(String pathLabel)
    {
        Params.pathLabel = pathLabel;
    }

    public static Document getDocRef()
    {
        return docRef;
    }

    public static void setDocRef(Document docRef)
    {
        Params.docRef = docRef;
    }

}
