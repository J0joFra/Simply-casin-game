public class ContoCasino {
	double contoCas;

	public ContoCasino(double c)
	{
		contoCas = c;
	}
	
	public double getContoCasino()  //restituisco il conto 
	{
		return contoCas;
	}

	public void sottraiContoCasino(double s) //quando vince fabio
	{
		double temp = contoCas;
		double temp1 = s*5;
		temp = temp - temp1;
		contoCas = temp;
	}

	public void sommaContoCasino(double s) //sommo la cifra scommessa
	{
		double temp = contoCas;
		temp = temp + s;
		contoCas = temp;
	}
}