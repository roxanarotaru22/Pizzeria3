package pizzeria;

public class Pizzaiolo implements Runnable {
	private Elenco e;
	private Avvio avvio;
	
	public Pizzaiolo(Elenco e, Avvio avvio){
		this.e=e;
		this.avvio = avvio;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*if(e.pizza==0){
			System.out.println("Non ho pizze dammi una");
		/*	try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			e.faipizza();
			
		}*/
		while(true) {
			e.cepizza();
			System.out.println("Inizio a fare la pizza");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e.faipizza();

			System.out.println("Ho finito la pizza" );
			avvio.aggiungiPizzaPronta();
			// attende
			// faipizza
		}
		
		
		
	}
	
}
