# legacy

## Krav
Programet ska
  - Validera fälten
  - Filtrera ut minderåriga

## CSV Filen
Filen har fyra kolumner med data. Förnamn, efternamn, personnummer och epost

    firstname;lastname;personal_number;email
    Vaughan;Stafford;16290828-0361;Nunc@ipsum.net
    
    
## Programet

    java -jar legacy.jar <fil-sökväg> <århundrade>
    
    java -jar legacy.jar /tmp/fil 1600
    