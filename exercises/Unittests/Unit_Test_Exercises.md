# Unit Tests
## Aufgabe 1: Was wird wie in unserer Firma getestet?
### Testlevels die wir schon verwendet haben
- In der Produktion bei unserer Firma haben wir bisher nur Unit Tests programmiert.
- Bei üKs haben wir auch End-To-End Tests verwendet

### Wann werden Tests ausgeführt?
Man kann Test zu verschiedenen Zeitpunkten ausführen
- Unit Tests werden z.B. vor dem Entwickeln des eigentlichen Codes geschrieben und während dem Programmieren des Codes ausgeführt (Test-Driven-Development)
- End-To-End Tests werden z.B. nach dem Entwickeln des Codes ausgeführt, um zu überprüfen dass alle Funktionalitäten erfüllt werden
- Bei jeder Änderung des Codes (z.B. Refactoring) werden Tests (vor allem Unit Tests) erneut ausgeführt, um zu überprüfen, dass sich bei der Änderung keine Fehler eingeschlichen haben.

### Haben wir dedizierte Testing oder QA Teams?
- In unserer Firma gibt es verschiedene Abteilungen und da ist es unterschiedlich ob und wie Testing und QA Teams aufgebaut sind
- Grundsätzlich gibt es jedoch QA und Testing Teams 

### Testing Live Cycle
- Über diesen Punkt dürfen wir leider keine Auskunft geben

## Aufgabe 2
- Der Testing Approach ist die allgemeine Strategie und Methodik, die für Tests festgelegt wird.
- Testing Levels sind verschiedene Stufen, auf denen Tests durchgeführt werden, wie Unit Testing, Integration Testing, usw.
- Testing Types sind spezifische Testkategorien wie Functional Testing oder Security Testing.
- Testing Techniques sind Methoden, um Tests durchzuführen, wie Black Box Testing.
- Testing Tactics sind konkrete Schritte während der Testdurchführung.

Diese Begriffe sind miteinander verbunden: Der gewählte Testing Approach beeinflusst die Auswahl der Testing Levels und Types, während Techniques und Tactics auf der Ebene der Testing Types angewendet werden, um Tests durchzuführen. Zusammen stellen sie sicher, dass Software qualitativ hochwertig und den Anforderungen entspricht.

## Gradle Projekt im cmd laufen lassen
./gradlew test