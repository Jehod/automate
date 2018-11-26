$env:Path = "C:\bin;$env:Path"

if (Test-Path "$pwd\Batch9") {  Remove-Item -recurse -Path "$pwd\Batch9" -Force }
New-Item "$pwd\Batch9\Batch9" -type directory


# Génération du fichier label pour les langues
$langues = @("AU_AU")
$reverseLangues = @()

$langues | foreach {
    $langue = $_

  $filesToProcess = @("../Settings/Labels/Structure.xml", "../Settings/Labels/$langue/Label_FACTQI_$langue.xlsx", "../Settings/Labels/$langue/Label_PFT_$langue.xlsx" ) 

    ($filesToProcess | ?{ (Test-Path $_) -eq 0 }) | foreach{ Write-verbose "Attention! $_ n existe pas" -verbose }
    Invoke-Expression "LabelBuilder.exe $(($filesToProcess | ?{ Test-Path $_ }) -join " ")"

    Move-Item "Labels.xml" "$pwd\Batch9\Batch9\Labels_$langue.xml" -force
}


Copy-Item -Path "..\Settings\StudyLoaders\Batch9.xml" "Batch9\Batch9\"

# Construit un zip de study loader
Compress-Archive -Path "$pwd\Batch9\Batch9\*" -DestinationPath "$pwd\Batch9\Batch9.zip"
Remove-Item -recurse "$pwd\Batch9\Batch9"


Copy-Item -Path "$pwd\setupBatch9.bat" "$pwd\Batch9\"
Copy-Item -Path "$pwd\setupBatch9.ini" "$pwd\Batch9\"
Copy-Item -Path "$pwd\installBatch9.txt" "$pwd\Batch9\Install.txt"

# creation du package a livrer
$CreationDate = Get-Date -format yyyyMMdd
if (Test-Path "$pwd\CZPLtest-$CreationDate-v9.0.zip") { Remove-Item -Path "$pwd\CZPLtest-$CreationDate-v9.0.zip" }
Compress-Archive -Path "$pwd\Batch9\*" -DestinationPath "$pwd\CZPLtest-$CreationDate-v9.0.zip" -Force

Remove-Item -recurse "$pwd\Batch9"