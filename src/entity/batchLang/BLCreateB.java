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
public class BLCreateB {

    String pathLabels = "../Settings/Labels/";

    private String numBatch;
    private ArrayList<String> listLangues = new ArrayList<>();
    private ArrayList<String> listMethodes = new ArrayList<>();
    private String versBatch; // v4.0
    private String nomEtude;

    private String corps;

    public BLCreateB(String numBatch, ArrayList<String> listLangues, ArrayList<String> listMethodes, String versBatch, String nomEtude)
        {
        this.numBatch = numBatch;
        this.listLangues = listLangues;
        this.listMethodes = listMethodes;
        this.versBatch = versBatch;
        this.nomEtude = nomEtude;
        initCorps();
        }

    public String createFile()
        {
        return corps;
        }

    private String callListLang(ArrayList<String> listLangues, boolean reverse)
        {
        String str = "";
        ArrayList<String> list = new ArrayList<>();

        if (reverse)
        {
            for (String lang : listLangues)
            {
                if (testReverse(lang))
                {
                    list.add(lang);
                }

            }
        } else
        {
            for (String lang : listLangues)
            {
                if (!testReverse(lang))
                {
                    list.add(lang);

                }

            }

        }
        str = listToStringAddDrop(list);
        return str;
        }

    private String callListMethode(ArrayList<String> listMethodes)
        {
        String str = "\"" + pathLabels + "Structure.xml\", ";

        for (String meth : listMethodes)
        {
            str = str + "\"" + pathLabels + "$langue/Label_" + meth + "_$langue.xlsx\", ";
        }
        str = str + "\"" +pathLabels + "$langue/Label_PFT_$langue.xlsx\" ";
        return str;
        }

    /**
     * renvoie true si langue inversée
     *
     * @param lang
     * @return
     */
    private boolean testReverse(String lang)
        {
        boolean bob;
        String[] lg;

        lg = lang.split("_");

        if (lg[0].equals("AR") || lg[0].equals("HE"))
        {
            bob = true;
        } else
        {
            bob = false;
        }

        return bob;

        }

    /**
     * ajoute des guillement à chaque iteration de la list et les concatenent en
     * 1 string
     *
     * @param list
     * @return
     */
    private String listToStringAddDrop(ArrayList<String> list)
        {
        String str = "";
        for (String lang : list)
        {
            if (list.get(list.size()-1).equals(lang))
            {
                str = str + "\"" + lang + "\"";
            } else
            {
                str = str + "\"" + lang + "\",";
            }
        }

        return str;
        }

    private void initCorps()
        {
        corps = "$env:Path = \"C:\\bin;$env:Path\"\n"
                + "\n"
                + "if (Test-Path \"$pwd\\Batch" + numBatch + "\") {  Remove-Item -recurse -Path \"$pwd\\Batch" + numBatch + "\" -Force }\n"
                + "New-Item \"$pwd\\Batch" + numBatch + "\\Batch" + numBatch + "\" -type directory\n"
                + "\n"
                + "\n"
                + "# Génération du fichier label pour les langues\n"
                + "$langues = @(" + callListLang(listLangues, false) + ")\n"
                + "$reverseLangues = @(" + callListLang(listLangues, true) + ")\n"
                + "\n"
                + "$langues | foreach {\n"
                + "    $langue = $_\n"
                + "\n"
                + "  $filesToProcess = @(" + callListMethode(listMethodes) + ") \n"
                + "\n"
                + "    ($filesToProcess | ?{ (Test-Path $_) -eq 0 }) | foreach{ Write-verbose \"Attention! $_ n existe pas\" -verbose }\n"
                + "    Invoke-Expression \"LabelBuilder.exe $(($filesToProcess | ?{ Test-Path $_ }) -join \" \")\"\n"
                + "\n"
                + "    Move-Item \"Labels.xml\" \"$pwd\\Batch" + numBatch + "\\Batch" + numBatch + "\\Labels_$langue.xml\" -force\n"
                + "}\n"
                + "\n"
                + "\n"
                + "Copy-Item -Path \"..\\Settings\\StudyLoaders\\Batch" + numBatch + ".xml\" \"Batch" + numBatch + "\\Batch" + numBatch + "\\\"\n"
                + "\n"
                + "# Construit un zip de study loader\n"
                + "Compress-Archive -Path \"$pwd\\Batch" + numBatch + "\\Batch" + numBatch + "\\*\" -DestinationPath \"$pwd\\Batch" + numBatch + "\\Batch" + numBatch + ".zip\"\n"
                + "Remove-Item -recurse \"$pwd\\Batch" + numBatch + "\\Batch" + numBatch + "\"\n"
                + "\n"
                + "\n"
                + "Copy-Item -Path \"$pwd\\setupBatch" + numBatch + ".bat\" \"$pwd\\Batch" + numBatch + "\\\"\n"
                + "Copy-Item -Path \"$pwd\\setupBatch" + numBatch + ".ini\" \"$pwd\\Batch" + numBatch + "\\\"\n"
                + "Copy-Item -Path \"$pwd\\installBatch" + numBatch + ".txt\" \"$pwd\\Batch" + numBatch + "\\Install.txt\"\n"
                + "\n"
                + "# creation du package a livrer\n"
                + "$CreationDate = Get-Date -format yyyyMMdd\n"
                + "if (Test-Path \"$pwd\\" + nomEtude + "-$CreationDate-" + versBatch + ".zip\") { Remove-Item -Path \"$pwd\\" + nomEtude + "-$CreationDate-" + versBatch + ".zip\" }\n"
                + "Compress-Archive -Path \"$pwd\\Batch" + numBatch + "\\*\" -DestinationPath \"$pwd\\" + nomEtude + "-$CreationDate-" + versBatch + ".zip\" -Force\n"
                + "\n"
                + "Remove-Item -recurse \"$pwd\\Batch" + numBatch + "\"";
        }

}
