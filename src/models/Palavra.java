package models;
import java.util.Random;

public class Palavra {
  private String palavra;
  private Random ran = new Random();
  String[] arrayPalavras = {"Falar", "Tempo", "Risco", "Turma", "Quase", "Olhar", "Viola", "Cobra", "Pulga"}; 

  
  public Palavra() {
    this.palavra = arrayPalavras[ran.nextInt(arrayPalavras.length)];
  }

  public String getPalavra() {
    return this.palavra;
  }

}
