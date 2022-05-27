package Examen;

public class Ejercicio3 {
	
	/*
	 * Pre:---
	 * Post:En este método creamos una SimpleLinkedList y le añadimos diferentes nodes con enteros de 
	 * diferentes valores, posteriormente los mostramos por pantalla y llamámos al método de la lista
	 * "eliminarMayores", para eliminar el mayor. Finalmente mostramos por pantalla la lista para 
	 * observar que se ha eliminado el número correcto.
	 */
	public static void main(String[]args) {
		SimpleLinkedList lista = new SimpleLinkedList();
		lista.add(new Node(1));
		lista.add(new Node(2));
		lista.add(new Node(8));
		lista.add(new Node(4));
		lista.add(new Node(5));
		lista.show();
		System.out.println("---");
		System.out.println("---");
		lista.eliminarMayor();
		System.out.println("---");
		System.out.println("---");
		lista.show();
	}
}
