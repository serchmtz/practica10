package filosofos;

public class Main {

	public static void main(String[] args) {
		
		// Mesa mesa = new MesaSemaforos();
		Mesa mesa = new MesaMonitor();
		
		Filosofo filosofos[] = new Filosofo[5];
		for(int i =0 ; i < 5; i++)
			filosofos[i] = new Filosofo(i, mesa);
	}

}
