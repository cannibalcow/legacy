#language: sv
@legacy

Egenskap: Applikationen laddar in en fil

  Scenario: Laddar in data som är ok och avslutar med rätt rader
    Givet att i filen 'fil1' finns följande rader
      | fornamn | efternamn | personnummer  | epost              |
      | Daniel  | Heldt     | 16100930-1234 | daniel@email.com   |
      | John    | Doe       | 16500930-1234 | john.doe@email.com |
    När legacy kör med fil 'fil1' få vi resultatet
      | fornamn | efternamn | personnummer  | epost            |
      | Daniel  | Heldt     | 16100930-1234 | daniel@email.com |
