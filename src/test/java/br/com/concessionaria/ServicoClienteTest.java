package br.com.concessionaria;
import br.com.concessionaria.domain.dto.RequisicaoNovoCliente;
import br.com.concessionaria.domain.entity.Cliente;
import br.com.concessionaria.domain.entity.Endereco;
import br.com.concessionaria.service.ServicoCliente;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class ServicoClienteTest {

    @Before
    public void setUp(){
        ServicoCliente servicoTest = new ServicoCliente();
        Endereco endereco = new Endereco("Rua A", 10, "Federal", "12.345-678", "MG",
                "Contagem" );
        Cliente clienteTeste = new Cliente(12,"Elon", "(31)40028922", endereco, "123.456.789-10");
        repositorioClientes.adicionarCliente(clienteTeste);
        RequisicaoNovoCliente novoCliente;
    }

    @Test
    public void testBuscarPorId(){
        int id = clienteTeste.getId();
        Cliente clienteRetornado = servicoTest.buscarPorId(id);
        assertEquals(clienteRetornado, clienteTeste);
    }

    @Test
    public void testAdicionarCliente(){
        Endereco enderecoTest = new Endereco("Rua B", 20, "Centro", "98.765-432", "SP", "São Paulo");
        Cliente clienteTesteAdicao = new Cliente(13,"Bill", "(31)40028922", enderecoTest, "000.000.001-10");

    }
}
