package TP_ES2.Classes;
public abstract class Veiculo {
    protected int id;
    protected int chassi;
    protected String placa;
    protected String modelo;
    protected String dataFabricacao;
    protected String dataDeEntradaEstoque; 
    protected float valorFipe;
    protected float valorComprado;

    public Veiculo(final int id, 
        final int chassi, 
        final String placa, 
        final String modelo,
        final String dataFabricacao, 
        final String dataDeEntradaEstoque,
        final float valorFipe,
        final float valorComprado){
            this.id = id ;
            this.chassi = chassi;
            this.placa = placa;
            this.dataFabricacao = dataFabricacao;
            this.dataDeEntradaEstoque = dataDeEntradaEstoque;
            this.valorFipe = valorFipe;
            this.valorComprado = valorComprado;
        }
}