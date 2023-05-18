package Classes;

import java.time.LocalDate;

public abstract class Veiculo {
    protected int id;
    protected int chassi;
    protected String placa;
    protected String modelo;
    protected int anoFabricacao;
    protected LocalDate dataDeEntradaEstoque;
    protected float valorFipe;
    protected float valorComprado;

    public Veiculo() {}

    public Veiculo(final int id,
                   final int chassi,
                   final String placa,
                   final String modelo,
                   final int anoFabricacao,
                   final LocalDate dataDeEntradaEstoque,
                   final float valorFipe,
                   final float valorComprado){
        this.id = id ;
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.dataDeEntradaEstoque = dataDeEntradaEstoque;
        this.valorFipe = valorFipe;
        this.valorComprado = valorComprado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public LocalDate getDataDeEntradaEstoque() {
        return dataDeEntradaEstoque;
    }

    public void setDataDeEntradaEstoque(LocalDate dataDeEntradaEstoque) {
        this.dataDeEntradaEstoque = dataDeEntradaEstoque;
    }

    public float getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(float valorFipe) {
        this.valorFipe = valorFipe;
    }

    public float getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(float valorComprado) {
        this.valorComprado = valorComprado;
    }
}