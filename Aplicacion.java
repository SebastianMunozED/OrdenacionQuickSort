package epn.com;

import java.util.Random;

public class Aplicacion {
	public static void quickSort(int[] vector, int izquierda, int derecha) {
	    //1. Elegir el pivote
	    int pivote = vector[izquierda];
	    //2. Los elementos > al pivote van a su derecha, los < a su izquierda
	    //esta parte de la implementación es el corazón del ordenamiento
	    //se utilizan variables auxiliares:
	    //- i para controlar los elementos a la izquierda del pivote
	    //- j para controlar los elementos a la derecha del pivote
	    int i = izquierda;
	    int j = derecha;
	    //esta variable debería tener un alcance menor pero se respeta la implementación
	    int auxIntercambio;
	    //mientras que deban evaluarse los elementos en el arreglo
	    //para ubicar al nuevo pivote
	    while (i < j) {
	        //mientras que el elemento vector[i] sea menor o igual al pivote
	        //se aumenta el valor de i
	        //cuando este loop se detenga, el elemento en vector[i]
	        //es mayor a pivote y deberá ir a su derecha
	        while (vector[i] <= pivote && i < j) {
	            i++;
	        }
	        //mientras que el elemento vector[j] sea menor o igual al pivote
	        //se desminuye el valor de j
	        //cuando este loop se detenga, el elemento en vector[j]
	        //es menor o igual a pivote y deberá ir a su izquierda
	        while (vector[j] > pivote) {
	            j--;
	        }
	        //siempre y cuando i sea menor a j, se hace un cambio de los elementos
	        //puesto que el elemento en vector[i] debe ir a la derecha
	        //y vector[j] a la izquierda
	        if (i < j) {
	            auxIntercambio = vector[i];
	            vector[i] = vector[j];
	            vector[j] = auxIntercambio;
	        }
	    }
	    //si j es menor a i, entonces se utilizará j como la nueva ubicación
	    //del pivote
	    //en este caso, la ubicación del pivote es vector[izquierda] tal como
	    //se encuentra al comienzo de la implementación
	    vector[izquierda] = vector[j];
	    vector[j] = pivote;
	    //3. Para A1 y A2, aplicar el mismo proceso.
	    if (izquierda < j - 1) {
	        //quicksort aplicado a A1
	        quickSort(vector, izquierda, j - 1);
	    }
	    if (j + 1 < derecha) {
	        //quicksort aplicado a A2
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