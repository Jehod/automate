/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outils;

import entity.DocLang;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import params.Params;

/**
 *
 * @author nrochas
 */
public class XmlTools     
{
    
    private static Logger logger = Logger.getLogger(Loggeur.class);

    public XmlTools()
    {

    }

    /**
     * a aprtir d'une adresse de fichier xml, creer le Document dom4J
     *
     * @param file
     * @return
     */
    public static Document convertFileToDoc(String file)
    {
        Document doc = null;

        try
        {
            SAXReader xmlReader = new SAXReader();
            doc = xmlReader.read(file);

        } catch (DocumentException ex)
        {
            System.out.println("+++++++++catch du convertfiletodoc " + ex.getMessage());
            logger.error("+++++++++catch du convertfiletodoc " + ex.getMessage());
            

        } finally
        {

            if (doc != null)
            {
                System.out.println("reussite de la conversion de : " + file);
                logger.info("reussite de la conversion de : " + file);
            }
        }
        return doc;
    }

    /**
     * renvoie une liste des valeurs d'un attribut donné ( 1 niveau sous le
     * root)
     *
     * @param attribut attribut a cibler
     * @return arraylist des valeurs de l'attribut
     */
    public static ArrayList<String> listMappedMethod(Document docu, String attribut)
    {
        ArrayList list = new ArrayList();

        Element root = docu.getRootElement();
        // Element elem = el.  getElement("MapMethod");
        List<Element> liste = root.elements();

        for (Element el : liste)
        {
            if (el.attributeValue(attribut) != null)
            {
                list.add(el.attributeValue(attribut));
            }
        }

        System.out.println("liste de la ref:" + list.toString());
        logger.debug("liste de la ref:" + list.toString());
        return list;

    }

    /**
     * ajout une balise mapmethod avec couple method-form
     *
     * @param doc  document a traiter
     * @param method   attribut method a traiter
     * @param form   attribut form a traiter
     */
    public static void addToParams(Document doc, String method, String form)
    {

        Element el = doc.getRootElement();
        Element elem = el.addElement("MapMethod");
        elem.addAttribute("method", method);
        elem.addAttribute("formulaire", form);
        System.out.println("element is " + elem.toString() + "le fichier est: "+doc.getName());
        logger.debug("element is " + elem.toString() + "le fichier est: "+doc.getName());
        writerFile(doc, doc.getName());
        
        
    }

    /**
     * pour recuperer les langues du fichier doclang.xml OBSOLETE. les langues
     * sont recuperé autrement maintenant 23/11/18
     *
     * @param doc
     * @return
     */
    public static ArrayList<String> docToListLang(Document doc)
    {
        ArrayList<String> list = new ArrayList<>();

        Element root = doc.getRootElement();
        List<Element> li = root.elements();

        for (Element el : li)
        {
            if (el.attributeValue("name") != null)
            {
                list.add(el.attributeValue("name"));
            }
        }

        return list;
    }

    /**
     * recupere dans le label les versions des methodes et creer la list des
     * DocLang pour cette langue le premier appel se note avec REF a la place de
     * la langue dans le construteur de MEthode
     *
     * @param doc
     * @param lang
     * @return
     */
    public static ArrayList docToListDocLang(Document doc, String lang)
    {
        ArrayList<DocLang> list = new ArrayList<>();
        String nodeType = "";
        String regVersion = ".....";
        if (doc != null)
        {
            int j = 0;
            nodeType = doc.node(j).getNodeTypeName();

            while (nodeType.equals("Comment"))
            {
                System.out.println("nodetype:" + nodeType);
                //split 0 donne label, spli 1 donne la methode, split 2 donne le premier iso, split 3 donne le reste
                //attention certain QI sont noté avec un _ d'ou le cas split>4

                if (nodeType.equals("Comment"))
                {

                    String str = doc.node(j).getText();
                    str = str.replace(" Label_", "");
                    str = str.replace(".xlsx ", "£");
                    str = str.replace(".XLSX ", "£");

                    String[] split1 = str.split("£");

                    String version = split1[1];
                    String codeIso = split1[0].substring(split1[0].length() - 5, split1[0].length()).trim();

                    String quest = split1[0].substring(0, split1[0].length() - 6);


                    if (/*version.matches(regVersion) &&*/!quest.equals("PARAM") && !quest.equals("PFT") && codeIso.equals(lang))
                    {
                        list.add(new DocLang(codeIso, quest, version));
                        System.out.println("creation docLang reussi");
                        logger.info("creatin doclang " + codeIso+" q. "+quest+" v. "+version+" reussi");

                    } else if (quest.equals("PARAM") && quest.equals("PFT"))
                    {
                        System.out.println("Pas de creation de PFT ou de PARAM");
                        logger.info("Pas de creation de PFT ou de PARAM");

                    } else
                    {
                        list.add(new DocLang(codeIso, "NoRef", "NoRef"));
                        System.out.println("creation DocLang raté");
                        logger.error("creatin doclang " + codeIso+" q. "+quest+" v. "+version+" raté");
                    }
                }
                j++;
                nodeType = doc.node(j).getNodeTypeName();

            }
        }

        return list;
    }

    /**
     * a partir d'un doc recupere tout les FormDef et les met en liste
     *
     * @param doc
     * @return
     */
    public static ArrayList<String> getFDEF(Document doc)
    {
        ArrayList<String> list = new ArrayList();

        if (doc != null)
        {
            Element root = doc.getRootElement();
            Iterator elementIterator = root.elementIterator("FormsRef");
            while (elementIterator.hasNext())
            {

                Element element = (Element) elementIterator.next();
                Iterator elementIterator2 = element.elementIterator("FormRef");
                while (elementIterator2.hasNext())
                {
                    Element element2 = (Element) elementIterator2.next();
                    System.out.println("trace niv1++" + element2.attributeValue("OID"));
                    logger.debug("trace niv1++" + element2.attributeValue("OID"));
                    list.add(element2.attributeValue("OID"));
                }
            }
        } else
        {
            list.add("doc manquant");
        }

        return list;

    }

    /**change la valeur d'un attribut qui se trouve dans une balise a 1 niveau  sous le root
     * 
     * @param doc  docuement a traiter
     * @param attribut    attribut a rechercher
     * @param newValue     nouvelle valeur a donner a l'attribut
     * @return 
     */
    public static boolean changeValueOnAttribute(Document doc, String attribut, String newValue)
    {
        String value =null;
        if (doc != null)
        {
          Element root = doc.getRootElement();
        // Element elem = el.  getElement("MapMethod");
        List<Element> liste = root.elements();
            
        for (Element el : liste)
        {
            if (el.attributeValue(attribut) != null)
            {
                value = el.attributeValue(attribut);
                
                el.setAttributeValue(attribut, newValue);
            }
        }

        System.out.println("changement de "+attribut+" valeur "+value+" en " + newValue +" dans le Doc "+doc.getName());  
        logger.info("changement de "+attribut+" valeur "+value+" en " + newValue +" dans le Doc "+doc.getName());
        writerFile(doc, doc.getName());

        }

        return (value != null && value != newValue );
    }

    /**
     * En iterant les method dans le fichier de settings, il renvoie le
     * formulaire correspondant
     *
     * @param method method rechercher en string
     * @return formulaire correspondant en string
     */
    public static String searchFormulaireOfMethod(String method)
    {
        String formulaire = "";

        if (Params.docParams != null)
        {

            Element root = Params.docParams.getRootElement();
            Iterator elementIterator = root.elementIterator("MapMethod");

            while (elementIterator.hasNext())
            {

                Element element = (Element) elementIterator.next();

                //System.out.println("trace methodmatch++" + element.attributeValue("method"));
                if (element.attributeValue("method").equals(method))
                {
                    formulaire = element.attributeValue("formulaire");
                }

            }

        } else
        {
            formulaire = "doc manquant";
        }

        return formulaire;

    }

    /**
     * a partir d'une liste de code iso, creer les DocLang de la langue ( un par
     * methode et avec la version) en partant du fichier xml. Puis met en liste
     * toutes les listes des docLang
     *
     * @param listLang liste des codes iso
     * @return liste de liste de doclang
     */
    public static ArrayList<ArrayList<DocLang>> doctoListAllDocLang(ArrayList<String> listLang)
    {
        ArrayList<ArrayList<DocLang>> listDocLang = new ArrayList<>();
        Document doc;
        System.out.println("trace avant la boucler et la size de listlang:" + listLang.size());
        logger.debug("trace avant la boucler et la size de listlang:" + listLang.size());
        for (String lang : listLang)
        {
            doc = convertFileToDoc(Params.pathLabel + "Label_" + lang + ".xml");

            listDocLang.add(docToListDocLang(doc, lang));

        }

        return listDocLang;
    }

    public static void writerFile(Document doc, String file)
    {
        FileWriter out = null;
        try
        {
            out = new FileWriter(file);
            
            doc.write(out);
            out.close();
        } catch (IOException ex)
        {
            System.out.println("+++++++++++catch de writerFile" + ex.getMessage());
            logger.fatal("+++++++++++catch de writerFile" + ex.getMessage());
        } finally
        {
            try
            {
                out.close();
            } catch (IOException ex)
            {
                System.out.println("+++++++++++catch de writerFile close" + ex.getMessage());
                logger.fatal("+++++++++++catch de writerFile close" + ex.getMessage());
            }
        }
    }

    public static void writeXMLIndented(Document doc, OutputStream out, String encoding)
    {
        try
        {
            OutputFormat outformat = OutputFormat.createPrettyPrint();
            outformat.setEncoding(encoding);
            XMLWriter writer = new XMLWriter(System.out, outformat);
            writer.write(doc);
            writer.flush();
        } catch (IOException e)
        {
            System.out.println("++++writeXMLIndented++++" + e.getMessage());
            logger.fatal( "++++writeXMLIndented++++" + e.getMessage());
        }
    }

    /**
     * recupere la value d'un attribut du premiere niveau d'un xml
     *
     * @param docu
     * @param attribut
     * @return
     */
    public static String getValueFromDoc(Document docu, String attribut)
    {
        String value = "notFound";
        Element root = docu.getRootElement();
        // Element elem = el.  getElement("MapMethod");
        List<Element> liste = root.elements();

        for (Element el : liste)
        {
            if (el.attributeValue(attribut) != null)
            {
                value = el.attributeValue(attribut);
            }
        }

        System.out.println("liste de la ref "+attribut+": " + value);
        logger.debug("liste de la ref "+attribut+": " + value);
        return value;

    }
}
