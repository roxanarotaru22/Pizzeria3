package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Utente {

	protected Shell shell;
	private Text tNome;
	private Text tPizza;
	Avvio avvio;
	List list_1;
	List list;
	Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Utente window = new Utente(null);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	public Utente(Avvio avvio){
		this.avvio= avvio;
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(153, 255, 255));
		shell.setSize(450, 203);
		shell.setText("SWT Application");
		
		tNome = new Text(shell, SWT.BORDER);
		tNome.setBackground(SWTResourceManager.getColor(102, 153, 255));
		tNome.setBounds(10, 42, 148, 30);
		
		tPizza = new Text(shell, SWT.BORDER);
		tPizza.setBackground(SWTResourceManager.getColor(102, 153, 255));
		tPizza.setBounds(243, 42, 141, 30);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				avvio.start(tNome.getText().toString(),tPizza.getText().toString());
				
				
			}
		});
		btnNewButton.setBounds(143, 108, 108, 25);
		btnNewButton.setText("Conferma ordine");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(153, 255, 255));
		lblNewLabel.setBounds(10, 21, 55, 15);
		lblNewLabel.setText("Nome");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(153, 255, 255));
		lblNewLabel_1.setBounds(243, 21, 55, 15);
		lblNewLabel_1.setText("Pizza");

	}
}
