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
