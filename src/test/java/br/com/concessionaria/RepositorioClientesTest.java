package br.com.concessionaria;
import br.com.concessionaria.domain.dto.RequisicaoNovoCliente;
import br.com.concessionaria.domain.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.service.ServicoCliente;
import br.com.concessionaria.repository.RepositorioClientes;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class RepositorioClientesTest {
    private RepositorioClientes repositorio;
    @Before
    public void setUp() {
        repositorio = new RepositorioClientes();
        Endereco endereco1 = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG",
                "Contagem" );
        Endereco endereco2 = new Endereco("Rua B", 12, "Estadual", "98.765-432", "MG",
                "Contagem" );
        Cliente cliente1 = new Cliente(1, "Joao", "(31)4002-8922", endereco1, "123.456.789-10");
        Cliente cliente2 = new Cliente(2, "Maria", "(31)4002-8922", endereco2, "987.654.432-10");
        repositorio.adicionarCliente(cliente1);
        repositorio.adicionarCliente(cliente2);
    }

    @Test
    public void testAdicionarCliente() {
        Endereco endereco3 = new Endereco("Rua C", 13, "Municipal", "98.765-432", "MG",
                "Contagem" );
        Cliente novoCliente = new Cliente(3, "Novo Cliente", "(31)4002-8922", endereco3, "111.222.333-44");
        repositorio.adicionarCliente(novoCliente);
        List<Cliente> clientes = repositorio.getAll();
        assertTrue(clientes.contains(novoCliente));
    }

    @Test
    public void testRemoverCliente() {
        Optional<Cliente> cliente = repositorio.getClientePorId(1);
        assertNotNull(cliente);
        repositorio.removerCliente(cliente);
        List<Cliente> clientes = repositorio.getAll();
        assertFalse(clientes.contains(cliente));
    }

    @Test
    public void testGetClientePorId() {
        Optional<Cliente> cliente = repositorio.getClientePorId(1);
        assertTrue(cliente.isPresent());
        assertEquals(1, cliente.get().getId());
    }

    @Test
    public void testGetClientePorCpf() {
        Optional<Cliente> cliente = repositorio.getClientePorCpf("123456789");
        assertTrue(cliente.isPresent());
        assertEquals("123456789", cliente.get().getCpf());
    }

    @Test
    public void testGetProximoId() {
        int proximoId = repositorio.getProximoId();
        assertEquals(3, proximoId);
    }
}

}
