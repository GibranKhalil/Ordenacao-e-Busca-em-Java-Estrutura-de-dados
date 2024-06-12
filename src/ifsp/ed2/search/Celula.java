package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class Celula {
	
	private Customer elemento;
	private Celula proximo;
	private Celula anterior;
	
	
	public Celula(Customer elemento) {
		this(elemento, null);
	}
	
	public Celula(Customer elemento, Celula proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Customer getElemento() {
		return (Customer) elemento;
	}

	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
	public Celula getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}

}
