public class ContoGiocatore {
	double contoGio;
	
	public ContoGiocatore(double c)
	{
		contoGio = c;
	}

	public double getContoGiocatore()
	{
		return contoGio;
	}

	public void sottraiContoGiocatore(double s)
	{
		double temp = contoGio;
		temp = temp - s;
		contoGio = temp;
	}

	public void aumentaContoGiocatore(double s)
	{
		double temp = 5*s;
		contoGio = contoGio + temp;
	}
}
