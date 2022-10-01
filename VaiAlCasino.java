import java.util.Scanner;

public class VaiAlCasino {
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		Dado d = new Dado();  
	
		ContoGiocatore fabio = new ContoGiocatore(5000);   
		ContoCasino casino = new ContoCasino(10000000);

		String verifica = "si";  
		System.out.println("Benvenuto al casino':\n");
		System.out.println("Scegli un numero da 1 a 6 e punta una somma di denaro");
		System.out.println("Se una volta lanciato il dado escwe il numero su cui hai puntato, allora hai vinto");

		while ( verifica.equalsIgnoreCase("si"))
		{
			System.out.println("Scegli un numero:"); 
			int num = in.nextInt();
			if(num>0 && num<7)
			{
				System.out.println("Punta una somma di denaro ($): "); 
				System.out.print("ricorda che il tuo credito è pari a " + fabio.getContoGiocatore());
				System.out.println(" ");
				double somma = in.nextDouble();

				double contoG = fabio.getContoGiocatore();
				double contoC = casino.getContoCasino();
				double contoCc = contoC/5;

				if ( somma <= contoG && somma <= contoCc)
				{
					System.out.println("Lancio il dado...");
					int lancio = d.lancia();
					System.out.print("Il risulatato del dado è :  ");
					System.out.println(lancio);

					if ( lancio == num)  // Verifico se il giocatore vince o perde
					{
						System.out.println("Complimenti hai vinto");
						fabio.aumentaContoGiocatore(somma);
						casino.sottraiContoCasino(somma);
					}else{
						System.out.println("Peccato, hai perso");
						casino.sommaContoCasino(somma);
						fabio.sottraiContoGiocatore(somma);
					}

				}else{
					System.out.println("Non puoi puntare quella somma");
				}

				double newSomma = fabio.getContoGiocatore();

				// Verifico se il giocatore può continuare a giocare
				if ( newSomma > 0)
				{
					System.out.println("Vuoi continuare a scommettere?");
					verifica = in.next();
					System.out.print("Il tuo conto è pari a :  ");
					System.out.println(fabio.getContoGiocatore());
				}else{
					System.out.println("CONTO ESAURITO");
					System.out.println(fabio.getContoGiocatore());
					verifica = "no";
				}
			}else{
				System.out.println("NUMERO NON VALIDO"); //se sceglie numero > di 6
                System.out.println("SCEGLI UN NUMERO DA 1 A 6");
			}
		}
	}
}

