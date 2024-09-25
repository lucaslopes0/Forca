import Forca.tests.palavras.PalavraTest;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if(texto == null || texto.isEmpty() || texto.equals(" ")){
            throw new Exception("Error: Vazio!");
        }else {
            this.texto = texto;
        }
    }

    public int getQuantidade (char letra)
    {
        int cont=0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (letra == this.texto.charAt(i)){
                cont++;
            }
        }
        return cont;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int ocorrencias = 0;
        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                if (ocorrencias == i) {
                    return j;
                }
                ocorrencias++;
            }
        }
        throw new Exception("Error: Letra não apareceu a " + (i) + " vez!");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }
    @Override
    public String toString ()
    {
        return this.texto;
    }
    @Override
    public boolean equals (Object obj)
    {
        if (this.texto == obj) return true; //verifica se o ponteiro aponta pro mesmo endereço

        if (obj == null) return false;

        if (obj.getClass() != this.texto.getClass()) return false; //verifica se sao ponteiros da mesma classe

        Palavra txt= (Palavra) obj; //coloca txt como sendo um novo ponteiro do tipo PalavraTest

        if(this.texto.length() != txt.texto.length()) return false; //verifica se tem tamanho diferente

        for (int i = 0; i < txt.texto.length(); i++) {          //verifica todos os caracteres em cada posicao da string sao iguais
            if(this.texto.charAt(i) == txt.texto.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode ()
    {
        int hs = 1;

        hs = hs*11+String.valueOf(this.texto).hashCode();

        return hs;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
