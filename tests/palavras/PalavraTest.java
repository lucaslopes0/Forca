package Forca.tests.palavras;

public class PalavraTest /*implements Comparable<PalavraTest>*/{
    private String texto;

    public PalavraTest (String texto) throws Exception {
        if(texto == null || texto.isEmpty() || texto.equals(" ")){
            throw new Exception("Error: Vazio!");
        }else {
            this.texto = texto;
            System.out.println("construtor: "+ this.texto);
        }
        // verifica se o texto recebido é nulo ou então vazio,
        // ou seja, sem nenhum caractere, lançando exceção.
        // armazena o texto recebido em this.texto.
    }

    public int getQuantidade (char letra) {
        int cont=0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (letra == this.texto.charAt(i)){
                cont++;
            }
        }
        System.out.println("getQuantidade : "+cont);
        return cont;
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception {
        int ocorrencias = 0;
        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                if (ocorrencias == i) {
                    System.out.println("Iezima: "+j);
                    return j;
                }
                ocorrencias++;
            }
        }
        throw new Exception("Error: Letra não apareceu a " + (i) + " vez!");
        // se i==0, retorna a posicao em que ocorre a primeira aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lançar excecao caso nao encontre em this.texto a Iézima aparição da letra fornecida.
    }

    public int getTamanho ()
    {
        System.out.println(this.texto.length());
        return this.texto.length();
    }
    @Override
    public String toString ()
    {
        return this.texto;
    }
    @Override
    public boolean equals (Object obj) {
        if (this.texto == obj) return true; //verifica se o ponteiro aponta pro mesmo endereço

        if (obj == null) return false;

        if (obj.getClass() != this.texto.getClass()) return false; //verifica se sao ponteiros da mesma classe

        PalavraTest txt= (PalavraTest) obj; //coloca txt como sendo um novo ponteiro do tipo PalavraTest

        if(this.texto.length() != txt.texto.length()) return false; //verifica se tem tamanho diferente

        for (int i = 0; i < txt.texto.length(); i++) {          //verifica todos os caracteres em cada posicao da string sao iguais
            if(this.texto.charAt(i) == txt.texto.charAt(i)) {
                return false;
            }
        }
        return true;
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
    }
    @Override
    public int hashCode ()
    {
        int hs = 1;

        hs = hs*11+String.valueOf(this.texto).hashCode();

        return hs;
        // calcular e retornar o hashcode de this
    }

    public int compareTo (PalavraTest palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}

//