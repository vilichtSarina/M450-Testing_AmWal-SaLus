# Unit Test Research
## Test Levels
- Unit/Component Testing (kurze Ausführzeit, wird am Anfang der Entwicklungsfrage definiert)
- Integration Testing
- System Testing
- Acceptance Testing 

## White Box vs Black Box Testing
- White Box: Einblick in den Quellcode ist gestattet d.h. es wird am Code geprüft
- Black Box: Tests werden anhand von Spezifikationen oder Anforderungen entwickelt. Tests werden also ohne kenntnis über die Implementierung getestet

## Unit Testing
- Gehören zum ersten Level von Testing
- Wird von den Entwicklern geschrieben und ausgeführt (später automatisiert beim build)
- White-Box-Test
- Komponenten werden einzeln in Isolation getestet (in Java Klassen oder Methoden)
- Fehler werden früh entdeckt
- Gibt den Entwickler die Sicherheit für Code Refactorings
- Hauptsächlich Funktionale Anforderungen werden hier getestet
- Limitation: Nur weil Komponenten in Isolation korrekt funktionieren, heisst es nicht, dass Komponenten zwischen
einander Korrekt funktionieren

## Weitere Testing Arten
https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/blob/main/Unterlagen/test-levels/README.md 
