package Forca.tests.palavras;

public class MainPalavrasTest {
    public static void main(String[] args ) throws Exception {
        PalavraTest word = new PalavraTest("teste");

        PalavraTest word2 = new PalavraTest("teste");
        word.getQuantidade('t');
        word.getPosicaoDaIezimaOcorrencia(1,'t');
        word.getTamanho();
        word.compareTo(word2);
        }
}
