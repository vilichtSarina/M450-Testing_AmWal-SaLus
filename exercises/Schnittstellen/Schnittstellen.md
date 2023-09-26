# Theorie

## Lernziele und dazugehörige Erklärungen

1. Ich kenne Test Doubles
2. Ich weiss wo Test Doubles zum Einsatz kommen
3. Ich kenne ein Test Framework welches Test Doubles verwendet

_Test Doubles_ sind für die Testumgebung simulierte Abhängigkeiten um Componenttesting zu ermöglichen. Hierbei gibt es verschiedene Arten von Doubles: Fakes, Stubs, Dummys, Spys und Mocks.
Diese kann man Grundsätzlich in zwei Überkategorien einteilen:

- Mocks (Behavioral Testing)
  - Mock, Spy
- Stub (State Testing)
  - stub, dummy, fake

# Übungen

## Übung 1

### Aufgabestellung

- Schreiben Sie Tests für alle Klassen, ohne eine echte MySQL Datenbank benutzen zu müssen
- Schauen Sie, dass Sie auch zusätzliche Annotationen wie @BeforeEach benutzen
- Fangen Sie an mit dem Testen von Addressen, welche Sie erstellen
- Versuchen Sie den Service zu testen indem Sie AddressDAO mit @mock Annotieren
- Testen Sie ob die Comparator Klasse korrekt sortiert

## Übung 2

- Testen Sie den Service zusätzlich mit einer eigenen Mockup Implementation welche AddressDAO implementiert

## Übung 3

- Erweitern Sie die Comparator Klasse, so dass nach zusätzlichen Attributen verglichen werden kann
- Testen Sie entsprechend die neue Funktionalität
