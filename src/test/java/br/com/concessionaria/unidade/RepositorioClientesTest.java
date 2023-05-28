package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.dto.RequisicaoNovoCliente;
import br.com.concessionaria.domain.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.service.ServicoCliente;
import br.com.concessionaria.repository.RepositorioClientes;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
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
        Cliente cliente1 = new Cliente(1, "Joao", "(31)4002-8922", endereco1, "12345678910");
        Cliente cliente2 = new Cliente(2, "Maria", "(31)4002-8922", endereco2, "98765443210");
        repositorio.adicionarCliente(cliente1);
        repositorio.adicionarCliente(cliente2);
    }

    @Test
    public void testAdicionarCliente() {
        Endereco endereco3 = new Endereco("Rua C", 13, "Municipal", "98.765-432", "MG",
                "Contagem" );
        Cliente novoCliente = new Cliente(3, "Novo Cliente", "(31)4002-8922", endereco3, "11122233344");
        repositorio.adicionarCliente(novoCliente);
        List<Cliente> clientes = repositorio.getAll();
        Assertions.assertTrue(clientes.contains(novoCliente));
    }

    @Test
    public void testRemoverCliente() {
        Optional<Cliente> cliente = repositorio.getClientePorId(1);
        Assertions.assertTrue(cliente.isPresent());
        repositorio.removerCliente(cliente.get());
        List<Cliente> clientes = repositorio.getAll();
        Assertions.assertFalse(clientes.contains(cliente.get()));
    }

    @Test
    public void testGetClientePorId() {
        Optional<Cliente> cliente = repositorio.getClientePorId(1);
        Assertions.assertTrue(cliente.isPresent());
        Assertions.assertEquals(1, cliente.get().getId());
    }

    @Test
    public void testGetClientePorCpf() {
        Optional<Cliente> cliente = repositorio.getClientePorCpf("123456789");
        Assertions.assertTrue(cliente.isPresent());
        Assertions.assertEquals("123456789", cliente.get().getCpf());
    }

    @Test
    public void testGetProximoId() {
        int proximoId = repositorio.getProximoId();
        Assertions.assertEquals(3, proximoId);
    }
}


