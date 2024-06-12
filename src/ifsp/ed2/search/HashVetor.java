package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class HashVetor {

	private int tamanho;
	private TabelaHash tabelaHash;

	public HashVetor(int tamanho) {

		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido.");
		}
		this.tamanho = tamanho;
		tabelaHash = new TabelaHash(tamanho);
	}

	private int calcularHash(int chave) {

		String chaveConvertida = String.valueOf(chave);
		int h = 0;
		for (int i = 0; i < chaveConvertida.length(); i++) {
			h = 31 * h + chaveConvertida.charAt(i);
		}
		return h % tamanho;
	}

	public int adicionar(Customer novoCliente) {

		int enderecoAdicionado = calcularHash(novoCliente.getId());

		if (tabelaHash.getElementos()[enderecoAdicionado] != null) {
			tabelaHash.getElementos()[enderecoAdicionado].adicionarNoFinal(novoCliente);
		} else {
			tabelaHash.getElementos()[enderecoAdicionado].adicionarNoComeco(novoCliente);
		}

		return enderecoAdicionado;

	}

	public int buscarClienteCodigo(int codigoBuscado) {

		int enderecoBuscado = calcularHash(codigoBuscado);

		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			if (tabelaHash.getElementos()[enderecoBuscado].contem(codigoBuscado)) {
				return tabelaHash.getElementos()[enderecoBuscado].contemCliente(codigoBuscado);
			}
		}
			return 0;
	}
	public boolean contem(int codigoBuscado){
		int enderecoBuscado = calcularHash(codigoBuscado);
		if (tabelaHash.getElementos()[enderecoBuscado] != null){
			if (tabelaHash.getElementos()[enderecoBuscado].contem(codigoBuscado)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
