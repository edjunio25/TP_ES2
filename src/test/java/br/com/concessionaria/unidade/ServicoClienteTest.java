package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.dto.RequisicaoNovoCliente;
import br.com.concessionaria.domain.entity.Cliente;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.exception.ClienteNaoEncontradoException;
import br.com.concessionaria.exception.*;
import br.com.concessionaria.repository.RepositorioClientes;
import br.com.concessionaria.service.ServicoCliente;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicoClienteTest {

    @Mock
    private RepositorioClientes repositorioClientes;

    @InjectMocks
    private ServicoCliente servicoCliente;

    private Endereco endereco;
    private RequisicaoNovoCliente novoCliente;
    private Cliente clientePresente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        endereco = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG", "Contagem");
        novoCliente = mock(RequisicaoNovoCliente.class);
        when(novoCliente.getNome()).thenReturn("Elon");
        when(novoCliente.getTelefone()).thenReturn("(31)40028922");
        when(novoCliente.getEndereco()).thenReturn(endereco);
        when(novoCliente.getCpf()).thenReturn("12345678910");

        clientePresente = new Cliente(12, novoCliente.getNome(), novoCliente.getTelefone(),
                endereco, novoCliente.getCpf());
    }

    @Test
    public void testAdicionarCliente_ClienteNovo() {

        Cliente clienteAdicionado = new Cliente(13, novoCliente.getNome(), novoCliente.getTelefone(),
                endereco, novoCliente.getCpf());

        int proximoId = 13;

        when(repositorioClientes.getProximoId()).thenReturn(proximoId);
        when(repositorioClientes.getClientePorCpf(novoCliente.getCpf())).thenReturn(Optional.empty());
        when(repositorioClientes.getProximoId()).thenReturn(proximoId);

        doNothing().when(repositorioClientes).adicionarCliente(any(Cliente.class));
        Cliente cliente = servicoCliente.adicionarCliente(novoCliente);

        when(repositorioClientes.getAll()).thenReturn(List.of(clienteAdicionado));

        verify(repositorioClientes).adicionarCliente(clienteAdicionado);

        Assertions.assertEquals(clienteAdicionado, cliente);


    }

    @Test
    public void testAdicionarCliente_ClienteComCPFRepetidoLancaExcecao() {
        when(repositorioClientes.getClientePorCpf(novoCliente.getCpf())).thenReturn(Optional.of(clientePresente));
        var excecaoLancada = assertThrows(ClienteInvalidoException.class, () ->
                servicoCliente.adicionarCliente(novoCliente));

        assertEquals("CPF duplicado", excecaoLancada.getMessage());
    }

    @Test
    public void testBuscarPorId_ClientePresente() {

        when(repositorioClientes.getClientePorId(12)).thenReturn(Optional.of(clientePresente));

        Cliente cliente = servicoCliente.buscarPorId(12);

            Assertions.assertEquals(clientePresente, cliente);
    }

    @Test
    public void testBuscarPorId_ClienteNaoEncontrado() {
        when(repositorioClientes.getClientePorId(11)).thenReturn(Optional.empty());

        Assertions.assertThrows(ClienteNaoEncontradoException.class, () ->
            servicoCliente.buscarPorId(11));
    }

    @Test
    public void testDeletarCliente_ClienteExistente() {
        Cliente clienteExistente = new Cliente(1, "Anderson", "123456789", endereco, "56987548596");

        when(repositorioClientes.getClientePorId(1)).thenReturn(Optional.of(clienteExistente));
        doNothing().when(repositorioClientes).removerCliente(clienteExistente);

        servicoCliente.deletarCliente(1);
        verify(repositorioClientes).removerCliente(clienteExistente);
    }

    @Test
    public void testDeletarCliente_ClienteNaoEncontrado() {
        when(repositorioClientes.getClientePorId(11)).thenReturn(Optional.empty());

        Assertions.assertThrows(ClienteNaoEncontradoException.class, () ->
                servicoCliente.deletarCliente(11));

        verify(repositorioClientes, never()).removerCliente(any(Cliente.class));
    }

    @Test
    public void testGetClientes() {
        Cliente cliente1 = new Cliente(1, "Anderson", "123456789", endereco, "56987548596");
        Cliente cliente2 = new Cliente(2, "Luana", "924456789", endereco, "18924548596");
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2));

        when(repositorioClientes.getAll()).thenReturn(clientes);

        List<Cliente> result = servicoCliente.getClientes();

        Assertions.assertEquals(clientes, result);
    }
}
