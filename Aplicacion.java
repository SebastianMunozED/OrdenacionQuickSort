package epn.com;

import java.util.Random;

public class Aplicacion {
	public static void quickSort(int[] vector, int izquierda, int derecha) {
	  
	    int pivote = vector[izquierda];
	    int i = izquierda;
	    int j = derecha;
	    int auxIntercambio;
	    while (i < j) {
	       
	        while (vector[i] <= pivote && i < j) {
	            i++;
	        }
	       
	        while (vector[j] > pivote) {
	            j--;
	        }
	       
	        if (i < j) {
	            auxIntercambio = vector[i];
	            vector[i] = vector[j];
	            vector[j] = auxIntercambio;
	        }
	    }
	    
	    vector[izquierda] = vector[j];
	    vector[j] = pivote;
	   
	    if (izquierda < j - 1) {
	        
	        quickSort(vector, izquierda, j - 1);
	    }
	    if (j + 1 < derecha) {
	      
	        quickSort(vector, j + 1, derecha);
	    }
	}

    public static void main(String[] args) {
        int[] numeros = new int[7];
        Random rnd = new Random();
        System.out.println("Vector desordenado");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rnd.nextInt(10);
            System.out.print(numeros[i] + " ");
        }   
        
        Aplicacion.quickSort(numeros, 0, numeros.length - 1);
        System.out.println("\nVector Ordenado");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

    }
}
