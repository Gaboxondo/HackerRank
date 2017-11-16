package ReflectionExamples;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * En este ejemplo traajamos con un objeto de la clase y accediendo a un método con reflection. Estos ejemplos aun usan atributos
 * de tipo público por lo que no podremos ver los privados
 * Accederemos a un metodo del objeto de tipo publico para cambiar uno de sus atributos invocando al método
 */

public class EjemploReflection4 {
	
	public static void main (String[] args) {
		
		Class clase;
		Object objeto;
		Method metodos[], metodo;
		Field campos[], campo;
		
		try {
			clase = Class.forName("ReflectionExample.EjemploBean");
			
			try {
				objeto = clase.newInstance();
			} 
			catch (InstantiationException e) {
				System.out.println("Error al instanciar el objeto. " + e);
			} 
			catch (IllegalAccessException e) {
				System.out.println("Error al instanciar el objeto. " + e);
			}
		}
		catch(ClassNotFoundException e) {
			
		}
	}
	
}
