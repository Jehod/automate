/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import static params.Params.pathLabel;

/**
 *
 * @author nrochas
 */
public class Pays {


    private HashMap<String, String> paysLang = new HashMap<>();
    private List listEnt;
    private ArrayList<String> listExt = new ArrayList<>();
    private Document doc;

    private Pays()
        {

            
        listEnt = Outils.FilesWorker.ListerDirByform(pathLabel, ".._..");
        if (listEnt == null || listEnt.isEmpty())
        {
            initHashmap();
            listEnt = remplirList();
        }
        
        
        }

    private static class PaysHolder {

        private static final Pays INSTANCE = new Pays();
    }

    public static Pays getInstance()
        {
        return PaysHolder.INSTANCE;
        }

 

    private void initHashmap()
        {
        paysLang.put("FR_FR", "Francais france");
        paysLang.put("FR_BE", "Francais belgique");
        paysLang.put("FR_CA", "Francais canada");
        paysLang.put("FR_CH", "Francais suisse");

        paysLang.put("AR_AE", "Arabic (U.A.E.)");
        paysLang.put("AR_BH", "Arabic (bahrain)");
        paysLang.put("AR_DZ", "Arabic (algerie)");
        paysLang.put("AR_EG", "Arabic (egypte)");
        paysLang.put("AR_IQ", "Arabic (iraq)");
        paysLang.put("AR_JO", "Arabic (jordanie)");
        paysLang.put("AR_KW", "Arabic (koweit)");
        paysLang.put("AR_LB", "Arabic (liban)");
        paysLang.put("AR_LY", "Arabic (libye)");
        paysLang.put("AR_MA", "Arabic (maroc)");
        paysLang.put("AR_OM", "Arabic (oman)");
        paysLang.put("AR_QA", "Arabic (qatar)");
        paysLang.put("AR_SA", "Arabic (arabie Saoudie)");
        paysLang.put("AR_TN", "Arabic (tunisie)");
        paysLang.put("AR_YE", "Arabic (yemen)");

        paysLang.put("CS_CZ", "tcheque tchequie");
        paysLang.put("BN_IN", "bengali india");
        paysLang.put("DA_DZ", "Danois danemark");
        paysLang.put("DE_BE", "allemand belgique");
        paysLang.put("DE_CH", "allemand suisse");
        paysLang.put("DE_DE", "allemand allemagne");

        paysLang.put("EL_GR", "grecque grece");

        paysLang.put("EN_AU", "anglais australien");
        paysLang.put("EN_BZ", "anglais belize");
        paysLang.put("EN_CA", "anglais canada");
        paysLang.put("EN_HK", "anglais honkong");
        paysLang.put("EN_IE", "anglais eire");
        paysLang.put("EN_IN", "anglais india");
        paysLang.put("EN_NZ", "anglais neozealand");
        paysLang.put("EN_SG", "anglais singapour");
        paysLang.put("EN_SI", "anglais Sinhalese?");
        paysLang.put("EN_TW", "anglais taiwan");
        paysLang.put("EN_UK", "anglais UK");
        paysLang.put("EN_US", "anglais US");
        paysLang.put("EN_ZA", "anglais afrique sud");

        paysLang.put("ES_AR", "espagnol argentine");
        paysLang.put("ES_CL", "espagnol chili");
        paysLang.put("ES_AR", "espagnol argentine");
        paysLang.put("ES_CO", "espagnol colombie");
        paysLang.put("ES_ES", "espagnol espagnole");
        paysLang.put("ES_MX", "espagnol mexique");
        paysLang.put("ES_PA", "espagnol panama");
        paysLang.put("ES_PE", "espagnol perou");
        paysLang.put("ES_AR", "espagnol US");

        paysLang.put("GU_IN", "gujarati india");
        paysLang.put("HE_IL", "hebrew israel");
        paysLang.put("HI_IN", "hindou india");
        paysLang.put("HU_HU", "hongrois hungary");
        paysLang.put("IT_CH", "italien suisse");
        paysLang.put("IT_IT", "italien italie");
        paysLang.put("JA_JP", "japonnais japan");
        paysLang.put("KN_IN", "kannada india");
        paysLang.put("KO_KR", "Korean korean");
        paysLang.put("ML_IN", "Malayalam india");
        paysLang.put("MR_IN", "Marathi india");
        paysLang.put("MS_SG", "Malaisien singapour");
        paysLang.put("NL_BE", "neerlandais belgique");
        paysLang.put("NL_NL", "neerlandais holland");
        paysLang.put("NO_NO", "norvegien norway");
        paysLang.put("PA_IN", "penjabi india");
        paysLang.put("PL_PL", "polonais pologne");
        paysLang.put("PT_BR", "portugais brazil");
        paysLang.put("PT_PT", "portugais portugal");
        paysLang.put("RU_IL", "russe israel");
        paysLang.put("RU_RU", "russe russia");
        paysLang.put("SV_SE", "suedois swedish");
        paysLang.put("TA_IN", "tamoul india");

        }
/**
 * renvoie la hashmap des codes langues et pays ecrit en literral
 * @return 
 */
    public HashMap<String, String> getPaysLang()
        {
        return paysLang;
        }

    /*
    * rempli la list generique des langues
    */
    private List remplirList()
        {

        for (Iterator it = paysLang.keySet().iterator(); it.hasNext();) {
            String str = (String) it.next();
            listEnt.add(str);

        }
        return listEnt;
        }
/**
 * donne la liste generique des langues
 * @return 
 */
    public List getList()
        {
        return  listEnt;
        }
/**
 * renvoi la liste des langues selectionées
 * @return 
 */
    public ArrayList<String> getListExt()
        {
        return listExt;
        }

    public void setListExt(ArrayList<String> listExt)
        {
        this.listExt = listExt;
        }

   

}
