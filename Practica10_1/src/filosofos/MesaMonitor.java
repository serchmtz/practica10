package filosofos;
class MesaMonitor implements Mesa
{

	//Variables de condición
	String estadof[] = new String[5];
	public MesaMonitor() {
		for(int i =0; i < 5 ; i++)
			estadof[i] = "PENSAR";

	}
	// Método de ingreso
	public synchronized void tomar_tenedores(int i) {
		int ant = i-1;
		int sig = i+1;
		if( i == 4 ) sig = 0;
		if( i == 0 ) ant = 4;
		//Condición de sincronización
		while(estadof[ant] == "COMER" || estadof[sig] == "COMER")
			Util.myWait(this);
		estadof[i] = "HAMBRE";
		probar_bocado(i);

	}
	// Método de ingreso
	public synchronized void probar_bocado(int i) {
		int ant = i-1;
		int sig = i+1;
		if( i == 4 ) sig = 0;
		if( i == 0 ) ant = 4;
		//Condición de sincronización
		while(estadof[ant] == "COMER" || estadof[sig] == "COMER")
			Util.myWait(this);
		estadof[i] = "COMER";
		notify();

	}
	// Método de ingreso
	public synchronized void bajar_tenedores(int i) {
		estadof[i] = "PENSAR";
		notify();
	}
}