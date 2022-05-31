package src.tpe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public void add(String genero) {
		if (this.root == null)
			this.root = new TreeNode(genero);
		else
			this.add(this.root, genero);
	}
	
	
	private void add(TreeNode actual, String genero) {
		if (actual.getGenero().compareTo(genero) > 0) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(genero);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),genero);
			}
		} else if (actual.getGenero().compareTo(genero) < 0) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(genero);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), genero);
			}
		}
	}
	
	//getRoot() 
	private String getRoot() {
		if (this.root != null) {
			return this.root.getGenero();
		} else {
			return null ;
		}
	}
	
	
	public void agregarLibro(String genero, Libro l) {
		if (this.root != null) {
			this.agregarLibro(this.root, genero, l);
		}
	}
	
	private void agregarLibro(TreeNode n, String genero, Libro l) {
		if (n.getGenero().compareTo(genero) == 0) {
			n.addLibro(l);
		} else {
			if ((n.getGenero().compareTo(genero) > 0) && (n.getLeft() != null)){
				agregarLibro(n.getLeft(), genero, l);
			}
			if ((n.getGenero().compareTo(genero) < 0) && (n.getRight() != null)){
				agregarLibro(n.getRight(), genero, l);
			}
		}
	}
	
	//boolean isEmpty() 
	public boolean isEmpty() {
		return this.root == null ;
	}
	
	//int getHeight()
	public int getHeight(TreeNode n) {
		if ((n.getLeft() == null) && (n.getRight() == null)) {
			return 0;
		}
		int der = 0;
		int izq = 0;
		if (n.getLeft() != null) {
			izq = getHeight(n.getLeft()) + 1 ;
		}
		if (n.getRight() != null) {
			der = getHeight(n.getRight()) + 1 ;
		}
		return Math.max(izq, der) ;
	}
	
	//void printPosOrder()
	public void printPosOrder() {
		if (this.root != null) {
			printPosOrder(this.root) ;
		}
	}
	private void printPosOrder(TreeNode n) {
		if (n.getLeft() != null) printPosOrder(n.getLeft());
		if (n.getRight() != null ) printPosOrder(n.getRight());
		System.out.println(n.getGenero() + " = " + n.getCantLibros()) ;
	}
	
	//void printPreOrder()
	public void printPreOrder() {
		if (this.root != null) {
			printPreOrder(this.root) ;
		}
	}
	private void printPreOrder(TreeNode n) {
		System.out.print(n.getGenero() + " ") ;
		if (n.getLeft() != null) printPreOrder(n.getLeft());
		else System.out.print("- ");
		if (n.getRight() != null ) printPreOrder(n.getRight());
		else System.out.print("- ");
	}
		
	//void printInOrder()
	public void printInOrder() {
		if (this.root != null) {
			printInOrder(this.root) ;
		}
	}
	/**
	 * Imprime el arbol en orden
	 * Complejidad: O(n) porque si o si lo recorro todo
	 * @param n
	 */
	private void printInOrder(TreeNode n) {
		if (n.getLeft() != null) { 
			printInOrder(n.getLeft());
		}
		else { 
			System.out.print("- ");; 
		}
			System.out.print(n.getGenero()) ;
		if (n.getRight() != null ) {
			printInOrder(n.getRight());
		} else { 
			System.out.print("- ");; 
		}
	}

			
	private boolean esHoja(TreeNode n) {
		return ((n.getLeft() == null) && (n.getRight() == null)) ;
	}

	public void getLibrosGenero(String genero) {
		if (this.root != null) {
			List<Libro> listaLibros = new LinkedList<Libro>();
			listaLibros.addAll(getListaLibros(this.root, genero));
			writeLibrosGenero(listaLibros) ;
		}
	}
	
	public static void writeLibrosGenero(List<Libro>lista) {
		
		BufferedWriter bw = null;
		try {
			File file = new File("C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			// Escribo la primer linea del archivo
			String contenidoLinea1 = "Usuario1;Tiempo1";
			bw.write(contenidoLinea1);
			bw.newLine();

			// Escribo la segunda linea del archivo
			String contenidoLinea2 = "Usuario2;Tiempo2";
			bw.write(contenidoLinea2);
			bw.newLine();
			
			Iterator<Libro> l = lista.iterator();
	        while(l.hasNext()){
	             String nombreLibro = l.next().getTitulo();
	             bw.write(nombreLibro);
	     		 bw.newLine();
	        	}
	                  
	     	} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public List<Libro> getListaLibros(TreeNode n, String genero) {
		List<Libro> aux = new LinkedList<Libro>();
		if (n.getGenero().compareTo(genero) == 0) {
			aux.addAll(n.getLibros()) ;
		} else {
			if ((n.getGenero().compareTo(genero) > 0) && (n.getLeft() != null)){
				aux.addAll(getListaLibros(n.getLeft(), genero)) ;
			}
			if ((n.getGenero().compareTo(genero) < 0) && (n.getRight() != null)){
				aux.addAll(getListaLibros(n.getRight(), genero));
			}
		}
		return aux ;
	}
		
}
