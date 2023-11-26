package models;
import java.util.Random;

public class Palavra {
  private String palavra;
  private Random ran = new Random();
  // lista de palavras
  String[] arrayPalavras = {"Falar", "Tempo", "Risco", "Turma", "Quase", "Olhar", "Viola", "Cobra", "Pulga"}; 

  
  public Palavra() {
    // gera um palavra aleatoria usando o random
    this.palavra = arrayPalavras[ran.nextInt(arrayPalavras.length)];
  }

  //getter
  public String getPalavra() {
    return this.palavra;
  }

}
