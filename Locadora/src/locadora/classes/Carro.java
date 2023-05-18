package locadora.classes;
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
    		super(id,chassi,placa,modelo,dataFabricacao,dataDeEntradaEstoque,valorFipe,valorComprado);
            this.cavalosPotencia = cavalosPotencia;
            this.cilindradaEmLitro = cilindradaEmLitro;
            this.isTurbo = isTurbo;
            this.tipoRodas = tipoRodas;
            this.marca = marca;
        }

	public int getCavalosPotencia() {
		return cavalosPotencia;
	}

	public void setCavalosPotencia(int cavalosPotencia) {
		this.cavalosPotencia = cavalosPotencia;
	}

	public float getCilindradaEmLitro() {
		return cilindradaEmLitro;
	}

	public void setCilindradaEmLitro(float cilindradaEmLitro) {
		this.cilindradaEmLitro = cilindradaEmLitro;
	}

	public int getIsTurbo() {
		return isTurbo;
	}

	public void setIsTurbo(int isTurbo) {
		this.isTurbo = isTurbo;
	}

	public int getTipoRodas() {
		return tipoRodas;
	}

	public void setTipoRodas(int tipoRodas) {
		this.tipoRodas = tipoRodas;
	}

	public MarcasCarro getMarca() {
		return marca;
	}

	public void setMarca(MarcasCarro marca) {
		this.marca = marca;
	}
    
    
    
}
