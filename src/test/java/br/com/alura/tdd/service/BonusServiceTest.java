package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

  @Test
  void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
    BonusService service = new BonusService();
    
    //assertThrows(IllegalArgumentException.class, 
    //            () -> service.calcularBonus(new Funcionario("Luam", LocalDate.now(), new BigDecimal("25000"))));


    //se precisar capturar a mensagem da excecao
    try {
      service.calcularBonus(new Funcionario("Luam", LocalDate.now(), new BigDecimal("25000")));
      fail("Sem exception");
    } catch (Exception e) {
      assertEquals("Valor do salário não permite bonus", e.getMessage());
    }

  }

  @Test
  void bonusDeveriaSerDezPorcentoDoSalario() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Luam", LocalDate.now(), new BigDecimal("2500")));

    assertEquals(new BigDecimal("250.00"),  bonus);
  }

  @Test
  void bonusDeveriaSerDezPorCentoParaSalarioIgualADezMil() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Luam", LocalDate.now(), new BigDecimal("10000")));

    assertEquals(new BigDecimal("1000.00"),  bonus);
  }
  
}
