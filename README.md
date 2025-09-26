Springboot Gestione Utenti e Sedie

1) Clonare il progetto: git clone <>
cd progetto

2) 
A) Dal terminale nella cartella del progetto
mvn spring-boot:run

B)Da STS avviare la classe
com.example.demo.SedieApplication

3)Avviare la console H2 accessibile su: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: lasciare vuoto


Api disponibili

POST /utenti – crea un nuovo utente

GET /utenti/{id} – cerca un utente per id

DELETE /utenti/{id} – elimina un utente

POST /sedie – crea una nuova sedia

GET /sedie/{id} – cerca una sedia per id

DELETE /sedie/{id} – elimina una sedia

POST /seduti – crea un’associazione utente-sedia

GET /seduti/{id} – recupera un’associazione per id

GET /seduti/by-sedia/{sediaId} – chi è seduto su una sedia

DELETE /seduti/{id} – l’utente si alza dalla sedia
