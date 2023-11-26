import java.util.Scanner;
import models.Jogo;
import models.Palavra;

public class App {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Boolean validadorEntrada = true;
    loop: while (true) {

      if (validadorEntrada == false) {
        System.out.print("Input invalido, reescreva...: ");        
      } else {
        System.out.println("----------------------------");
        System.out.println("|         TERMOOO          |");
        System.out.println("|        1. Jogar          |");
        System.out.println("|        2. Sair           |");
        System.out.println("----------------------------");
        System.out.print(": ");
      }
      Integer input = in.nextInt();

      switch (input) {
        case 1:
          Palavra palavra = new Palavra();
          Jogo jogo = new Jogo(palavra.getPalavra());
          System.out.println("Iniciando o jogo...");
          String resultado = jogo.renderJogo();
          System.out.println(resultado);
          break loop;
        case 2:
          System.err.println("Saindo...");
          in.close();
          break loop;
        default:
        validadorEntrada = false;
          break;
      }

    }
  }

}