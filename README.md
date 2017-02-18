# legacy

## Krav
Programet ska
  - Validera fälten
    - Korrekt email
    - Korrekt personnummer
    - Efternamn får vara null om förnamn börjar på 'A', 'B', 'F'
  - Filtrera ut minderåriga från 1600 talet
  - Skriv ut resultatet 

## CSV Filen
Filen har fyra kolumner med data. Förnamn, efternamn, personnummer och epost

     
    Vaughan;Stafford;16290828-0361;Nunc@ipsum.net
    
## Programet

    java -jar legacy.jar <fil-sökväg>
    
    java -jar legacy.jar /tmp/fil
    

## Verktyg
### Sonarqube
 - https://sonarsource.bintray.com/
 - https://sonarsource.bintray.com/Distribution/sonarqube/sonarqube-6.2.zip

# 1. Överblick
Läs igenom koden och få lite kännedom om vad koden ska göra och hur den gör det.
Läs inte all kod. Det är bara sjukt drygt och jobbigt. Det räcker med att orientera
sig i böjan.

Notera eventuella mönster och brister. Se dig om i koden ungefär på samma sätt
som du skulle göra vid köp av en sommarstuga. "Hmm.. byter jag till jordat uttag i
köket så slipper jag få en dödlig stöt." fast i koden kanske du tänker
"Om jag fångar de där exceptionet och loggar det så slipper produktionslinan stå still
så länge." osv.

   - Vad är programmets syfte
   - Ser du några mönster
   - Tydliga delar som kan brytas isär.
   - T.ex läsa in fil, validera data, skriva ut data

# 2. Överblickverktyg
Som utvecklare vill jag se ett par saker

Jag vill ...
- se vart jag har brister i min kod
- se vad som är testat
- ha ett kvitto på att koden får högre kvalité och blir bättre
vid varje förändring.
- att vid varje bygge av min kod att ovanstående analyser görs

## Testtäckning
Det finns många olika verktyg för att mäta testtäckningen i ett projekt.
Men jag kommer att rekomendera JaCoCo (Java Code Coverage, http://www.eclemma.org/jacoco/)
Verktyget analyserar all kod i projektet och skapar en rapport som visar
hur många % av koden som är testad.

## Kodgranskning
Sonarqube (https://www.sonarqube.org/)