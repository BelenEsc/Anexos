package swingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame miMarco = new MarcoDeLista();
		miMarco.setDefaultCloseOperation(3);
		miMarco.setVisible(true);
	}

}

class MarcoDeLista extends JFrame {
	private JPanel laminaDeLista = new JPanel();
	private JPanel laminaTexto;
	private JLabel rotulo;
	private JList<String> listaMeses;

	public MarcoDeLista() {
		setTitle("Prueba de lista");
		setBounds(400, 300, 400, 300);

		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		listaMeses = new JList<>(meses);
		listaMeses.setVisibleRowCount(4);
		JScrollPane laminaDesplazamiento = new JScrollPane(listaMeses); // dentro del constructor hay que especificar a
																		// que componente queremos agregar la barra de
																		// desplazamiento
		laminaDeLista.add(laminaDesplazamiento);

		rotulo = new JLabel("mes seleccionado: ");
		listaMeses.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				List<String> valores = listaMeses.getSelectedValuesList();
				StringBuilder texto = new StringBuilder("hola ke ase mes seleccionado: ");
				for (String x : valores) {
					texto.append(x);
					texto.append(" ");
				}
				 String texto2 = texto.toString();
				 
				 rotulo.setText(texto2);
			}
		});

		laminaTexto = new JPanel();
		laminaTexto.add(rotulo);
		add(laminaDeLista, BorderLayout.NORTH);
		add(laminaTexto, BorderLayout.SOUTH);
	}

}