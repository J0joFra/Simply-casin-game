### README.md

# Casino Game

Questo progetto è una simulazione di un semplice gioco da casinò implementato in Java con un'interfaccia grafica Swing. Il giocatore può scegliere un numero da 1 a 6, puntare una somma di denaro e lanciare un dado. Se il numero scelto corrisponde al risultato del dado, il giocatore vince e il suo conto aumenta. Altrimenti, perde la somma puntata.

## Descrizione dei file

Il progetto è composto da quattro file principali:

1. **ContoCasino.java**: Classe per gestire il conto del casinò.
2. **ContoGiocatore.java**: Classe per gestire il conto del giocatore.
3. **Dado.java**: Classe per simulare il lancio di un dado.
4. **VaiAlCasinoGUI.java**: Classe principale con l'interfaccia grafica del gioco.

### ContoCasino.java
Gestisce il saldo del casinò, includendo metodi per aggiungere o sottrarre denaro dal conto.


### ContoGiocatore.java
Gestisce il saldo del giocatore, includendo metodi per aumentare o sottrarre denaro dal conto.


### Dado.java
Simula il lancio di un dado con sei facce utilizzando la classe `Random` di Java.


### VaiAlCasinoGUI.java
Gestisce l'interfaccia grafica del gioco, permettendo al giocatore di interagire con il programma tramite finestre e pulsanti.


## Requisiti

- Java 8 o superiore.
- Un ambiente di sviluppo Java (come IntelliJ IDEA, Eclipse, o NetBeans).

## Istruzioni per l'uso

1. Clona o scarica questo repository.
2. Apri il progetto nel tuo ambiente di sviluppo Java preferito.
3. Compila e esegui il file `VaiAlCasinoGUI.java`.
4. Interagisci con l'interfaccia grafica per giocare.

## Funzionalità

- **Scegliere un numero**: L'utente può scegliere un numero tra 1 e 6.
- **Puntare una somma di denaro**: L'utente può inserire una somma di denaro da puntare.
- **Lanciare il dado**: L'utente può lanciare il dado e vedere il risultato.
- **Vincere o perdere**: Se il numero scelto corrisponde al risultato del dado, il giocatore vince e il suo conto aumenta. Altrimenti, perde la somma puntata.

## Schermate

### Schermata principale
![Schermata principale](screenshot_main.png)

### Risultato del lancio del dado
![Risultato del dado](screenshot_result.png)

## Note

- Assicurati di avere installato un JDK compatibile.
- Questo progetto è pensato per scopi educativi e di intrattenimento
  
