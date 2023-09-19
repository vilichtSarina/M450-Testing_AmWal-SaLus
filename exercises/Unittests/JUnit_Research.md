# JUnit
## JUnit und die gängisten Features
- @BeforeAll und @BeforeEach
- @DisplayName und @Disabled
- @AfterEach und @AfterAll
- Assertions: assertTrue, assertAll, assertEquals
- Assumptions: assumeTrue, assumeFalse, assumingThat, assertThrows

## Anwendungsfälle und Beispiele
1. Vorbereitung und Aufräumen von Tests:
- @BeforeAll: Eine Methode vor allen Tests in einer Testklasse ausführen.
- @BeforeEach: Eine Methode vor jedem einzelnen Testfall in einer Testklasse ausführen.
- @AfterEach: Eine Methode nach jedem einzelnen Testfall in einer Testklasse ausführen.
- @AfterAll: Eine Methode nach allen Tests in einer Testklasse ausführen.

2. Testfall-Benennung und -Deaktivierung:
- @DisplayName: Einen beschreibenden Namen für einen Testfall festlegen.
- @Disabled: Einzelne Testfälle vorübergehend deaktivieren.

3. Überprüfung von Ergebnissen:
- Assertions wie assertTrue, assertAll, assertEquals zur Überprüfung von erwarteten Ergebnissen.
- assertThrows: Überprüfen, ob eine bestimmte Ausnahme in einem Testfall ausgelöst wird.

4. Bedingte Ausführung von Tests:
- assumeTrue und assumeFalse: Tests unter bestimmten Voraussetzungen ausführen oder überspringen.
- assumingThat: Tests unter einer bestimmten Bedingung ausführen und überspringen, wenn die Bedingung nicht erfüllt ist.

## Referenzseite
https://www.baeldung.com/junit-5 