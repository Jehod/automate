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
public class BLSetupBat {

    private String corps;
    private String nomEtude;
    private int firstCenter = 9999;
    private ArrayList<String> listLangues = new ArrayList();
    private String numBatch;
    private ArrayList<String> listCentre = new ArrayList();

    public BLSetupBat(String nomEtude, ArrayList<String> listLangues, String numBatch)
        {
        this.nomEtude = nomEtude;
        this.listLangues = listLangues;
        this.numBatch = numBatch;

        listCentre = initListCenter();
        initCorps();

        }

    private void initCorps()
        {
        corps = "@echo off\n"
                + "\n"
                + "echo Installation starting at %date% %time% >>\"%~n0.log\" 2>&1\n"
                + "rem load config\n"
                + "for /f \"eol=# tokens=1,* delims==\" %%f in ('type \"%~n0.ini\" 2^>NUL') do if \"%%g\" NEQ \"\" call set \"%%f=%%g\"\n"
                + "\n"
                + "rem load instance settings\n"
                + "for /f \"eol=# tokens=1,* delims==\" %%f in ('type \"%FPH_HOME%\\installsettings.ini\" 2^>NUL') do if \"%%g\" NEQ \"\" call set \"%%f=%%g\"\n"
                + "\n"
                + "set \"CLI_HOME=%FPH_HOME%\\administration\\CLI\"\n"
                + "set \"PATH=%CLI_HOME%\\bin\\cfg;%PATH%\"\n"
                + "set \"WD=%CD%\"\n"
                + "\n"
                + "pushd %CLI_HOME%\n"
                + "	\n"
                + callCreateCenter(listCentre)
                + "\n"
                + "echo Loadform %DATE% %TIME% >>\"%WD%\\%~n0.log\" 2>&1\n"
                + "\n"
                + "call configure.bat -study -batch \"%WD%\\batch" + numBatch + ".zip\" 1>>\"%WD%\\%~n0.log\" 2>&1\n"
                + "if errorlevel 1 (echo.Erreur lors de l'import de batch" + numBatch + ".zip)>>\"%WD%\\%~n0.log\" & popd & goto :error\n"
                + "\n"
                + "echo \n"
                + callDeleteCenter(listCentre)
                + "\n"
                + "popd\n"
                + "\n"
                + "set \"INSTALL_DATE=%DATE:~-4%-%DATE:~3,2%-%DATE:~0,2%T%TIME:~0,2%:%TIME:~3,2%:%TIME:~6,2%\"\n"
                + "set \"INSTALL_DATE=%INSTALL_DATE: =0%\"\n"
                + "(echo.Batch " + numBatch + " : installe %INSTALL_DATE%)>>\"%FPH_HOME%\\BatchVersion.txt\"\n"
                + "\n"
                + "(echo Installation ending at %date% %time%)>>\"%WD%\\%~n0.log\"\n"
                + "goto :eof\n"
                + ":error\n"
                + "echo.Il y a eu une erreur le %date% a %time% , Verifier le fichier \"%WD%\\%~n0.log\"";

        }

    public String createFile()
        {
        return corps;
        }

    private String callDeleteCenter(ArrayList<String> listCentre)
        {
        String str = "";

        for (String centre : listCentre)
        {
            str = str + "call bin\\cfg\\cfg.exe -center -delete:\"" + nomEtude + "\":" + centre + "\n";
        }
        System.out.println("le delete  " + str);
        return str;
        }

    private String callCreateCenter(ArrayList<String> listCentre)
        {
        String str = "";
        ArrayList<String> list = listLangues;
        int i = 0;
        System.out.println("la size de la liste de centre" + listCentre.size());

        for (String centre : listCentre)
        {

            str = str + "call bin\\cfg\\cfg.exe -center -add:\"" + nomEtude
                    + "\" -number:" + centre + " -name:" + centre + " -defaultlanguage:" + list.get(i)
                    + " -availablelanguages:" + list.get(i) + " -timezone:GMT -country:" + list.get(i).split("_")[1] + "\n";
            i++;
        }
        System.out.println("le call create " + str);
        return str;
        }

    private ArrayList initListCenter()
        {
        ArrayList<String> list = new ArrayList();
        int a = 0;

        for (String lg : listLangues)
        {

            list.add("" + (firstCenter - a));
            a++;
        }

        return list;
        }

}
