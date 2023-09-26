# Übungen

## Übung 1

### Aufgabenstellung:

Wir haben folgende Beschreibung einer Verkaufssoftware:

_Über die Verkaufssoftware kann das Autohaus seinen Verkäufern Rabattregeln vorgeben: Bei einem Kaufpreis von weniger
als 15’000 CHF soll kein Rabatt gewährt werden. Bei einem Preis bis zu 20’000 CHF sind 5% Rabatt angemessen.Liegt der
Kaufpreis unter 25’000 CHF sind 7% Rabatt möglich, darüber sind 8,5 % Rabatt zu gewähren._

Leiten Sie aus dieser Beschreibung Testfälle ab. Wir wollen beide Varianten von Testfällen untersuchen.

- Eine Tabelle mit abstrakten Testfällen. Hier verwenden Sie logische Operatoren wie > , < , etc.

- Eine Tabelle mit konkreten Testfällen. Hier verwenden Sie ganz konkrete Eingabe-Werte um die Testfälle zu erstellen.

### Erarbeitung

#### Abstrakte Testfälle

Diese abstrakten Testfälle definieren die Kundenbedingungen auf einer allgemeinen Ebene andhand der Variable x.

|   Kaufpreis x in CHF | Rabatt | Kosten nach Rabatt in CHF |
| -------------------: | :----: | :------------------------ |
|           x < 15'000 |   0%   | x                         |
| 15'000 < x <= 20'000 |   5%   | (x \* 0.95) CHF           |
|  20'000 < x < 25'000 |   7%   | (x \* 0.93) CHF           |
|          25'000 <= x |  8.5%  | (x \* 0.915) CHF          |

#### Konkrete Testfälle

Die konkreten Testfälle in der untenstehenden Tabelle zeigen Eingangswerte auf und orientieren sich nach den oben festgelegten abstrakten Testfällen. Aufgezeigt werden hier für die verschiedenen Szenarien generelle Fälle, wie auch Edge-Cases.

| Absoluter Kaufpreis in CHF | Rabatt | Kosten nach Rabatt in CHF |
| -------------------------: | :----: | :------------------------ |
|                      7'000 |   0%   | 7'000                     |
|                   14'999.9 |   0%   | 14'999.0                  |
|                     16'500 |   5%   | 15'675                    |
|                     20'000 |   5%   | 19'000                    |
|                     20'001 |   7%   | 18'600.93                 |
|                     23'000 |   7%   | 21'390                    |
|                     24'999 |   7%   | 23'249.7                  |
|                     25'000 |  8.5%  | 22875                     |
|                    204'450 |  8.5%  | 187'071.75                |

---

## Übung 2

### Aufgabenstellung

Suchen Sie sich eine Webseite zum Thema **Autovermietung**.

Definieren Sie _funktionale Black-Box Tests_, die Sie brauchen, um diese Plattform zu betreiben. </br>
_Listen Sie die 10 wichtigsten Testfälle auf_

Erstellen Sie eine Matrix mit diesen Testfällen als Markdown und stellen Sie diese in Ihr Repository.

### Erarbeitung

Zur Erabereitung dieser Aufgabenstellung wurde https://www.europcar.ch/de-ch genauer betrachtet.

Szenarien:

- Aufrufen der Seite
- Eingabe eines Ortes (gültig oder ungültig)
- Daten setzen (gültige oder ungültige)
- Suche mit gewählten Optionen (gültige und ungültige)

|                      Id                      | Tester |                                                                                  Definition                                                                                  |                                          Vorbedingungen                                          |                                                                                 Testschritte                                                                                  |                                                                                                                                                           Erwartetes Resultat                                                                                                                                                            |                                                                                                                                                          Tatsächliches Resultat                                                                                                                                                          | Status | Priorität |
| :------------------------------------------: | :----: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----: | :-------: |
|              KannSeiteAufrufen               | Sarina |                                                           Die Seite kann über Aufruf des Links aufgerufen werden.                                                            | Die Seite wird bereits gehostet und das Testgerät hat eine funktionstüchtige Internetverbindung. |                                                        In einem Browser wird der die Adresse der Webseite eingegeben.                                                         |                                                                                                                 Die Seite wird geöffnet, ein Suchprompt erscheint, der die Nötigen Autovermietungsangaben setzen lässt.                                                                                                                  |                                                                                                                 Die Seite wird geöffnet, ein Suchprompt erscheint, der die Nötigen Autovermietungsangaben setzen lässt.                                                                                                                  |  Pass  |    P0     |
|              LässtGültigenOrtZu              | Sarina |                                                 In die Freitextsuche wird der existierende, gültige Ort "Zürich" eingegeben.                                                 |                                 Die Seite ist bereits geöffnet.                                  |                                                                In der Freitextsuche wird "zürich" eingegeben.                                                                 |                                                                                                                      Die Seite erkennt Zürich als eine gültige Abholortschaft und übernimmt die zulässige Eingabe.                                                                                                                       |                                                                                                                      Die Seite erkennt Zürich als eine gültige Abholortschaft und übernimmt die zulässige Eingabe.                                                                                                                       |  Pass  |    P0     |
|           UngültigerOrtGibtFehler            | Sarina |                     In die Freitextsuche sollte ein String eingegeben werden, der nicht mit einer existierenden Ortschaft übereinstimmt. Hier "Blabla".                      |                                 Die Seite ist bereits geöffnet.                                  |                                                       In der Freitextsuche wird "blabla" eingegeben und Enter gedrückt.                                                       |                                                                                                                        Das Feld wird die Eingabe nicht übernehmen und gibt eine Errormessage an den User zurück.                                                                                                                         |                                                                                                                        Das Feld wird die Eingabe nicht übernehmen und gibt eine Errormessage an den User zurück.                                                                                                                         |  Pass  |    P1     |
|          VergangenesDatumUnzulässig          | Sarina |                                          Für das Feld _Abholdatum_ wird ein Datum in der Vergangenheit gewählt. Hier "12.08.2023".                                           |                                 Die Seite ist bereits geöffnet.                                  |                                      Es wird auf das Abhol Datumsfeld geclickt, woraufhin beim Datepicker "12.08.2023" angeklickt wird.                                       |                                                                                                                                                    Die Eingabe wird nicht angenommen.                                                                                                                                                    |                                                                                                                                                    Die Eingabe wird nicht angenommen.                                                                                                                                                    |  Pass  |    P0     |
|       RückgabeVorAbholdatumUnzulässig        | Sarina |             Mit einem bereits gesetzten, gültigen Abholdatum (hier "20.10.2023") wird ein Rückgabedatum gewählt, das vor dem Abholdatum ist (hier "12.09.2023").             |                                Die Seite ist bereits aufgerufen.                                 |   Für das Abholdatum wird im Datepicker der 20.10.2023 angewählt. Danach wird das Rückgabe Datumsfeld angeclickt, und in dessen Datepicker wird der 12.09.2023 angeclickt.    |                                                                                                                                                Die letztere angabe wird nicht übernommen.                                                                                                                                                |                                                                                                                                          Das Rückgabedatum wird nicht als Feldwert übernommen.                                                                                                                                           |  Pass  |    P0     |
| RückgabeZeitpunktVorAbholzeitpunktUnzulässig | Sarina | Sind Abhol- und Rückgabedatum gleich, so wird für die Uhrzeit eine frühere gesetzt bei der Rückgabe, als bei dem Abholen (hier 22.10.2023, Abholen: 19:00, Rückgabe: 12:00). |                                 Die Seite ist bereits geöffnet.                                  | Für Abhol- und Rückgabedatum werden im Datepicker der 22.10.2023 angewählt. Bei der Uhrzeitangabe wird für das Abholen 19:00 gewählt. Bei der Rückgabe wird 11:00 angeklickt. | Für Abhol- und Rückgabedatum werden im Datepicker der 22.10.2023 angewählt, woraufhin dieser gültige Wert in das Feld übernommen wird. Bei der Uhrzeitangabe wird für das Abholen 19:00 gewählt, was als gültiger Wert übernommen wird. Bei der Rückgabe wird 11:00 angeklickt, was nicht als gültigen Wert in das Feld übernommen wird. | Für Abhol- und Rückgabedatum werden im Datepicker der 22.10.2023 angewählt, woraufhin dieser gültige Wert in das Feld übernommen wird. Bei der Uhrzeitangabe wird für das Abholen 19:00 gewählt, was als gültiger Wert übernommen wird. Bei der Rückgabe wird 11:00 angeklickt, was nicht als gültigen Wert in das Feld übernommen wird. | Status | Priorität |
|  AbholzeitpunktVorRückgabezeitpunktZulässig  | Sarina |                                     Bei einer eintägigen Vermietung ist der Rückgabezeitpunkt nach dem Abholzeitpunkt. (12:00 und 19:00)                                     |                                 Die Seite ist bereits geöffnet.                                  |                Bei dem Abhol- und Rückgabedatum werden jeweils der 22.10.2023 ausgewählt, bei dem Abholzeitpunkt wird 11:00 angewählt, für die Rückgabe 19:00.                |                                                                                                                                             Die zulässigen Eingaben werden alle angenommen.                                                                                                                                              |                                                                                                                                             Die zulässigen Eingaben werden alle angenommen.                                                                                                                                              |  Pass  |    P0     |
|      SucheOhneGesetzteFelderUnzulässig       | Sarina |                                                          Es werden keine Angaben gemacht, um nach Autos zu suchen.                                                           |                                 Die Seite ist bereits geöffnet.                                  |                                                             Ohne Daten einzugeben wird das Suchen Feld angewählt.                                                             |                                                                                                                                       Die Suche misslingt und der User erhält eine Error Message.                                                                                                                                        |                                                                                                                                       Die Suche misslingt und der User erhält eine Error Message.                                                                                                                                        |  Pass  |    P1     |
|    SucheMitFehlendemPflichtfeldUnzulässig    | Sarina |                                       Gültige Abhol- und Rückgabezeitpunkte werden gesetzt, ohne das Pflichtfeld "Ort" zu definiereen.                                       |                                 Die Seite ist bereits geöffnet.                                  |                    Als Abholzeitpunkt wird 22.10.2023, 19:00 gewählt, als Rückgabezeitpunkt 25.10.2023 11:00. Danach wird auf den Suchen Button geklickt.                     |                                                                                                                    Gültige Felder werden als Werte angenommen, Suche misslingt und der User erhält eine Error Message                                                                                                                    |                                                                                                                    Gültige Felder werden als Werte angenommen, Suche misslingt und der User erhält eine Error Message                                                                                                                    |  Pass  |    P1     |
|   SucheMitGesetztenPflichtfeldernZuslässig   | Sarina |                                              Eine gültige Ortschaft wird gewählt, mit gültigen Abhol- und Rückgabezeitpunkten.                                               |                                 Die Seite ist bereits geöffnet.                                  |  Als Abholzeitpunkt wird 22.10.2023, 19:00 gewählt, als Rückgabezeitpunkt 25.10.2023 11:00. Die Ortschaft Zürich wird angegeben. Danach wird auf den Suchen Button geklickt.  |                                                                                                                         Es wird eine Liste von verfügbaren Fahrzeugen angegeben, insofern welche Verfügbar sind.                                                                                                                         |                                                                                                                                         Es wird eine Liste von verfügbaren Fahrzeugen angegeben.                                                                                                                                         |  Pass  |    P0     |
|        AutovermietungNurAnErwachsene         | Sarina |                      Minderjährige dürfen von gesetzeswesen nicht Autofahren und Mietverträge abschliessen. Diese Möglichkeit steht nur Erwachsenen zu.                      |                                 Die Seite ist bereits geöffnet.                                  |                                               Beim Alter wird versucht das alter 16 auszwählen, durch anklicken des Dropdowns.                                                |                                                                                                                                                     Die Option ist nicht verfügbar.                                                                                                                                                      |                                                                                                                                                     Die Option ist nicht verfügbar.                                                                                                                                                      |  Pass  |    P0     |

---

## Übung 3

### Aufgabestellung

Sie haben folgende Software einer simplen Bank-Software. Laden Sie das Source-Zip herunter und erstellen Sie ein lokales
Projekt in Ihrer IDE. Achtung! Sie müssen auch die JAR-Files für GSON und OKHTTP installieren. Alternativ können Sie das
[Maven Projekt](https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/blob/main/Unterlagen/teststrategie/bank-software-mvn.zip)
um es ohne die JAR-Files in Betrieb zu nehmen. Die Software plus JAR-Files finden Sie
hier: https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/tree/main/Unterlagen/teststrategie
Machen Sie sich mit dem Code vertraut.

Wir wollen ganz grob herausfinden, was für Testfälle es in dieser Software gibt.

- Identifzieren Sie mögliche Black-Box Testfälle, welche Sie als Benutzer testen können.
- Welche Methoden im Code könnten für White-Box Testfälle verwendet werden?
- Was würden Sie am Code generell verbessern, welche Best Practices fallen Ihnen ein

Listen Sie Ihre Testfälle auf in einem Markdown-Dokument und stellen Sie Ihre Lösung in Ihr Repository.

### Erarbeitung

Mögliche Testfälle:
| Testfall | Erwartetes Resultat|
| :---: | :---: |
| Eingabe eines Regexpatterns | Führt nicht zu Crash, gibt Fehlermeldung an User. |
| Inexistenter Account wird gewählt | Fehlermeldung an User, erneute Eingabe möglich. |
| Mehr abheben als Geld vorhanden ist. | Fehlermeldung an User, erneute Eingabe möglich. |

Whitebox Testmethoden:

- In dem Projekt könnten JUnit Tests erstellt werden. Diese würden Spezifische Methoden des Codes auf ihre Funktionalität testen.
- Die Maven Konfiguration könnte erweitert / angepasst werden um eine Umgebung für Integration Tests zu starten. Somit können ganze Requests durchgetestet werden, die auf der Interaktion zwischen mehreren Funktionen und Klassen zählen.

Verbesserungsvorschläge am Code:

- Generelles Vermeiden von 'var' wenn möglich
- Deskriptive Variabelnamen, c1 ist nicht gut
- Try Catch vermeidbar mittels durchdachter String- und Eingabevalidierung
- Vermeiden von Umlauten für Usereingabe Prompts, da diese nicht auf allen Tastaturen vorhanden sind.
- Auslagern von in sich abschliessenden Prozessen, um riesige unübersichtliche Funktionen zu vemeiden
- Konsistenz bei den Kommentaren: Entscheiden, Englisch oder Deutsch!!!
- Nit: Konversionen von Strings vermeiden durch Anwendung von "EqualsIgnoreCase", Performance minimal besser und ausnutzen der Language Features
- Response Beispiele nicht inmitten von Funktionen, einbinden in Java Doc
- Konsistente Verwendung von Java Doc
