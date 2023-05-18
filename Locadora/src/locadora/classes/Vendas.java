package locadora.classes;

import java.util.ArrayList;
import java.math.BigDecimal;

public class Vendas {
    private ArrayList<Venda> vendas;

    public Vendas() {
        this.vendas = new ArrayList<>();
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    
    public ArrayList<Venda> getVendasPorCliente(String cpf) {
	    ArrayList<Venda> vendas = new ArrayList<>();
	    for (Venda venda : this.vendas) {
	        if (venda.getClienteVenda().getCpf().equals(cpf)) {
	            vendas.add(venda);
	        }
	    }
	    return vendas;
	}
    
    public ArrayList<Venda> getVendasPorVeiculo(String nomeModelo) {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (Venda venda : this.vendas) {
            if (venda.getVeiculoVendido().getModelo().equals(nomeModelo)) {
                vendas.add(venda);
            }
        }
        return vendas;
    }

}

