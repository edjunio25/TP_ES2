package concessionaria.repositorio;

import concessionaria.classes.Carro;
import concessionaria.classes.MarcasCarro;
import concessionaria.classes.MarcasMoto;
import concessionaria.classes.Moto;
import concessionaria.classes.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioVeiculos {
    private List<Veiculo> veiculos;

    public RepositorioVeiculos() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(int idVeiculo) {
        Optional veiculoOptional = veiculos.stream()
                .filter(veiculo -> veiculo.getId() == idVeiculo)
                .findFirst();

        if (veiculoOptional.isEmpty()) {
            throw new RuntimeException("Não foi encontrado veículo para o id especificado");
        }

        veiculos.remove(veiculoOptional.get());
    }

    public Optional<Veiculo> buscarPorChassi(int chassi) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getChassi() == chassi)
                .findFirst();
    }

    public List<Veiculo> buscarPorAnoFabricação(int anoFabricacaoMinimo, int anoFabricacaoMaximo) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getAnoFabricacao() >= anoFabricacaoMinimo &&
                        veiculo.getAnoFabricacao() <= anoFabricacaoMaximo)
                .toList();
    }

    public List<Veiculo> buscarCarrosPorMarca(MarcasCarro marcaCarro) {
        return veiculos.stream()
                .filter(veiculo -> {
                    if(!veiculo.getClass().isAssignableFrom(Carro.class)) {
                        return false;
                    }
                    Carro carro = (Carro) veiculo;

                    return carro.getMarca() == marcaCarro;
                })
                .toList();
    }

    public List<Veiculo> buscarMotosPorMarca(MarcasMoto marcaMoto) {
        return veiculos.stream()
                .filter(veiculo -> {
                    if(!veiculo.getClass().isAssignableFrom(Moto.class)) {
                        return false;
                    }
                    Moto moto = (Moto) veiculo;

                    return moto.getMarca() == marcaMoto;
                })
                .toList();
    }
}