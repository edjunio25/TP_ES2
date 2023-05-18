package Classes;

import java.time.LocalDate;

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
        final int anoFabricacao,
        final LocalDate dataDeEntradaEstoque,
        final float valorFipe,
        final float valorComprado){
            this.id = id ;
            this.chassi = chassi;
            this.placa = placa;
            this.modelo = modelo;
            this.cilindradaEmCc = cilindradaEmCc;
            this.aroDasRodas = aroDasRodas;
            this.marca = marca;
            this.anoFabricacao = anoFabricacao;
            this.dataDeEntradaEstoque = dataDeEntradaEstoque;
            this.valorFipe = valorFipe;
            this.valorComprado = valorComprado;
    }

    public int getCilindradaEmCc() {
        return cilindradaEmCc;
    }

    public void setCilindradaEmCc(int cilindradaEmCc) {
        this.cilindradaEmCc = cilindradaEmCc;
    }

    public int getAroDasRodas() {
        return aroDasRodas;
    }

    public void setAroDasRodas(int aroDasRodas) {
        this.aroDasRodas = aroDasRodas;
    }

    public MarcasMoto getMarca() {
        return marca;
    }

    public void setMarca(MarcasMoto marca) {
        this.marca = marca;
    }
}
