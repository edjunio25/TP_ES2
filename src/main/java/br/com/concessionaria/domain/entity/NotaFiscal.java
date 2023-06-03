package br.com.concessionaria.domain.entity;
import java.math.BigDecimal;

public class NotaFiscal{
    private int id;
    protected String numeroNota;
    protected BigDecimal valorNota;
    protected String linkAcessoNota;

    public NotaFiscal(
        final int id,
        final String numeroNota,
        final BigDecimal valorNota,
        final String linkAcessoNota){
            this.id = id;
            this.numeroNota = numeroNota;
            this.valorNota = valorNota;
            this.linkAcessoNota = linkAcessoNota;
        }
    
    public int getId(){
        return this.id;
    }

    public String getNumeroNota() {
		return this.numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

    public BigDecimal getValorNota(){
        return this.valorNota;
    }

    public void setValorNota(BigDecimal valorNota){
        this.valorNota = valorNota;
    }

    public String getLinkAcessoNota(){
        return this.linkAcessoNota;
    }

    public void setLinkAcessoNota(String linkAcessoNota){
        this.linkAcessoNota = linkAcessoNota;
    }    

}