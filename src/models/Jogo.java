package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
  private String palavra;
  // cria lista de string para as tentativas
  private List<String> tentativas = new ArrayList<String>();

  // qunado cria instancia, recebe a palavra como argumento
  public Jogo(String palavra) {
    this.palavra = palavra.toLowerCase();
  }

  // gera o jogo no console
  public String renderJogo() {
    // var que guarda o resultado que vai ser retornado
    String retorno;
    Integer idx = 0;
    Scanner in = new Scanner(System.in);

    while (true) {
      // usa o tamanho da lista, para validar se chegou a 5 tentativas
      if (this.tentativas.size() >= 5) {
        in.close();
        retorno = "Perdeu... Maximo de tentativas atingido";
        return retorno;
      }
      // se o idx receber +1 quer dizer que a foi inserido um input invalido, logo renderiza isso no console
      if (idx > 0) {
        System.out.print("A palavra inserida não é valida, reescreva: ");
      }
      // caso já exista tentativas, rederiza o "menu" com as tentativas listadas
      if (this.tentativas.size() > 0 ) {
        System.out.println("----------------------------");
        System.out.println("|         TERMOOO          |");
        System.out.println("|                          |");        
        for (int i = 0; i < this.tentativas.size(); i++) {
          System.out.println(String.format("|          %s           |", this.tentativas.get(i)));
        }
        System.out.print("|: ");
        
      } else {
        // menu normal ao iniciar o jogo
        System.out.println("----------------------------");
        System.out.println("|         TERMOOO          |");
        System.out.println("|                          |");
        System.out.print("|: ");
      }

      // pega o input
      String input = in.next();
      // valida o resultado
      if (this.validaPalavra(input)) {
        String palavraTentativa = input;
        // define o resultado
        String resultado = this.validaTentativa(palavraTentativa);
        // verifica se acertou
        if (resultado == this.palavra) {
          in.close();
          // se acertou... vence!
          retorno = String.format("Parabéns, a palavra era [%s]", resultado);
          return retorno;
        }
      } else {
        idx += 1;
      }
    }
  }

  private String validaTentativa(String palavraTentativa) {
    StringBuilder retorno = new StringBuilder("_____");
    String pTentativa = palavraTentativa.toLowerCase();
    char[] pTentativaArr = pTentativa.toCharArray();
    
    // se acertar a palavra direto, retorna a palavra
    if (pTentativa.equals(this.palavra)) {
      return this.palavra;
    }
    
    for (char letra : pTentativaArr) {
      if (this.palavra.indexOf(letra) == -1) {
        continue;
      }

      retorno = this.validaChar(letra, retorno, pTentativa);
      
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

  private StringBuilder validaChar(char letra, StringBuilder retorno, String pTentativa) {
    if (pTentativa.indexOf(letra) != this.palavra.indexOf(letra)) {       
      retorno.setCharAt(pTentativa.indexOf(letra), '#'); 
    }
    
    if (pTentativa.indexOf(letra) == this.palavra.indexOf(letra)) {
      retorno.setCharAt(this.palavra.indexOf(letra), '+');
    }    
    
    return retorno;
    }
  }