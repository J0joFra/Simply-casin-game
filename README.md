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

```java
public class ContoCasino {
    private double contoCas;

    public ContoCasino(double c) {
        contoCas = c;
    }

    public double getContoCasino() {
        return contoCas;
    }

    public void sottraiContoCasino(double s) {
        contoCas -= s * 5;
    }

    public void sommaContoCasino(double s) {
        contoCas += s;
    }
}
```

### ContoGiocatore.java

Gestisce il saldo del giocatore, includendo metodi per aumentare o sottrarre denaro dal conto.

```java
public class ContoGiocatore {
    private double contoGio;

    public ContoGiocatore(double c) {
        contoGio = c;
    }

    public double getContoGiocatore() {
        return contoGio;
    }

    public void sottraiContoGiocatore(double s) {
        contoGio -= s;
    }

    public void aumentaContoGiocatore(double s) {
        contoGio += 5 * s;
    }
}
```

### Dado.java

Simula il lancio di un dado con sei facce utilizzando la classe `Random` di Java.

```java
import java.util.Random;

public class Dado {
    private Random generatore;
    private int facce;

    public Dado() {
        facce = 6;
        generatore = new Random();
    }

    public int lancia() {
        return 1 + generatore.nextInt(facce);
    }
}
```

### VaiAlCasinoGUI.java

Gestisce l'interfaccia grafica del gioco, permettendo al giocatore di interagire con il programma tramite finestre e pulsanti.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaiAlCasinoGUI extends JFrame {
    private ContoGiocatore fabio;
    private ContoCasino casino;
    private Dado dado;

    private JTextField numeroField;
    private JTextField sommaField;
    private JLabel risultatoLabel;
    private JLabel creditoLabel;

    public VaiAlCasinoGUI() {
        fabio = new ContoGiocatore(5000);
        casino = new ContoCasino(10000000);
        dado = new Dado();

        setTitle("Casino Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Scegli un numero (1-6):"));
        numeroField = new JTextField();
        panel.add(numeroField);

        panel.add(new JLabel("Punta una somma di denaro ($):"));
        sommaField = new JTextField();
        panel.add(sommaField);

        JButton lanciaButton = new JButton("Lancia il dado");
        lanciaButton.addActionListener(new LanciaDadoListener());
        panel.add(lanciaButton);

        risultatoLabel = new JLabel("Risultato:");
        panel.add(risultatoLabel);

        creditoLabel = new JLabel("Credito: $" + fabio.getContoGiocatore());
        panel.add(creditoLabel);

        add(panel, BorderLayout.CENTER);
    }

    private class LanciaDadoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int num = Integer.parseInt(numeroField.getText());
                double somma = Double.parseDouble(sommaField.getText());

                if (num < 1 || num > 6) {
                    JOptionPane.showMessageDialog(null, "Numero non valido. Scegli un numero da 1 a 6.");
                    return;
                }

                if (somma > fabio.getContoGiocatore() || somma > casino.getContoCasino() / 5) {
                    JOptionPane.showMessageDialog(null, "Non puoi puntare quella somma.");
                    return;
                }

                int lancio = dado.lancia();
                risultatoLabel.setText("Risultato: " + lancio);

                if (lancio == num) {
                    JOptionPane.showMessageDialog(null, "Complimenti hai vinto!");
                    fabio.aumentaContoGiocatore(somma);
                    casino.sottraiContoCasino(somma);
                } else {
                    JOptionPane.showMessageDialog(null, "Peccato, hai perso.");
                    casino.sommaContoCasino(somma);
                    fabio.sottraiContoGiocatore(somma);
                }

                creditoLabel.setText("Credito: $" + fabio.getContoGiocatore());

                if (fabio.getContoGiocatore() <= 0) {
                    JOptionPane.showMessageDialog(null, "CONTO ESAURITO");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Per favore inserisci valori validi.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VaiAlCasinoGUI().setVisible(true);
            }
        });
    }
}
```

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
- 
