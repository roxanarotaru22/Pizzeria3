package pizzeria;

public class Elenco {
	
	public int pizza;
	public int pizza2;
	double prezzo;

	public Elenco() {
		// pizza;
	}

	public synchronized int cepizza() {
		while (pizza == 0) {
			System.out.println("Non ho pizze da fare");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//faipizza();
		//System.out.println("Pizza pronta ");
		notifyAll();
		return pizza;
		// System.out.println("Estratto conto: "+ soldi);
	}
	
	public synchronized int faipizza() {
		pizza=pizza-1;
		//notifyAll();
		//cepizza();
		return pizza;
	}
	
	public synchronized int ordina(int n) {
		// TODO Auto-generated method stub
		pizza = pizza + n;
		System.out.println("Pizza ordinata " + pizza );
		//cepizza();
		notifyAll();
		//System.out.println("Pizza ordinata 2" );
		return pizza;
	}
}
