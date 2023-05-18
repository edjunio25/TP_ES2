package TP_ES2.Classes;
public class Carro extends Veiculo {
    private int cavalosPotencia;
    private float cilindradaEmLitro;
    private int isTurbo;
    private int tipoRodas;
    private MarcasCarro marca;

    public Carro(final int id, 
        final int chassi, 
        final String placa, 
        final String modelo,
        final int cavalosPotencia,
        final float cilindradaEmLitro,
        final int isTurbo,
        final int tipoRodas,
        final MarcasCarro marca,
        final String dataFabricacao, 
        final String dataDeEntradaEstoque,
        final float valorFipe,
        final float valorComprado)
        {
            this.id = id ;
            this.chassi = chassi;
            this.placa = placa;
            this.modelo = modelo;
            this.cavalosPotencia = cavalosPotencia;
            this.cilindradaEmLitro = cilindradaEmLitro;
            this.isTurbo = isTurbo;
            this.tipoRodas = tipoRodas;
            this.marca = marca;
            this.dataFabricacao = dataFabricacao;
            this.dataDeEntradaEstoque = dataDeEntradaEstoque;
            this.valorFipe = valorFipe;
            this.valorComprado = valorComprado;
        }
}
