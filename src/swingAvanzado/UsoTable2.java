package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class UsoTable2 {

	public static void main(String[] args) {
		MarcoTabla2 miMarco = new MarcoTabla2();
		miMarco.setDefaultCloseOperation(3);
		miMarco.setVisible(true);

	}

}

class MarcoTabla2 extends JFrame {
	public MarcoTabla2() {
		setTitle("Tabla personalizada");
		setBounds(300, 300, 600, 600);
		ModeloTablaPerson tablaPerson = new ModeloTablaPerson();
		JTable miTabla = new JTable(tablaPerson);
		add(new JScrollPane(miTabla));
		
	}
}

class ModeloTablaPerson extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int z = rowIndex;
		int y = columnIndex;
		return " " + z + " " + y;
	}

}