@echo off

echo Installation starting at %date% %time% >>"%~n0.log" 2>&1
rem load config
for /f "eol=# tokens=1,* delims==" %%f in ('type "%~n0.ini" 2^>NUL') do if "%%g" NEQ "" call set "%%f=%%g"

rem load instance settings
for /f "eol=# tokens=1,* delims==" %%f in ('type "%FPH_HOME%\installsettings.ini" 2^>NUL') do if "%%g" NEQ "" call set "%%f=%%g"

set "CLI_HOME=%FPH_HOME%\administration\CLI"
set "PATH=%CLI_HOME%\bin\cfg;%PATH%"
set "WD=%CD%"

pushd %CLI_HOME%
	
call bin\cfg\cfg.exe -center -add:"CZPLtest" -number:9999 -name:9999 -defaultlanguage:AU_AU -availablelanguages:AU_AU -timezone:GMT -country:AU

echo Loadform %DATE% %TIME% >>"%WD%\%~n0.log" 2>&1

call configure.bat -study -batch "%WD%\batch9.zip" 1>>"%WD%\%~n0.log" 2>&1
if errorlevel 1 (echo.Erreur lors de l'import de batch9.zip)>>"%WD%\%~n0.log" & popd & goto :error

echo 
call bin\cfg\cfg.exe -center -delete:"CZPLtest":9999

popd

set "INSTALL_DATE=%DATE:~-4%-%DATE:~3,2%-%DATE:~0,2%T%TIME:~0,2%:%TIME:~3,2%:%TIME:~6,2%"
set "INSTALL_DATE=%INSTALL_DATE: =0%"
(echo.Batch 9 : installe %INSTALL_DATE%)>>"%FPH_HOME%\BatchVersion.txt"

(echo Installation ending at %date% %time%)>>"%WD%\%~n0.log"
goto :eof
:error
echo.Il y a eu une erreur le %date% a %time% , Verifier le fichier "%WD%\%~n0.log"