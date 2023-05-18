package TP_ES2.Classes;
public class Moto extends Veiculo {
    private int cilindradaEmCc;
    private int aroDasRodas;
    private MarcasMoto marca;

    public Moto(final int id, 
        final int chassi, 
        final String placa, 
        final String modelo,
        final int cilindradaEmCc,
        final int aroDasRodas,
        final MarcasMoto marca,
        final String dataFabricacao, 
        final String dataDeEntradaEstoque,
        final float valorFipe,
        final float valorComprado){
            this.id = id ;
            this.chassi = chassi;
            this.placa = placa;
            this.modelo = modelo;
            this.cilindradaEmCc = cilindradaEmCc;
            this.aroDasRodas = aroDasRodas;
            this.marca = marca;
            this.dataFabricacao = dataFabricacao;
            this.dataDeEntradaEstoque = dataDeEntradaEstoque;
            this.valorFipe = valorFipe;
            this.valorComprado = valorComprado;
        }
}
