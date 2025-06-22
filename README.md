# Rubikova Kocka API

Ovo je REST API aplikacija za simulaciju Rubikove kocke napravljena u **Spring Boot-u**.

Omogucava:
- Prikaz trenutnog stanja kocke,
- Rotaciju lica kocke (CW smer),
- Resetovanje kocke,
- Čuvanje i učitavanje stanja kocke iz JSON baze.

---

##  Tehnologije
- Java 21
- Spring Boot 3.5
- REST API
- JUnit 5 (unit testovi)
- H2 (tokom razvoja)
- JSON fajl kao baza podataka

---

##  Pokretanje aplikacije

1. Kloniraj repozitorijum:
  git clone https://github.com/korisnik/rubik-api.gi
2. Udji u projekat:
  cd rubik
3. Pokreni aplikaciju:
   ./mvnw spring-boot:run
aplikacija se pokrece na http://localhost:8080

##  API Rute

- Prikaz stanja kocke:
  /cube
- Rotiranje lica:
  /cube/rotate?face=U&direction=CW
  mogucnosti za face: U, D, F, B, L, R
- Reset kocke:
  /cube/reset
- Cuvanje stanja kocke:
  /cube/save
- Ucitavanje stanja kocke:
  /cube/load

##  Testiranje

Testovi se nalaze u RubikApplicationTests klasi i pokrivaju:
-  Pocetno stanje kocke
-  Rotacije
-  Reset
-  Povratak u pocetno stanje nakon 4 rotacije
  
