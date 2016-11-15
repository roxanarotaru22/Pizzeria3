package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.applet.AudioClip;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Text;
import java.applet.*;
import java.awt.*;
    

public class Avvio {

	protected Shell shell;
	Elenco elenco;
	Pizzaiolo pizzaiolo;
	Image immagine;
	Avvio avvio;
	List list_1;
	List list;
	Display display;
	Thread tp1;
	Thread tc1;
	Utente u1;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Avvio window = new Avvio();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		avvio = this;
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void aggiungiPizzaPronta() {
		// Chiamo un'operazione in modo asicrono
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				list.remove(0);
				list_1.add("Pizza PRONTA");
			}
		});
		
	}
		
	public void start(String text, String text2){
		Runnable c1 = new Cliente(elenco, avvio);
		tc1 = new Thread(c1);
		tc1.start();
		list.add("Pizza ordinata: " + text2  );
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(0, 0, 0));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		list = new List(shell, SWT.BORDER);
		list.setBackground(SWTResourceManager.getColor(204, 153, 204));
		list.setBounds(10, 134, 161, 118);
		
		list_1 = new List(shell, SWT.BORDER);
		list_1.setBackground(SWTResourceManager.getColor(204, 153, 204));
		list_1.setBounds(177, 134, 161, 118);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Tekton Pro", 17, SWT.NORMAL));
		lblNewLabel.setBounds(10, 68, 272, 44);
		
		Label label = new Label(shell, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(Avvio.class, "/pizzeria/aperto2.gif"));
		label.setBounds(129, 16, 103, 57);
		label.setVisible(false);
		
		Button btnArrivaUnCliente = new Button(shell, SWT.NONE);
		btnArrivaUnCliente.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				u1 = new Utente(avvio);
				u1.open();
				//list_1.add("Pizza ordinata: " + pizzaiolo. );
//				elenco elenco = new elenco();
//				elenco.ordina(1);
//				elenco.cepizza(1);
//				System.out.println("E stata ordinata da un cliente");
			}
			
		});
		
		Button btnApriPizzeria = new Button(shell, SWT.NONE);
		btnApriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnArrivaUnCliente.setEnabled(true);
				lblNewLabel.setText("PIZZERIA APERTA");
				label.setVisible(true);
				Runnable p1 = new Pizzaiolo(elenco, avvio);
				tp1 = new Thread(p1);
				tp1.start();
			}
		});
		btnApriPizzeria.setBounds(10, 14, 70, 51);
		btnApriPizzeria.setText("Apri pizzeria");
		
		btnArrivaUnCliente.setBounds(294, 16, 97, 25);
		btnArrivaUnCliente.setText("Arriva un cliente!");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnArrivaUnCliente.setEnabled(false);
				list.removeAll();
				list_1.removeAll();
				label.setVisible(false);
				lblNewLabel.setText("PIZZERIA CHIUSA");
			}
		});
		btnNewButton.setBounds(294, 47, 97, 25);
		btnNewButton.setText("Chiudi pizzeria");
		

		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBackground(SWTResourceManager.getColor(222, 184, 135));
		lblNome.setBounds(288, 10, 55, 15);
		lblNome.setText("Nome");
		
		Label lblPizza = new Label(shell, SWT.NONE);
		lblPizza.setBackground(SWTResourceManager.getColor(222, 184, 135));
		lblPizza.setBounds(288, 40, 55, 15);
		lblPizza.setText("Pizza");
		

		Label lblPizzeDaFare = new Label(shell, SWT.NONE);
		lblPizzeDaFare.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblPizzeDaFare.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblPizzeDaFare.setBounds(10, 113, 86, 15);
		lblPizzeDaFare.setText("Pizze da fare");
		
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		lblPizzePronte.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblPizzePronte.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblPizzePronte.setBounds(177, 113, 97, 15);
		lblPizzePronte.setText("Pizze pronte");

		Label lblByRoxali = new Label(shell, SWT.NONE);
		lblByRoxali.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblByRoxali.setForeground(SWTResourceManager.getColor(153, 255, 102));
		lblByRoxali.setBounds(353, 237, 71, 15);
		lblByRoxali.setText("By: Roxy e Ali");
		
		
		
	
		
		elenco = new Elenco();

	}


}
