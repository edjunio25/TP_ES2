
package br.com.concessionaria;
import br.com.concessionaria.domain.entity.Moto;
import br.com.concessionaria.domain.entity.MarcasMoto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;

public class MotoTest {
    Moto moto;
    @Before
    public void setUp(){
        Moto moto = new Moto(
            12345, "ABC1234", "Moto Teste", 1000, 18, MarcasMoto.YAMAHA,
            2023, LocalDate.now(), BigDecimal.valueOf(5000), BigDecimal.valueOf(4000)
        );
    }

    
    @Test
    public void testGetCilindradaEmCc() {
        Moto moto = new Moto(
                12345, "ABC1234", "Moto Teste", 1000, 18, MarcasMoto.YAMAHA,
                2023, LocalDate.now(), BigDecimal.valueOf(5000), BigDecimal.valueOf(4000)
        );
        assertEquals(1000, moto.getCilindradaEmCc());
    }

    @Test
    public void testGetAroDasRodas() {
        Moto moto = new Moto(
                12345, "ABC1234", "Moto Teste", 1000, 18, MarcasMoto.YAMAHA,
                2023, LocalDate.now(), BigDecimal.valueOf(5000), BigDecimal.valueOf(4000)
        );
        assertEquals(18, moto.getAroDasRodas());
    }

    @Test
    public void testGetMarca() {
        Moto moto = new Moto(
                12345, "ABC1234", "Moto Teste", 1000, 18, MarcasMoto.YAMAHA,
                2023, LocalDate.now(), BigDecimal.valueOf(5000), BigDecimal.valueOf(4000)
        );
        assertEquals(MarcasMoto.YAMAHA, moto.getMarca());
    }
}
