
package br.com.concessionaria;

//import org.junit.Test;
import br.com.concessionaria.domain.entity.Carro;
import br.com.concessionaria.domain.entity.MarcasCarro;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CarroTest {
    private Carro carro;

    @Before
    public void setUp(){
        carro = new Carro(
            12, 12345, "ABC1234", "Carro Teste", 200, BigDecimal.valueOf(2.0),
            Boolean.TRUE, "Liga_Leve", MarcasCarro.Toyota,
            2023, LocalDate.now(), BigDecimal.valueOf(20000), BigDecimal.valueOf(18000)
        );
    }

    @Test
    public void testGetCavalosPotencia() {
        Assertions.assertEquals(200, carro.getCavalosPotencia());
    }

    @Test
    public void testGetCilindradaEmLitro() {
        Assertions.assertEquals(BigDecimal.valueOf(2.0), carro.getCilindradaEmLitro());
    }

    @Test
    public void testGetMarca() {
        Assertions.assertEquals(MarcasCarro.Toyota, carro.getMarca());
    }
    
    @Test
    public void testIsTurbo() {
        Assertions.assertEquals(Boolean.TRUE, carro.isTurbo());
    }

    //@Test
    //public void testNumPortas(){
    //  assertEquals(4, carro.getNumPortas());
    //}

}
