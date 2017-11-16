package ReflectionExamples;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * En este ejemplo traajamos con un objeto de la clase y modificando su valor con reflection. Estos ejemplos aun usan atributos
 * de tipo público por lo que no podremos ver los privados
 * Modificaremos el valor de un atributo publico
 */

public class EjemploReflection3 {
	public static void main(String[] args) {
		
		Class clase;
		Object objeto;
		Field campo, campos[];
		Method metodo, metodos[];
		
		try {
			
			//Cargamos la clase
			clase = Class.forName("ReflectionExamples.EjemploBean");
			
			//Instanciamos el objeto desde la clase
			objeto = clase.newInstance();
			
			//recorremos sus campos
			System.out.println("Lista de campos: \n");
			campos = clase.getFields();
			for(int i = 0;i< campos.length;i++) {
				campo = campos[i];
				String valor = (String)campo.get(objeto);
				System.out.println("\t" + campo.getName() + " = " + valor + " (" + (campo.getType().getName() + ")"));
				
				//vamos a cambiar su valor desde dentro
				
				valor = valor + " nuevo";
				campo.set(objeto, valor);
				System.out.println("\tNuevo valor: " + campo.getName() + " = " + valor + " (" + (campo.getType().getName() + ")"));
			}
			
		}
		catch (InstantiationException e) {
			System.out.println("Error al instanciar el objeto. " + e);
			
		} 
		catch (IllegalAccessException e) {
			System.out.println("Error al instanciar el objeto. " + e);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la clase. " + e);
		}	
	}
}
