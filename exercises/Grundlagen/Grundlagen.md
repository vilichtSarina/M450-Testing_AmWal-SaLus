# Grundlagen Testing
## Aufgabe 1
**Formen von Testing**
Manuelle und automatische Tests:
- Manuelle Tests werden von Menschen durchgeführt, d.h. dass sich z.B. jemand durch die Applikation durch klickt.
- Automatische Tests werden vom Computer durchgeführt, d.h. dass man z.B. einen Test schreibt, der einen Teil des Codes testet und dieser Test dann automatisch vom Computer durchgeführt wird.

Black- und Whitebox Testing:
- Whitebox Testing: Beim Whitebox Testing kennt der Tester den Code und testet viel gezielter, z.B. beim Unit-Test eine einzelne Methode.
- Blackbox Testing: Bei dieser Variante des Testings kennt der Tester den Code nicht, ein Beispiel dafür sindé End to End Tests

Arten von Tests:
- Unit-Tests: Unit-Tests sind automatische Tests, die verwendet werden, um einen bestimmten Teil, z.B. eine Methode, des Codes zu testen.
- Komponent Tests: Komponent Tests werden verwendet, um testen, ob verschiedene Methoden, die eine Komponente ergeben zusammen funktionieren.
- Integration Tests: Bei diesem Test geht es darum herauszufinden, ob verschiedene Komponenten eines Codes miteinander funktionieren. 
- End to End Tests: Bei diesem Test wird der ganze Code getestet, also bestimmte Funktionalitäten des Codes, werden komplett durchgespielt und getestet.
- 
**Beispiele:**
- Unit-Tests: Wir arbeiten häufig mit Unit Tests. Dabei schreiben wir eine Methode für unseren Code und testen, dann anschliessend direkt, ob diese Methode das gewünschte Ergebnis bringt. Dabei arbeiten wir mit sogenannten Mocks, damit wir die Testdaten gezielt verändern können und nur die getestete Methode einen Einfluss auf unseren Test hat, diese Tests sind sehr hilfreich, um herauszufinden wo ein Problem liegt, wenn man den Code weiterentwickelt und verändert.
- End to End Tests: Diese Tests wenden wir auch an, in dem wir unsere Kollegen bitten, mit unserem Tool herumzuspielen und gewisse Sachen auszuprobieren. Der Tester kennt dabei den Code nicht und kann somit auf Probleme stossen, an die wir nicht gedacht haben. Diese Tests werden zum Ende der Entwicklungsphase durchgeführt, wenn der Code sozusagen vollständig ist.
- Snapshot Testing: Snapshot Tests werden verwendet, um das Interface einer App zu testen. Wir verwenden es, um zu überprüfen, ob wir visuelle Vorgaben eingehalten haben und ob die Interaktion des Users mit dem Interface korrekt funktionieren. Dieser Test wird während des Entwickelns, aber auch vor allem gegen Ende angewendet, bevor eine Aufgabe abgeschlossen ist, um sicher zu stellen, dass alles so ist wie erwartet und gewünscht.

## Aufgabe 2
**SW-Fehler und SW-Schaden**
- SW-Fehler: Eine Anforderung wird nicht erfüllt. Das System verhält sich also nicht so, wie es soll.
- SW-Mangel: Eine Anforderung wird teilweise, aber nicht vollständig erfüllt. Z.B. wird beim Speichern von Daten in einer App ein korrekter POST Request gemacht, dieser wird aber im Backend nicht richtig abgearbeitet, wodurch die Daten schlussendlich nichte gespeichert werden.

**Beispiel hoher Schaden:**
Transaktionen in einer Bank funktionieren nicht richtig. Das heisst z.B. wenn ein Kunde eine Überweisung im Online Banking macht, dann wird das Geld nicht auf seinem Konto abgebucht, aber beim Empfänger hinzugefügt -> es gibt ein ungleichgewicht zwischen dem Geld im System und dem Geld das wirklich existiert, dies its Fatal.
