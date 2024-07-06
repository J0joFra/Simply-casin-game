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
