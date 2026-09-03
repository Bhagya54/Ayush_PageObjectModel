# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Selenium + Java learning project demonstrating the Page Object Model (POM) pattern against the live site `https://www.carwale.com`. Maven build, Java 21.

## Commands

```bash
# Compile
mvn compile

# Run the test suite (uses surefire; see caveat below)
mvn test

# Run the current runnable flow directly (it is a plain main() method, not a TestNG test)
mvn exec:java -Dexec.mainClass="rough.FindNewCarsTest" -Dexec.classpathScope=test
# or run rough.FindNewCarsTest as a Java Application from the IDE
```

There is no configured way to run "a single TestNG test" yet — no `@Test` methods exist (see below).

## Architecture

- `src/main/java/pages/` — Page Objects. Each class wraps a `WebDriver` passed via constructor and exposes intent-named actions (`findNewCars()`, `clickOnBMW()`, ...). Locators are inline `By.xpath(...)` string literals inside each method — there is no shared `BasePage`, no `PageFactory`/`@FindBy`, and no explicit-wait wrapper. `HomePage` → `NewCarsPage` → per-brand pages (`BMWCarsPage`, `TataCarsPage`, etc.) mirrors the site navigation flow.
- `src/test/java/rough/FindNewCarsTest.java` — Driver creation, ChromeOptions, waits, and `driver.get(...)` all live in a `public static void main(...)`. It instantiates page objects and chains their methods. This is the working end-to-end example to follow when adding flows.

### Key gaps to know before extending

- **No TestNG tests exist yet** despite the TestNG dependency. `FindNewCarsTest` is a `main()`, not a `@Test`. `mvn test` will not execute it.
- **`pom.xml` surefire references a missing suite file**: `<suiteXmlFile>src\test\resources\runner\bank.xml</suiteXmlFile>`. That path does not exist, so `mvn test` fails until a real suite XML is added (or the surefire config is pointed at actual test classes). The `bank.xml` name is unrelated to the carwale flow — likely leftover.
- Dependencies are declared for **TestNG, ExtentReports, Apache POI (Excel), Guice, and log4j 1.2**, but none are wired in yet. They signal the intended direction (data-driven tests from Excel, reporting, DI) rather than current usage.

### Conventions when adding code

- Follow the existing per-page class style: constructor takes `WebDriver`, one public method per user action, locators inline as XPath. Relies on the implicit wait set in the runner (`implicitlyWait(10s)`) — there are no explicit waits.
- New brand pages go in `pages/`; add the corresponding `clickOnX()` navigation method to `NewCarsPage`.
