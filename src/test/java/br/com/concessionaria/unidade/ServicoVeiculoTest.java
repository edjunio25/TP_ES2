package br.com.concessionaria.unidade;

import br.com.concessionaria.domain.entity.*;
import br.com.concessionaria.service.*;
import br.com.concessionaria.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicoVeiculoTest {

    private ServicoVeiculo servicoVeiculo;

    @BeforeEach
    void setUp() {
        servicoVeiculo = new ServicoVeiculo();
    }

    @Test
    void testGetVeiculos() {
        List<Veiculo> veiculos = servicoVeiculo.getVeiculos();
        assertNotNull(veiculos);
        assertFalse(veiculos.isEmpty());
    }

    @Test
    void testBuscarVeiculoPorChassi() {
        int chassiExistente = 123;
        int chassiNaoExistente = 999;

        Veiculo veiculoExistente = servicoVeiculo.buscarVeiculoPorChassi(chassiExistente);
        assertNotNull(veiculoExistente);

        assertThrows(VeiculoNaoEncontradoException.class,
                () -> servicoVeiculo.buscarVeiculoPorChassi(chassiNaoExistente));
    }

    @Test
    void testBuscarCarroPorMarca() {
        MarcasCarro marcaCarro = MarcasCarro.Chevrolet;
        List<Veiculo> carros = servicoVeiculo.buscarCarroPorMarca(marcaCarro);
        assertNotNull(carros);
        assertFalse(carros.isEmpty());
    }

    @Test
    void testBuscarMotoPorMarca() {
        MarcasMoto marcaMoto = MarcasMoto.Honda;
        List<Veiculo> motos = servicoVeiculo.buscarMotoPorMarca(marcaMoto);
        assertNotNull(motos);
        assertFalse(motos.isEmpty());
    }

    @Test
    void testBuscarVeiculosPorModelo() {
        String modelo = "Cruze";
        List<Veiculo> veiculos = servicoVeiculo.buscarVeiculosPorModelo(modelo);
        assertNotNull(veiculos);
        assertFalse(veiculos.isEmpty());
    }

    @Test
    void testBuscarVeiculoPorId() {
        int idExistente = 1;
        int idNaoExistente = 999;

        Veiculo veiculoExistente = servicoVeiculo.buscarVeiculoPorId(idExistente);
        assertNotNull(veiculoExistente);

        assertThrows(VeiculoNaoEncontradoException.class,
                () -> servicoVeiculo.buscarVeiculoPorId(idNaoExistente));
    }

    @Test
    void testBuscarVeiculosPorAnoDeFabricacao() {
        int anoMinimo = 2019;
        int anoMaximo = 2020;
        List<Veiculo> veiculos = servicoVeiculo.buscarVeiculosPorAnoDeFabricacao(anoMinimo, anoMaximo);
        assertNotNull(veiculos);
        assertFalse(veiculos.isEmpty());
    }

    @Test
    void testAdicionarCarro() {
        Carro novoCarro = new Carro(5, 555, "abc5555", "Fiesta", 150,
                BigDecimal.valueOf(1000), true, 12, MarcasCarro.Ford, 2021,
                LocalDate.parse("2021-01-01"), BigDecimal.valueOf(45000), BigDecimal.valueOf(55000));

        Carro carroAdicionado = servicoVeiculo.adicionarCarro(novoCarro);
        assertNotNull(carroAdicionado);

        assertThrows(VeiculoInvalidoException.class,
                () -> servicoVeiculo.adicionarCarro(novoCarro)); // Testar duplicidade de chassi
    }

    @Test
    void testAdicionarMoto() {
        Moto novaMoto = new Moto(6, 666, "abc6666", "CBR 500", 471, 15,
                MarcasMoto.Honda, 2022, LocalDate.parse("2022-02-02"), BigDecimal.valueOf(25000),
                BigDecimal.valueOf(30000));

        Moto motoAdicionada = servicoVeiculo.adicionarMoto(novaMoto);
        assertNotNull(motoAdicionada);

        assertThrows(VeiculoInvalidoException.class,
                () -> servicoVeiculo.adicionarMoto(novaMoto)); // Testar duplicidade de chassi
    }

    @Test
    void testDeletarVeiculo() {
        int idExistente = 1;
        int idNaoExistente = 999;

        assertDoesNotThrow(() -> servicoVeiculo.deletarVeiculo(idExistente));

        assertThrows(VeiculoNaoEncontradoException.class,
                () -> servicoVeiculo.deletarVeiculo(idNaoExistente));
    }
}