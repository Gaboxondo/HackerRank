package ReflectionExamples;

import java.lang.reflect.*;

/*
 * En este ejemplo trabajamos haciendo un análisis de la clase en concreto. La clase no se instancia en ningun momento
 * Solo vemos propiedades de la clase y no de un objeto de la clase.
 * Ademas por ahora solo podremos ver los atributos y métodos declarados como públicos. Para poder acceder a los privados
 * debemos hacer algo mas complejo que veremos mas adelante.
 */

public class EjemploReflection1 {

	public static void main(String[] args) {
		
		Class clase;
		Field campo, campos[];
		Method metodo, metodos[];
		
		try {
			
			clase = Class.forName("ReflectionExamples.EjemploBean");
			
			System.out.println("Lista de campos: ");
			campos = clase.getFields();
			for(int i = 0; i< campos.length; i++) {
				campo = campos[i];
				System.out.println("\t" + campo.getName());
			}
			
			System.out.println("Lista de metodos: ");
			metodos = clase.getMethods();
			for(int i = 0; i<metodos.length; i++) {
				metodo = metodos[i];
				System.out.println("\t" + metodo.getName());
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("No se ha encontrado la clase. " + e);
		}
	}
}
