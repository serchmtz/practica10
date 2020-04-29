package filosofos;

import java.util.Random;

public class Filosofo implements Runnable {
	Mesa m = null;
	int id;
	Random r = new Random();
	public Filosofo( int i, Mesa mesa ) {
		m = mesa;
		id = i;
		new Thread( this ).start();
	}
	@Override
	public void run() {
		while( true ) {
			System.out.println("Filosofo " + (id+1) + " pensando" );
			
			m.tomar_tenedores(id);
			Util.mySleep(2000);
			if(id < 4)
				System.out.println("Filosofo " + (id+1) + " comiendo con tenedor " + (id+1) + " y tenedor " + ((id+2)%6));
			else
				System.out.println("Filosofo " + (id+1) + " comiendo con tenedor " + (id+1) + " y tenedor " + ((id+2)%5));
			m.bajar_tenedores(id);

			
		}

	}

}
