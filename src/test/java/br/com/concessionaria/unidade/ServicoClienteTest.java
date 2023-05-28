package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.dto.RequisicaoNovoCliente;
import br.com.concessionaria.domain.entity.Cliente;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.repository.RepositorioClientes;
import br.com.concessionaria.service.ServicoCliente;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class ServicoClienteTest {

    ServicoCliente servicoTest;
    Cliente clienteTeste;

    RequisicaoNovoCliente novoCliente;

    @BeforeEach
    public void setUp(){
        servicoTest = new ServicoCliente();
        Endereco endereco = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG",
                "Contagem" );
        clienteTeste = new Cliente(12,"Elon", "(31)40028922", endereco, "123.456.789-10");
        servicoTest.adicionarCliente(clienteTeste);
        RequisicaoNovoCliente novoCliente;
    }

    @Test
    public void testBuscarPorId(){
        int id = clienteTeste.getId();
        Cliente clienteRetornado = servicoTest.buscarPorId(id);
        Assertions.assertEquals(clienteRetornado, clienteTeste);
    }

    @Test
    public void testAdicionarCliente(){
        Endereco enderecoTest = new Endereco("Rua B", 20, "Centro", "98.765-432", "SP", "São Paulo");
        Cliente clienteTesteAdicao = new Cliente(13,"Bill", "(31)40028922", enderecoTest, "000.000.001-10");

    }
}