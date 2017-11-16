package ReflectionExamples;


/*
 * En este ejemplo traajamos haciendo un análisis de la clase en concreto. La clase no se instancia en ningun momento
 * Solo vemos propiedades de la clase y no de un objeto de la clase.
 * Ademas por ahora solo podremos ver los atributos y métodos declarados como públicos. Para poder acceder a los privados
 * debemos hacer algo mas complejo que veremos mas adelante.
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EjemploReflection2 {

	public static void main(String[] args) {
		
		Class clase;
		Field campo, campos[];
		Method metodo, metodos[];
		
		try {
			clase = Class.forName("ReflectionExamples.EjemploBean");
			
			//recorriendo los campos
			System.out.println("Lista de campos: \n");
			campos = clase.getFields();
			for(int i = 0; i < campos.length; i++) {
				campo = campos[i];
				System.out.println("\t" + campo.getName() + " (" + campo.getType().getName() + ")");
			}
			System.out.println("");
			
			//recorremos los metodos
			System.out.println("Lista de metodos: \n");
			metodos = clase.getMethods();
			for(int i = 0; i < metodos.length; i++) {
				metodo = metodos[i];
				System.out.print("\t" + metodo.getName() + " (");
				
				//recorremos los parametros de entrada del metodo
				Class  parametros[] = metodo.getParameterTypes();
				for(int j = 0; j< parametros.length;j++) {
					System.out.print(parametros[j].getName());
					if (j < parametros.length-1) {
						System.out.print(", ");
					}
				}
				System.out.print(") = " + metodo.getReturnType().getName());
				
				//recorremos las excepciones del método
				Class excepciones[] = metodo.getExceptionTypes();
				System.out.print(" [");
				for(int k = 0; k< excepciones.length; k++) {
					System.out.print(excepciones[k].getName());
					if (k < excepciones.length-1) {
						System.out.print(", ");
					}
				}
				System.out.println("]");
			}
				
			
		}catch(ClassNotFoundException e) {
			System.out.println("No se ha encontrado la clase. " + e);
		}
	}
}
