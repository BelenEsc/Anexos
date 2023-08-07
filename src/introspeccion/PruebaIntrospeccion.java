package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class PruebaIntrospeccion {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("introduce el nombre de la clase");
		String recibido = entrada.next();
		System.out.println();
		try {

			Class cl = Class.forName(recibido);
			Class sucl = cl.getSuperclass();
			System.out.print("la superclase es: " + sucl + ", la clase es: " + cl);
			imprimeConstructores(cl);
			imprimirMetodos(cl);

		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}

	}

	private static void imprimirMetodos(Class cl) {
		Method[] metodos = cl.getDeclaredMethods();
		for (Method m : metodos) {
			Class tipoDevuelto = m.getReturnType();
			String nombre = m.getName();

			// imprime identificadores tipo y nombre

			System.out.print(" " + Modifier.toString(m.getModifiers()));
			System.out.print(" " + tipoDevuelto.getName() + " " + nombre + "(");

			// imprime tipo de parametros

			Class[] tipoParams = m.getParameterTypes();
			for (int i = 0; i < tipoParams.length; i++) {

				if (i > 0)
					System.out.print(", ");
				System.out.print(tipoParams[i].getName());
			}
			System.out.print(")");
		}

	}

	public static void imprimeConstructores(Class cl) {

		Constructor[] constructores = cl.getDeclaredConstructors();
		for (Constructor x : constructores) {
			String nombre = x.getName();
			System.out.print(" " + Modifier.toString(cl.getModifiers()));
			System.out.print(" " + nombre + "(");

			Class[] parametros = x.getParameterTypes();
			for (int i = 0; i < parametros.length; i++) {
				if (i > 0) {
					System.out.print(", ");
					System.out.print(parametros[i].getName());
					System.out.print(");");
				}
			}
		}

	}

}
