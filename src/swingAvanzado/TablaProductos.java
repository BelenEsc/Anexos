package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TablaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marcoTabla = new MarcoTablax();
		marcoTabla.setDefaultCloseOperation(3);
		marcoTabla.setVisible(true);
	}

}

class MarcoTablax extends JFrame {

	private JComboBox nombresTablas;
	private DatabaseMetaData datosBBDD;
	private ResultSet rs;
	private Connection miConex;
	private Statement stat;
	private RSenTabla resulse;

	public MarcoTablax() {
		setTitle("Tabla con base de datos");
		setBounds(30, 30, 600, 600);

		JPanel panelSuperior = new JPanel();
		nombresTablas = new JComboBox();

		try {
			miConex = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7623827",
					"sql7623827", "akYVms4umE");
			datosBBDD = miConex.getMetaData();
			rs = datosBBDD.getTables(null, null, null, null);
			while (rs.next()) {
				nombresTablas.addItem(rs.getString("TABLE_NAME"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		nombresTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String seleccionada = nombresTablas.getSelectedItem().toString();
				String consulta = "SELECT * FROM " + seleccionada;
				try {
					stat = miConex.createStatement();
					rs = stat.executeQuery(consulta);

					resulse = new RSenTabla(rs);

					JTable tabla = new JTable(resulse);
					add(new JScrollPane(tabla), BorderLayout.CENTER);
					validate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panelSuperior.add(nombresTablas);
		add(panelSuperior, BorderLayout.NORTH);

	}

}

class RSenTabla extends AbstractTableModel {

	private ResultSet resultadoEntrante;
	private ResultSetMetaData rsMetadata;

	public RSenTabla(ResultSet entrada) {
		resultadoEntrante = entrada;
		try {
			rsMetadata = resultadoEntrante.getMetaData();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public int getRowCount() {
		try {
			resultadoEntrante.last();
			return resultadoEntrante.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		int columnas = 0;
		try {
			columnas = rsMetadata.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnas;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		try {
			resultadoEntrante.absolute(rowIndex + 1);
			return resultadoEntrante.getObject(columnIndex + 1);

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public String getColumnName(int c) {

		try {
			return rsMetadata.getColumnName(c + 1);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

}
