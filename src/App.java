import java.util.Scanner;
import models.Jogo;
import models.Palavra;

public class App {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Integer idx = 0;
    loop: while (true) {

      if (idx > 0) {
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
          // renderiza o jogo
          Palavra palavra = new Palavra();
          Jogo jogo = new Jogo(palavra.getPalavra());
          System.out.println("Iniciando o jogo...");
          String resultado = jogo.renderJogo();
          System.out.println(resultado);
          break loop;
        case 2:
          // sai do loop
          System.err.println("Saindo...");
          in.close();
          break loop;
        default:
          idx += 1;
          break;
      }

    }
  }

}

















































  // private static String getInputInt(Scanner in, String prompt) { 
  //   System.out.print(prompt); 
  //   String text = "";
  //   while (true) { 
  //     text = in.nextLine();
  //     if(isInteger(text)) 
  //       break; 
  //       System.out.print("Try again, " + prompt);  
  //     } 
  //   return text; 
  // }

  // private static String getInputStr(Scanner in, String prompt) {
  //   System.out.print(prompt); 
  //   String text = "";
  //   while (true) {
  //     text = in.nextLine();
  //     if (!Palavra.validaPalavra(text)) {

  //     }
  //   }
  // }

  // private static boolean isInteger(String str) { 
  //   try {
  //     Integer.parseInt(str);
  //     return true;
  //   } catch(NumberFormatException e) {
  //     return false;
  //   }
  // }