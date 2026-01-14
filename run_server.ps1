$hytaleHome = "$env:APPDATA\Hytale\install"
$patchline = "release"
$gameBuild = "latest"

$serverJar = "$hytaleHome\$patchline\package\game\$gameBuild\Server\HytaleServer.jar"
$assetsZip = "$hytaleHome\$patchline\package\game\$gameBuild\Assets.zip"
if (-not $env:JAVA_HOME) {
    Write-Host "JAVA_HOME is not set. Using default path: C:\Program Files\Java\jdk-25"
    $env:JAVA_HOME = "C:\Program Files\Java\jdk-25"
}

$java = "$env:JAVA_HOME\bin\java.exe"

if (-not (Test-Path $java)) {
    Write-Error "Java 25 not found at $java"
    exit 1
}

$modPath = "$PSScriptRoot\src"

Write-Host "Starting Hytale Server with mod from: $modPath"
& $java -jar $serverJar --allow-op --disable-sentry --assets=$assetsZip --mods=$modPath
