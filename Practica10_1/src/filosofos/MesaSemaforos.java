package filosofos;
class MesaSemaforos implements Mesa
{
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoBinario sinc[] = new SemaforoBinario[5];
	
	String estadof[] = new String[5];
	public MesaSemaforos() {
		for(int i =0; i < 5 ; i++)
			sinc[i] = new SemaforoBinario(false);
		for(int i =0; i < 5 ; i++)
			estadof[i] = "PENSAR";

	}
	public void tomar_tenedores(int i) {
		
		mutex.P();
		
		//System.out.println("Filosofo " + (i+1)+ " Entro a CR");
		estadof[i] = "HAMBRE";
		probar_bocado(i);
		
		mutex.V();
		//System.out.println("Filosofo " + (i+1)+ " Salio a CR");
//		sinc[i].P();
		
	}
	public void probar_bocado(int i) {

		if(i > 0 && i < 4) {
			if (estadof[i] == "HAMBRE"
					&& estadof[i-1] != "COMER"				
					&& estadof[i+1] != "COMER") {
				estadof[i] = "COMER";
				sinc[i].V();
			}
		} 
		else if(i == 0) {
			if (estadof[i] == "HAMBRE"
					&& estadof[4] != "COMER"				
					&& estadof[i+1] != "COMER") {
				estadof[i] = "COMER";
//				sinc[i].V();
			}
		}
		else if(i == 4) {
			if (estadof[i] == "HAMBRE"
					&& estadof[i-1] != "COMER"				
					&& estadof[0] != "COMER") {
				estadof[i] = "COMER";
//				sinc[i].V();
			}
		}	
	}
	public void bajar_tenedores(int i) {
		mutex.P();
		if(i > 0)
			probar_bocado(i-1);
		else
			probar_bocado(4);
		if(i < 4)
			probar_bocado(i+1);
		else
			probar_bocado(0);
		mutex.V();
	}
}