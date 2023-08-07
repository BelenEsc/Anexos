package introspeccion;

public class UsoEmpleado {

	public static void main(String[] args) {

		Persona tonio = new Persona("Antonio");
		System.out.println(tonio.getNombre());
		Empleado ana = new Empleado("Ana", 40000);
		System.out.println(ana.getNombre() + " " + ana.getSalario());
		System.out.println(tonio.getClass());
		System.out.println(ana.getClass());

		String nombreClase = "introspeccion.Empleado";
		// Class clase1 = tonio.getClass();
		try {
			Class clase1 = Class.forName(nombreClase);
			System.out.println(clase1.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Persona {

	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}

class Empleado extends Persona {
	private double salario;

	public Empleado(String nombre, double salario) {
		super(nombre);
		this.salario = salario;
		// TODO Auto-generated constructor stub
	}

	void setIncentivo(double ins) {
		salario = salario + ins;
	}

	public String getSalario() {
		return "el salario es: " + salario;
	}

}