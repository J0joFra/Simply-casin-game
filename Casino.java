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
