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
Som utvecklare vill jag uppnå ett par saker

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
När det kommer till kodgranskning så finns det det en mjukvara som heter
Sonarqube (https://www.sonarqube.org/). Den analyserar kodbasen mot
ett flertal regler. Dessa regler tittar efter buggar, bestpractice och andra typer
av mätvärden som kan finnas i kod. T.ex komplexitet i metoder och klasser.
Sonarqube sätter en stämpel på kodkvaliteten och visar hur kvalitéten utvecklas.

# 3. Systemtester
När du ska angripa ett legacysystem så rekomenderar jag inte att börja skriva
enhetstester för alla klasser. Det är ett lönlöst arbete som bara tar tid och kan visa
sig skapa mer problem. Eftersom testerna inte är skrivna på en gång så vet du
inte vad kraven för koden är. Att skriva testerna i efterhand ger då inget.

Det som du kan göra är att sätta upp systemtester som beskrivre scenarion
där du vet utfallet. Du vet t.ex att om du mattar in en fil av en viss typ
så kommer det ut ett förväntat resultat.

Dessa tester är väldigt bra att ha när du refaktoriserar koden och börjar
röra om i grytan. Ett litet kvitto som säger att grejerna håller ihop och
beter sig som tidigare.

# 4. Byggplan
Legacykod brukar sällan ha någon sort automation kopplad till sig
i form av en byggplan. Sätt upp en sådan miljö som gör det följande:

- Kör alla enhetstester
- Kör alla integrationstester
- Kör alla systemtester
- Bygger en version av din mjukvara
- Möjlighet att deploya mjukvaran till olika miljöer så som
test, ver, prod osv

Finns detta på plats så underlättas vardagen betydligt. Feedback-loopen
för att din utveckling blir väldigt kort och genom att trycka på
en knapp så installeras mjukvaran i respektive miljö.

# 5. Refaktorering
När vi tittar på koden ser vi ett tydligt mönster. Koden läser  en fil,
kör ett gäng if-satser på den och sedan sparar undan rader.

Alla dessa if-satser är ju i stort sett regler på formatet i filen.
Slutsatsen blir då att bygga en regelmotor som kan tillämpas på datat.

## 5.0 Email
En regel för validering av email. Finns i tag 5.0

## 5.1 Personnummer
En regel för validering av personnummer.

## 5.2 Werido
En regel för den knepiga regeln som ingen kommer ihåg varför den existerar.

# 6. Sy ihop den nya refaktoreringen
Tagen "chapter6" syr ihop de nya reglerna

# 7. Loggning
Ta bort all eländig System.out från mjukvara. System.out kan inte konfigureras
och styras till filer på ett bra sätt. Byt ut till ett riktigt log ramverk
och få en strukturerad och fin loggning av applikationen.
