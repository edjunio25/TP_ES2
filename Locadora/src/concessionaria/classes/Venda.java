package concessionaria.classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private String dataDaCompra;
    private BigDecimal precoDeVenda;
    private Veiculo veiculoVendido;
    private Cliente clienteVenda;
    private MetodoDePagamento metodoPagamento;
    private int numParcelas;

    public Venda(String dataDaCompra, BigDecimal precoDeVenda, Veiculo veiculoVendido, Cliente clienteVenda,
			MetodoDePagamento metodoPagamento,int numParcelas) {
		this.dataDaCompra = dataDaCompra;
		this.precoDeVenda = precoDeVenda;
		this.veiculoVendido = veiculoVendido;
		this.clienteVenda = clienteVenda;
		this.metodoPagamento = metodoPagamento;
		this.numParcelas = numParcelas;
	}

	public int getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public MetodoDePagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoDePagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public BigDecimal getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(BigDecimal precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Veiculo getVeiculoVendido() {
        return veiculoVendido;
    }

    public void setVeiculoVendido(Veiculo veiculoComprado) {
        this.veiculoVendido = veiculoComprado;
    }

    public Cliente getClienteVenda() {
        return clienteVenda;
    }

    public void setClienteVenda(Cliente clienteCompra) {
        this.clienteVenda = clienteCompra;
    }
    

}