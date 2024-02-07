package entities;

import java.util.HashMap;
import java.util.Map;

public class Despesas {

	Map<String, Double> produtos = new HashMap<>();

	public Despesas() {
	    
	}

	public void adicionarProduto(String nomeProduto, Double valorProduto) {
		produtos.put(nomeProduto, valorProduto);
	}

	public double totalDespesas() {
		double total = 0.0;

		// Adiciona o valor de cada produto ao total
		for (Double valorProduto : produtos.values()) {
			total += valorProduto;
		}

		return total;
	}

	
}
