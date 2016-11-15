package pizzeria;

public class Cliente implements Runnable {
		private Elenco e;
		private Avvio avvio;
		public Cliente(Elenco e, Avvio avvio){
			this.e=e;
			this.avvio = avvio;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Nuovo cliente");
			int n=1;
			e.ordina(n);
			//e.faipizza();
		}
}
