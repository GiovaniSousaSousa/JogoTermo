package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
  private String palavra;
  private List<String> tentativas = new ArrayList<String>();

  public Jogo(String palavra) {
    this.palavra = palavra.toLowerCase();
  }


  public String renderJogo() {
    String retorno;
    Boolean validadorEntrada = true;
    Scanner teclado = new Scanner(System.in);

    while (true) {
      if (this.tentativas.size() >= 5) {
        teclado.close();
        retorno = "Perdeu... Maximo de tentativas atingido";
        return retorno;
      }
      if (validadorEntrada == false) {
        System.out.print("A palavra inserida não é valida, reescreva: ");
      }
      if (this.tentativas.size() > 0 ) {
        System.out.println("----------------------------");
        System.out.println("|         TERMOOO          |");
        System.out.println("|                          |");        
        for (int i = 0; i < this.tentativas.size(); i++) {
          System.out.println(String.format("|          %s           |", this.tentativas.get(i)));
        }
        System.out.print("|: ");
        
      } else {
        System.out.println("----------------------------");
        System.out.println("|         TERMOOO          |");
        System.out.println("|                          |");
        System.out.print("|: ");
      }

      String input = teclado.next();
      if (this.validaPalavra(input)) {
        String palavraTentativa = input;
        String resultado = this.validaTentativa(palavraTentativa);
        if (resultado == this.palavra) {
          teclado.close();
          retorno = String.format("Parabéns, a palavra era [%s]", resultado);
          return retorno;
        }
      } else {
        validadorEntrada = false;
      }
    }
  }

  private String validaTentativa(String palavraTentativa) {
    StringBuilder retorno = new StringBuilder("_____");
    String palavraTentativaMinusculo = palavraTentativa.toLowerCase();
    char[] palavraTentativaMinusculoArr = palavraTentativaMinusculo.toCharArray();
    
    if (palavraTentativaMinusculo.equals(this.palavra)) {
      return this.palavra;
    }
    
    for (char letra : palavraTentativaMinusculoArr) {
      if (this.palavra.indexOf(letra) == -1) {
        continue;
      }

      retorno = this.validaChar(letra, retorno, palavraTentativaMinusculo);
      
    }
    this.tentativas.add(retorno.toString());
    return retorno.toString();
  }

  private Boolean validaPalavra(String palavra) {
    if (palavra != null && palavra != "") {
      return palavra.length() == 5;
    }
    return false;
  }

  private StringBuilder validaChar(char letra, StringBuilder retorno, String palavraTentativaMinusculo) {
    if (palavraTentativaMinusculo.indexOf(letra) != this.palavra.indexOf(letra)) {       
      retorno.setCharAt(palavraTentativaMinusculo.indexOf(letra), '#'); 
    }
    
    if (palavraTentativaMinusculo.indexOf(letra) == this.palavra.indexOf(letra)) {
      retorno.setCharAt(this.palavra.indexOf(letra), letra);
    }    
    
    return retorno;
    }
  }