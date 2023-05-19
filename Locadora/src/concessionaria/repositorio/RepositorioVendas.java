package concessionaria.repositorio;

import java.util.ArrayList;
import java.util.List;

import concessionaria.classes.Venda;

import java.math.BigDecimal;

public class RepositorioVendas {
    private List<Venda> vendas;

    public RepositorioVendas() {
        this.vendas = new ArrayList<>();
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }
    
    public List<Venda> getVendasPorCliente(String cpf) {
	    ArrayList<Venda> vendas = new ArrayList<>();
	    for (Venda venda : this.vendas) {
	        if (venda.getClienteVenda().getCpf().equals(cpf)) {
	            vendas.add(venda);
	        }
	    }
	    return vendas;
	}
    
    public List<Venda> getVendasPorVeiculo(String nomeModelo) {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (Venda venda : this.vendas) {
            if (venda.getVeiculoVendido().getModelo().equals(nomeModelo)) {
                vendas.add(venda);
            }
        }
        return vendas;
    }

}

