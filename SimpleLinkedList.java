package Examen;

public class SimpleLinkedList {
	private Node first;
	private int size;
	
	public SimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public SimpleLinkedList(Node first) {
		this.first = first;
		this.size = 1;
	}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/*
	 * Pre:---
	 * Post:En este m�todo a�adimos un nuevo node a la SimpleLinkedList.
	 */
	public boolean add(Node node) {
		try {
			if(size == 0) {
				first = node;
			} else {
				Node p = first;
				for(int i = 1; i < size; i++) {
					p = p.getNext();
				} p.setNext(node);
			} size++;
			return true;
		} 
		catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre:---
	 * Post:En este m�todo mostramos todo el valor de los nodos de la SimpleLinkedList.
	 */
	public void show() {
		Node p = first;
		for(int i = 0; i < size; i++) {
			System.out.println("[ " + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
	
	/*
	 * Pre:---
	 * Post:En este m�todo eliminamos un node seg�n la posici�n que recibimos.
	 */
	public boolean delete(int position)  {
		try {
			Node p = first;
			if(position == 0) {
				first = p.getNext();
			}
			else if(position == size -1) {
				for(int i = 1; i < size; i++) {
					p = p.getNext();
				}
				p.setNext(null);
			}
			else {
				for(int i = 1; i < position; i++) {
					p= p.getNext();
				}
				p.setNext(p.getNext().getNext());
			}
			size--;
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}	
	}
	
	/*
	 * Pre:---
	 * Post:En este m�todo buscamos el node con el entero de mayor n�mero y guardamos su posicion,
	 * posteriormente llam�mos al m�todo delete envi�ndole su posici�n para que lo elimine.
	 */
	public void eliminarMayor() {
		Node p = first;
		int num = 0;
		int id = 0;
		for(int i = 0; i < size; i++) {
			if(num < p.getContent()) {
				id = i;
				num = p.getContent();
			}
			p = p.getNext();
		}
		delete(id);
	}
}