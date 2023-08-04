package swingAvanzado;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolFacil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoArbol miMarco = new MarcoArbol();
		miMarco.setDefaultCloseOperation(3);
		miMarco.setVisible(true);

	}

}

class MarcoArbol extends JFrame {

	public MarcoArbol() {
		setTitle("Arbol Facil");
		setBounds(300, 300, 600, 60);
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo"); // texto que apaerecera en la raíz del arbol
		DefaultMutableTreeNode pais = new DefaultMutableTreeNode("Bolivia"); // texto que apaerecera en la raíz del
																				// arbol
		raiz.add(pais);
		DefaultMutableTreeNode ciudad = new DefaultMutableTreeNode("La Paz");
		DefaultMutableTreeNode ciudad2 = new DefaultMutableTreeNode("Sucre");
		pais.add(ciudad);
		pais.add(ciudad2);

		DefaultMutableTreeNode capital = new DefaultMutableTreeNode("Murillo");
		DefaultMutableTreeNode capital2 = new DefaultMutableTreeNode("Apolobamba");
		ciudad.add(capital);
		ciudad.add(capital2);

		JTree arbol = new JTree(raiz);
//		LaminaArbol laminaArbol = new LaminaArbol(arbol);
//		add(laminaArbol);
		
		
		Container laminaContenido = getContentPane(); 
		
		laminaContenido.add(new JScrollPane(arbol));
		
	}
}

//class LaminaArbol extends JPanel {
//
//	public LaminaArbol(JTree arbol) {
//		setLayout(new BorderLayout());
//		add(arbol, BorderLayout.WEST);
//	}
//}