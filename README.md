# AppCinema

Benvenuto su AppCinema, un'applicazione moderna per la gestione delle programmazioni cinematografiche. Questo progetto include funzionalità per visualizzare i programmi dei film, recuperare informazioni dettagliate sui film e sulle sale cinematografiche, e molto altro.

## Indice

- [Introduzione](#introduzione)
- [Caratteristiche](#caratteristiche)
- [Tecnologie Utilizzate](#tecnologie-utilizzate)
- [Installazione](#installazione)
- [Utilizzo](#utilizzo)
- [Endpoint API](#endpoint-api)
- [Schema del Database](#schema-del-database)
- [Contributi](#contributi)
- [Licenza](#licenza)
- [Contatti](#contatti)

## Introduzione

AppCinema è progettato per semplificare la gestione dei programmi cinematografici e fornire agli utenti informazioni aggiornate sui film e sulle sale. È costruito utilizzando tecnologie web moderne e segue le migliori pratiche per scalabilità e manutenibilità.

## Caratteristiche

- Visualizzazione di tutte le programmazioni dei film.
- Recupero di informazioni dettagliate su film e sale cinematografiche.
- Gestione dell'autenticazione e dell'accesso degli utenti.

## Tecnologie Utilizzate

- **Backend:** Java, Spring Boot
- **Frontend:** Angular 18
- **Database:** PostgreSQL
- **Strumento di Build:** Maven

## Installazione

Per ottenere una copia locale e avviarla, segui questi passaggi:

1. **Clona il repository:**

   ```bash
   git clone https://github.com/GambaX/AppCinema.git
   cd AppCinema
   ```

2. **Configura il database:**

   - Assicurati che PostgreSQL sia installato e in esecuzione.
   - Crea un database chiamato `appcinema`.
   - Aggiorna la configurazione del database in `application.properties` se necessario.

3. **Costruisci ed esegui l'applicazione:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Utilizzo

Una volta che l'applicazione è in esecuzione, puoi accedervi all'indirizzo `http://localhost:8080`.

### Endpoint API

- **Ottieni tutte le programmazioni:**

  ```http
  GET /cinema/allprogrammazioni
  ```

- **Ottieni sala per nome:**

  ```http
  GET /cinema/salabynome
  ```

- **Ottieni film per nome:**
  ```http
  GET /cinema/filmbynome
  ```

## Schema del Database

Il database è composto dalle seguenti tabelle:

- **Film:** Contiene i dettagli dei film.
- **Sala:** Contiene i dettagli delle sale cinematografiche.
- **Programmazione:** Collega film e sale, memorizzando i dettagli dei programmi.
- **Users:** Gestisce l'autenticazione degli utenti.

![Schema del Database](https://ibb.co/TmVWRZf)

## Contributi

I contributi sono benvenuti! Segui questi passaggi:

1. Fai un fork del repository.
2. Crea un nuovo branch (`git checkout -b feature/your-feature`).
3. Committa le tue modifiche (`git commit -m 'Aggiungi una nuova funzionalità'`).
4. Pusha sul branch (`git push origin feature/your-feature`).
5. Apri una Pull Request.

## Licenza

Questo progetto è licenziato sotto la Licenza MIT - vedi il file [LICENSE](LICENSE) per i dettagli.

## Contatti

Per qualsiasi domanda, non esitare a contattarci:

- **Autore:** Michele Gambardella
- **Email:** m.gambardella05@gmail.com
