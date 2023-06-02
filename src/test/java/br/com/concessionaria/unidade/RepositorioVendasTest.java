package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.entity.Cliente;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.domain.entity.*;
import br.com.concessionaria.domain.entity.Venda;
import br.com.concessionaria.repository.RepositorioVendas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RepositorioVendasTest {

    private RepositorioVendas repositorioVendasTest;
    private Endereco endereco;
    private Cliente cliente;
    private Venda venda, venda2;
    private Carro carro, carro2;

    @BeforeEach
    public void setup() {
        repositorioVendasTest = new RepositorioVendas();

        endereco = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG",
                "Contagem" );
        cliente = new Cliente(34, "Joao", "(31)4002-8922", endereco, "12345678901");
        carro = new Carro(
                1, 12345, "ABC1234", "Carro1", 200, BigDecimal.valueOf(2.0),
                Boolean.TRUE, 16, MarcasCarro.Toyota, 2023, LocalDate.of(2023, 1, 2),
                BigDecimal.valueOf(20000), BigDecimal.valueOf(18000));
        venda = new Venda(1, LocalDate.of(2023, 1, 5), BigDecimal.valueOf(50000),
                carro, cliente,
                MetodoDePagamento.CARTAO_DE_CREDITO, 12);
        carro2 = new Carro(
                2, 12347, "ABC1233", "Carro2", 200, BigDecimal.valueOf(2.0),
                Boolean.TRUE, 16, MarcasCarro.Toyota, 2023, LocalDate.of(2022, 12, 6),
                BigDecimal.valueOf(20000), BigDecimal.valueOf(18000));
        venda2 = new Venda(2, LocalDate.of(2023, 5, 2), BigDecimal.valueOf(360089),
                carro2, cliente,
                MetodoDePagamento.CARTAO_DE_CREDITO, 10);
    }

    @Test
    public void testAdicionarVenda() {

        repositorioVendasTest.adicionarVenda(venda);

        List<Venda> vendas = repositorioVendasTest.getAll();

        Assertions.assertTrue(vendas.contains(venda));
    }

    @Test
    public void testRemoverVenda() {

        repositorioVendasTest.adicionarVenda(venda);

        repositorioVendasTest.removerVenda(venda);

        List<Venda> vendas = repositorioVendasTest.getAll();

        Assertions.assertFalse(vendas.contains(venda));
    }

    @Test
    public void testGetAll() {

        repositorioVendasTest.adicionarVenda(venda);
        repositorioVendasTest.adicionarVenda(venda2);

        List<Venda> vendas = repositorioVendasTest.getAll();
        Assertions.assertEquals(2, vendas.size());
    }

    @Test
    public void testGetVendasPorCliente() {
        List<Venda> vendasCliente1 = repositorioVendasTest.getVendasPorCliente("12345678901");
        Assertions.assertEquals(2, vendasCliente1.size());
        List<Venda> vendasCliente2 = repositorioVendasTest.getVendasPorCliente("12345673334");
        //Assertions.assertEquals(0, vendasCliente2.size());
        Assertions.assertTrue(vendasCliente2.isEmpty());
        //Assertions.assertEquals("123456789", vendasCliente1.get(0).getClienteVenda().getCpf());
    }

    @Test
    public void testGetVendasPorVeiculo() {
        List<Venda> vendasModelo1 = repositorioVendasTest.getVendasPorVeiculo("Carro1");
        Assertions.assertEquals(1, vendasModelo1.size());
        Assertions.assertEquals("Carro1", vendasModelo1.get(0).getVeiculoVendido().getModelo());
    }

    @Test
    public void testObterTotalVendasPorPeriodo() {
        LocalDate dataInicio = LocalDate.of(2022, 1, 1);
        LocalDate dataFim = LocalDate.of(2022, 2, 2);

        BigDecimal totalVendas = repositorioVendasTest.obterTotalVendasPorPeriodo(dataInicio, dataFim);
        Assertions.assertEquals(BigDecimal.valueOf(68000), totalVendas);
    }

    @Test
    public void testGetVendasAcimaValorPorPeriodoEModelo() {
        BigDecimal valorMinimo = BigDecimal.valueOf(50000);
        LocalDate dataInicio = LocalDate.of(2022, 1, 1);
        LocalDate dataFim = LocalDate.of(2023, 2, 2);
        String nomeModelo = "Carro1";

        List<Venda> vendasEncontradas = repositorioVendasTest.getVendasAcimaValorPorPeriodoEModelo(valorMinimo, dataInicio, dataFim, nomeModelo);
        Assertions.assertEquals(1, vendasEncontradas.size());

        Venda vendaEncontrada = vendasEncontradas.get(0);
        Assertions.assertTrue(vendaEncontrada.getPrecoDeVenda().compareTo(valorMinimo) > 0);
        Assertions.assertTrue(vendaEncontrada.getDataDaCompra().isAfter(dataInicio) && vendaEncontrada.getDataDaCompra().isBefore(dataFim));
        Assertions.assertEquals(nomeModelo, vendaEncontrada.getVeiculoVendido().getModelo());
    }

    @Test
    public void testGetVendaPorId() {
        Optional<Venda> vendaOptional = repositorioVendasTest.getVendaPorId(1);
        Assertions.assertTrue(vendaOptional.isPresent());

        Venda vendaEncontrada = vendaOptional.get();
        Assertions.assertEquals(1, vendaEncontrada.getId());
    }

    @Test
    public void testGetProximoId() {
        int proximoId = repositorioVendasTest.getProximoId();
        Assertions.assertEquals(3, proximoId);
    }


}
