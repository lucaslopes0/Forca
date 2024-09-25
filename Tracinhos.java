package Forca;

public class Tracinhos implements Cloneable
{
    private char[] texto;

    public Tracinhos (int qtd) throws Exception {
        if (qtd < 0) {
            throw new Exception("Error: Qtd nao é positiva!");
        }
        this.texto = new char[qtd];
        for(int i=0;i<qtd;i++){
            this.texto[i]='_';
        }
        System.out.println(this.texto);
    }

    public void revele (int posicao, char letra) throws Exception {
        if(posicao<0 || posicao>this.texto.length){
            throw new Exception("Error: Posicao fora do limite!");
        }
        try {
            this.texto[posicao - 1] = letra;
        }catch (Exception err){
            throw new Exception("Error: Posicao fora do limite!");
        }
        System.out.println(this.texto);
    }

    public boolean isAindaComTracinhos () {
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] == '_') {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString () {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < this.texto.length; i++) {
            resultado.append(this.texto[i]); // Adiciona o caractere
            if (i < this.texto.length - 1) {
                resultado.append(" "); // Adiciona um espaço se não for o último
            }
        }
        return resultado.toString();
    }
    @Override
    public boolean equals (Object obj)
    {
        if(this.texto == obj) return true;

        if (obj ==  null) return false;

        if (obj.getClass()!=this.getClass()) return false;

        Tracinhos tra = (Tracinhos) obj;

        if (this.texto.length != tra.texto.length) return false;

        for (int i = 0; i < this.texto.length; i++) {
            if(this.texto[i]!=tra.texto[i]){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode ()
    {
        int varRand = 1;
        if (this.texto!=null){
            for (int i = 0; i < this.texto.length ; i++) {
                varRand = varRand * 11 + this.texto[i];
            }
        }
        if (varRand<0) varRand=-varRand;
        return varRand;
        // calcular e retornar o hashcode de this
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        this.texto = new char[t.texto.length];

        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone ()
    {
        Tracinhos t = null;
        try{
            t = new Tracinhos(this);
        }catch (Exception ignored){}
        return t;
    }
}
