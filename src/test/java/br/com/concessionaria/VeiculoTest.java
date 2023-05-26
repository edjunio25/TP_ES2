
package br.com.concessionaria;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.concessionaria.domain.entity.Veiculo;
import br.com.concessionaria.domain.entity.Carro;
import br.com.concessionaria.domain.entity.Moto;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
public class VeiculoTest {
    @Test
    public void testProperIdAssign() {

        Veiculo veiculo1 = new Veiculo(1, 12345, "ABC1234", "Modelo1", 2021, LocalDate.now(), BigDecimal.ZERO, BigDecimal.ZERO);
        Veiculo veiculo2 = new Veiculo(2, 54321, "XYZ9876", "Modelo2", 2022, LocalDate.now(), BigDecimal.ZERO, BigDecimal.ZERO);

        int temporaryIdVeiculo1PlusOne = veiculo1.getId() + 1;
        assertEquals(temporaryIdVeiculo1PlusOne, veiculo2.getId());
    }
}
