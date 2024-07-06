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
