package br.com.concessionaria.unidade;
import br.com.concessionaria.domain.entity.*;
import br.com.concessionaria.repository.RepositorioVendas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

public class RepositorioVendasTestOld {
    @Mock
    private RepositorioVendas repositorio;
    private Venda venda1;
    private Venda venda2;
    private Venda venda3;

    private Cliente cliente4;

    @BeforeEach
    public void setUp() {
        repositorio = new RepositorioVendas();

        Endereco endereco = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG",
                "Contagem" );

        Cliente cliente1 = new Cliente(34, "Joao", "(31)4002-8922", endereco, "12345678901");
        Cliente cliente2 = new Cliente(53, "Maria", "(31)4002-8922", endereco, "23456789012");
        Cliente cliente3 = new Cliente(53, "José", "(31)4002-8922", endereco, "34567890123");
        cliente4 = new Cliente(53, "José", "(31)4002-8922", endereco, "000.654.000-00");

        Carro carro1 = new Carro(
                1, 12345, "ABC1234", "Carro1", 200, BigDecimal.valueOf(2.0),
                Boolean.TRUE, 16, MarcasCarro.Toyota, 2023, LocalDate.now(),
                BigDecimal.valueOf(20000), BigDecimal.valueOf(18000));

        Moto moto1 = new Moto(
                2, 67890, "DEF5678", "Moto1", 500, 17,
                MarcasMoto.Yamaha, 2023, LocalDate.now(), BigDecimal.valueOf(15000),
                BigDecimal.valueOf(12000));

        venda1 = new Venda(1, LocalDate.of(2023, 5, 1), BigDecimal.valueOf(50000),
                carro1, cliente1,
                MetodoDePagamento.CARTAO_DE_CREDITO, 12);

        venda2 = new Venda(2, LocalDate.of(2023, 5, 2), BigDecimal.valueOf(60000),
                moto1, cliente2,
                MetodoDePagamento.DINHEIRO, 1);

        venda3 = new Venda(3, LocalDate.of(2023, 5, 3), BigDecimal.valueOf(70000),
                carro1, cliente3,
                MetodoDePagamento.CARTAO_DE_DEBITO, 6);

        repositorio.adicionarVenda(venda1);
        repositorio.adicionarVenda(venda2);
        repositorio.adicionarVenda(venda3);
    }


    @Test
    public void testAdicionarVenda() {
        Carro carro2 = new Carro(
                4, 98765, "GHI9012", "Carro2", 300, BigDecimal.valueOf(3.0),
                Boolean.FALSE, 18, MarcasCarro.Ford, 2023, LocalDate.now(),
                BigDecimal.valueOf(25000), BigDecimal.valueOf(22000));

        Venda venda4 = new Venda(4, LocalDate.of(2023, 5, 4), BigDecimal.valueOf(80000),
                carro2, cliente4,
                MetodoDePagamento.CARTAO_DE_CREDITO, 3);

        repositorio.adicionarVenda(venda4);

        List<Venda> vendas = repositorio.getAll();
        assertTrue(vendas.contains(venda4));
    }

    @Test
    public void testRemoverVenda() {
        repositorio.removerVenda(venda2);

        List<Venda> vendas = repositorio.getAll();
        assertFalse(vendas.contains(venda2));
    }

    @Test
    public void testGetAll() {
        List<Venda> vendas = repositorio.getAll();
        assertEquals(3, vendas.size());
        assertTrue(vendas.contains(venda1));
        assertTrue(vendas.contains(venda2));
        assertTrue(vendas.contains(venda3));
    }

    @Test
    public void testGetVendasPorCliente() {
        List<Venda> vendasCliente1 = repositorio.getVendasPorCliente("12345678901");
        List<Venda> vendasCliente2 = repositorio.getVendasPorCliente("23456789012");
        List<Venda> vendasCliente3 = repositorio.getVendasPorCliente("34567890123");

        assertEquals(1, vendasCliente1.size());
        assertEquals(1, vendasCliente2.size());
        assertEquals(1, vendasCliente3.size());
        assertTrue(vendasCliente1.contains(venda1));
        assertTrue(vendasCliente2.contains(venda2));
        assertTrue(vendasCliente3.contains(venda3));
    }

    @Test
    public void testGetVendasPorVeiculo() {
        List<Venda> vendasModelo1 = repositorio.getVendasPorVeiculo("Modelo1");
        List<Venda> vendasModelo2 = repositorio.getVendasPorVeiculo("Modelo2");
        List<Venda> vendasModelo3 = repositorio.getVendasPorVeiculo("Modelo3");

        assertEquals(1, vendasModelo1.size());
        assertEquals(1, vendasModelo2.size());
        assertEquals(1, vendasModelo3.size());
        assertTrue(vendasModelo1.contains(venda1));
        assertTrue(vendasModelo2.contains(venda2));
        assertTrue(vendasModelo3.contains(venda3));
    }

    @Test
    public void testObterTotalVendasPorPeriodo() {
        BigDecimal totalVendas = repositorio.obterTotalVendasPorPeriodo(
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5, 3));

        assertEquals(BigDecimal.valueOf(180000), totalVendas);
    }

    @Test
    public void testGetVendasAcimaValorPorPeriodoEModelo() {
        List<Venda> vendasAcimaValor = repositorio.getVendasAcimaValorPorPeriodoEModelo(
                BigDecimal.valueOf(60000),
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5, 3),
                "Modelo3");

        assertEquals(1, vendasAcimaValor.size());
        assertTrue(vendasAcimaValor.contains(venda3));
    }

    @Test
    public void testGetVendaPorId() {
        Optional<Venda> vendaOptional = repositorio.getVendaPorId(2);

        assertTrue(vendaOptional.isPresent());
        assertEquals(venda2, vendaOptional.get());
    }

    @Test
    public void testGetProximoId() {
        int proximoId = repositorio.getProximoId();

        assertEquals(4, proximoId);
    }
}