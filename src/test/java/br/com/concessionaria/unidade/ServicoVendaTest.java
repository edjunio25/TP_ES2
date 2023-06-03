package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.entity.*;
import br.com.concessionaria.repository.RepositorioVendas;
import br.com.concessionaria.service.*;
import br.com.concessionaria.domain.dto.RequisicaoNovaVenda;
import br.com.concessionaria.exception.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServicoVendaTest {

    @Mock
    private RepositorioVendas repositorioVendas;

    @Mock
    private ServicoVeiculo servicoVeiculo;

    @Mock
    private ServicoCliente servicoCliente;

    @InjectMocks
    private ServicoVenda servicoVenda;
    @InjectMocks
    private RequisicaoNovaVenda requisicaoNovaVenda;
    private Cliente cliente;
    private Carro carro;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = new Cliente(10, "João", "123456789", null, null);
        carro = new Carro(12, 123, "abc1234", "Cruze", 180,
                BigDecimal.valueOf(1000), true, 16, MarcasCarro.Chevrolet, 2020,
                LocalDate.parse("2020-06-02"), BigDecimal.valueOf(68000), BigDecimal.valueOf(85000));

        requisicaoNovaVenda = mock(RequisicaoNovaVenda.class);
        when(requisicaoNovaVenda.getIdCliente()).thenReturn(10);
        when(requisicaoNovaVenda.getIdVeiculo()).thenReturn(12);
        when(requisicaoNovaVenda.getDataDaVenda()).thenReturn(LocalDate.now());
        when(requisicaoNovaVenda.getPrecoDeVenda()).thenReturn(BigDecimal.valueOf(10000));
        when(requisicaoNovaVenda.getMetodoDePagamento()).thenReturn(MetodoDePagamento.CARTAO_DE_DEBITO);
        when(requisicaoNovaVenda.getNumParcelas()).thenReturn(1);

        when(servicoCliente.buscarPorId(1)).thenReturn(cliente);
        when(servicoVeiculo.buscarVeiculoPorId(1)).thenReturn(carro);
    }

    @Test
    public void testAdicionarVenda() {
        Venda vendaAdicionada = new Venda(4, requisicaoNovaVenda.getDataDaVenda(),
                requisicaoNovaVenda.getPrecoDeVenda(), carro, cliente, requisicaoNovaVenda.getMetodoDePagamento(),
                requisicaoNovaVenda.getNumParcelas());

        //when(servicoCliente.buscarPorId(anyInt())).thenThrow(ClienteNaoEncontradoException.class);
        //when(servicoVeiculo.buscarVeiculoPorId(anyInt())).thenThrow(ClienteNaoEncontradoException.class);

        when(repositorioVendas.getProximoId()).thenReturn(4);

        when(servicoCliente.buscarPorId(anyInt())).thenReturn(cliente);

        when(servicoVeiculo.buscarVeiculoPorId(anyInt())).thenReturn(carro);

        doNothing().when(repositorioVendas).adicionarVenda(any(Venda.class));

        Venda venda = servicoVenda.adicionarVenda(requisicaoNovaVenda);

        //Assertions.assertEquals(vendaAdicionada, venda);
        Assertions.assertEquals(vendaAdicionada.getId(), venda.getId());
        Assertions.assertEquals(vendaAdicionada.getDataDaCompra(), venda.getDataDaCompra());
        Assertions.assertEquals(vendaAdicionada.getPrecoDeVenda(), venda.getPrecoDeVenda());
        //System.out.println("Placa do veículo adicionado: " + vendaAdicionada.getVeiculoVendido().getPlaca());
        //System.out.println("Placa do veículo da venda: " + venda.getVeiculoVendido().getPlaca());

        Assertions.assertEquals(vendaAdicionada.getVeiculoVendido().getPlaca(), venda.getVeiculoVendido().getPlaca());
        Assertions.assertEquals(vendaAdicionada.getClienteVenda(), venda.getClienteVenda());
        Assertions.assertEquals(vendaAdicionada.getMetodoPagamento(), venda.getMetodoPagamento());
        Assertions.assertEquals(vendaAdicionada.getNumParcelas(), venda.getNumParcelas());

        verify(repositorioVendas, times(1)).adicionarVenda(any(Venda.class));

    }

    @Test
    public void testGetVendas() {
        List<Venda> vendas = new ArrayList<>();
        when(repositorioVendas.getAll()).thenReturn(vendas);

        List<Venda> result = servicoVenda.getVendas();

        Assertions.assertEquals(vendas, result);
    }

    @Test
    public void testBuscarVendasPorCliente() {
        List<Venda> vendas = new ArrayList<>();
        when(repositorioVendas.getVendasPorCliente(anyString())).thenReturn(vendas);

        List<Venda> result = servicoVenda.buscarVendasPorCliente("123456789");

        Assertions.assertEquals(vendas, result);
    }

    @Test
    public void testBuscarVendasPorVeiculo() {
        List<Venda> vendas = new ArrayList<>();
        when(repositorioVendas.getVendasPorVeiculo(anyString())).thenReturn(vendas);

        List<Venda> result = servicoVenda.buscarVendasPorVeiculo("Modelo");

        Assertions.assertEquals(vendas, result);
    }

    @Test
    public void testObterTotalVendasPorPeriodo() {
        BigDecimal totalVendas = BigDecimal.valueOf(5000);
        when(repositorioVendas.obterTotalVendasPorPeriodo(any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(totalVendas);

        BigDecimal result = servicoVenda.obterTotalVendasPorPeriodo(LocalDate.now(), LocalDate.now());

        Assertions.assertEquals(totalVendas, result);
    }

    @Test
    public void testBuscarVendasAcimaValorPorPeriodoEModelo() {
        List<Venda> vendas = new ArrayList<>();
        when(repositorioVendas.getVendasAcimaValorPorPeriodoEModelo(any(BigDecimal.class), any(LocalDate.class),
                any(LocalDate.class), anyString())).thenReturn(vendas);

        List<Venda> result = servicoVenda.buscarVendasAcimaValorPorPeriodoEModelo(BigDecimal.ZERO, LocalDate.now(),
                LocalDate.now(), "Modelo");

        Assertions.assertEquals(vendas, result);
    }

    @Test
    public void testDeletarVenda() {
        Venda venda = new Venda(1, null, null, null, null, null, 0);
        when(repositorioVendas.getVendaPorId(anyInt())).thenReturn(java.util.Optional.of(venda));

        servicoVenda.deletarVenda(1);
        verify(repositorioVendas).removerVenda(venda);
    }

    @Test
    public void testDeletarVenda_VendaNaoEncontrada() {
        when(repositorioVendas.getVendaPorId(anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(VendaNaoEncontradaException.class, () ->
            servicoVenda.deletarVenda(12));
    }
}
