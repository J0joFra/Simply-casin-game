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
