package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MarcoTabla miMarco = new MarcoTabla();
		miMarco.setDefaultCloseOperation(3);
		miMarco.setVisible(true);

	}

}

class MarcoTabla extends JFrame {

	String[] nombreColumnas = { "Nombre", "Dimension", "Lunas", "Gaseoso" };
	Object[][] datosFila = { { "Mercurio", 2440.0, 0, false }, { "Venus", 32440.0, 0, false },
			{ "Tierra", 42440.0, 1, false }, { "Jupiter", 52440.0, 2, false }, { "Marte", 24640.0, 16, false },
			{ "Saturno", 72440.0, 18, true }, { "Urano", 24840.0, 17, true }, { "Neptuno", 92440.0, 8, true },
			{ "Pluton", 24140.0, 1, false }

	};

	public MarcoTabla() {
		setTitle("Planetas");
		setBounds(300, 300, 600, 600);

		JTable tablaPlanetas = new JTable(datosFila, nombreColumnas);
		add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
		JButton boton = new JButton("imprimir tabla");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					tablaPlanetas.print();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		JPanel laminaBoton = new JPanel();
		laminaBoton.add(boton);
		add(laminaBoton,BorderLayout.SOUTH);
	}
}