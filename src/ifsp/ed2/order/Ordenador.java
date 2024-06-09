package ifsp.ed2.order;

import ifsp.ed2.model.Customer;

public class Ordenador {

	static int MIN_MERGE = 32;
	
	public static void insertionSort(Customer[] pessoas, int left, int right) { 
	    for (int i = left + 1; i <= right; i++) { 
	        Customer temp = pessoas[i]; 
	        int j = i - 1; 
	        while (j >= left && pessoas[j].getId() > temp.getId()) { 
	            pessoas[j + 1] = pessoas[j]; 
	            j--; 
	        } 
	        pessoas[j + 1] = temp; 
	    } 
	}

	private static int minRunLength(int tamanhoSegmento) {
	    if (tamanhoSegmento < 0) {
	        throw new IllegalArgumentException("O valor de 'n' não pode ser negativo.");
	    }
	    if (tamanhoSegmento >= MIN_MERGE) {
	        return tamanhoSegmento;
	    } else {
	        return tamanhoSegmento + 1;
	    }
	}

	private static void merge(Customer[] pessoas, int primeiro, int meio, int ultimo) {

    int tamanho1 = meio - primeiro + 1;

    Customer[] left = new Customer[tamanho1];

    for (int i = 0; i < tamanho1; i++) {
        left[i] = pessoas[primeiro + i];
    }

    int i = 0, j = meio + 1;
    
    int k = primeiro;

    while (i < tamanho1 && j <= ultimo) {
        if (left[i].getId() <= pessoas[j].getId()) {
            pessoas[k] = left[i];
            i++;
        } else {
            pessoas[k] = pessoas[j];
            j++;
        }
        k++;
    }

    while (i < tamanho1) {
        pessoas[k] = left[i];
        i++;
        k++;
    }

}
	
	public static void timSort(Customer[] pessoas, int tamanhoArray) {
		int minRun = minRunLength(MIN_MERGE);

		// Ordena subarrays individuais de tamanho RUN
		for (int i = 0; i < tamanhoArray; i += minRun) {
			insertionSort(pessoas, i,  Math.min((i + MIN_MERGE - 1), (tamanhoArray - 1)));
		}

		// Mescla os subarrays ordenados
		for (int tamanho = minRun; tamanho < tamanhoArray; tamanho *= 2) {
		    for (int esquerda = 0; esquerda < tamanhoArray; esquerda += 2 * tamanho) {
		        int meio = esquerda + tamanho - 1;
		        int direita = Math.min(esquerda + 2 * tamanho - 1, tamanhoArray - 1);
		        if (meio < direita) {
		            merge(pessoas, esquerda, meio, direita);
		        }
		    }
		}
	}


	public static void bubbleSort(Customer[] customers, int quantidadeElementos) {

		for (int i = 0; i < quantidadeElementos - 1; i++) {
			for (int j = 0; j < quantidadeElementos - 1 - i; j++) {
				if (customers[j].getId() > customers[j + 1].getId()) {
					trocar(customers, j, j + 1);
				}
			}
		}
	}

	public static void quickSort(Customer[] pessoas, int de, int ate) {

		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(pessoas, de, ate);
			quickSort(pessoas, de, posicaoDoPivo);
			quickSort(pessoas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(Customer[] pessoas, int inicial, int termino) {

		int menoresEncontrados = inicial;
		Customer pivo = pessoas[termino - 1];

		for (int analisando = inicial; analisando < termino - 1; analisando++) {
			Customer atual = pessoas[analisando];
			if (atual.getId() <= pivo.getId()) {
				trocar(pessoas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		trocar(pessoas, termino - 1, menoresEncontrados);
		return menoresEncontrados;
	}

	private static void trocar(Customer[] customers, int posicaoPrimeiro, int posicaoSegundo) {

		Customer primeiro = customers[posicaoPrimeiro];
		Customer segundo = customers[posicaoSegundo];
		customers[posicaoPrimeiro] = segundo;
		customers[posicaoSegundo] = primeiro;
	}
	
	}
