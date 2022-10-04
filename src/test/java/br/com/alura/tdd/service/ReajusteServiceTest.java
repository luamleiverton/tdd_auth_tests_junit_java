package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

  private ReajusteService service;
  private Funcionario funcionario;

  @BeforeEach
  public void inicializar() {
    System.out.println("Inicializando testes");
    this.service = new ReajusteService();
    this.funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("1000.00"));
  }

  @AfterEach
  public void finalizar() {
    System.out.println("Encerrando testes");
  }

  @BeforeAll
  public static void antesDeTodos() {
    System.out.println("Antes de todos os testes");
  }

  @AfterAll
  public static void deposDeTodos() {
    System.out.println("Depois de todos os testes");
  }

  @Test
  public void reajusteDeveriaSerTresPorcenteComDesempenhoADesejar(){
    service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
    assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
  }

  @Test
  public void reajusteDeveriaSerQuinzePorcenteComDesempenhoSatisfatorio(){
    service.concederReajuste(funcionario, Desempenho.SATISFATORIO);
    assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
  }

  @Test
  public void reajusteDeveriaSerTrintaPorcenteComDesempenhoExcelente(){
    service.concederReajuste(funcionario, Desempenho.EXCELENTE);
    assertEquals(new BigDecimal("1300.00"), funcionario.getSalario());
  }
  
}
