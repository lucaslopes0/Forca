package Forca.tests.tracinhos;


import java.util.Arrays;

public class tracinhosTest implements Cloneable {
        private char[] texto;
        public tracinhosTest (int qtd) throws Exception {
            if (qtd < 0) {
                throw new Exception("Error: Qtd nao é positiva!");
            }
            this.texto = new char[qtd];
            for(int i=0;i<qtd;i++){
               this.texto[i]='_';
            }
            System.out.println(this.texto);
            // verifica se qtd nao e positiva, lan�ando uma excecao.
            // instancia this.texto com um vetor com tamanho igual qtd.
            // preenche this.texto com underlines (_).
        }
        public void revele (int posicao, char letra) throws Exception
        {
            if(posicao<0 || posicao>this.texto.length){
                throw new Exception("Error: Posicao fora do limite!");
            }
            try {
                this.texto[posicao] = letra;
            }catch (Exception err){
                throw new Exception("Error: Posicao fora do limite!");
            }
            System.out.println(this.texto);
            //System.out.println(Arrays.toString(this.texto));
            // verifica se posicao e negativa ou entao igual ou maior do que this.texto.length, lancando uma excecao.
            // armazena a letra fornecida na posicao tambem fornecida do vetor this.texto
        }
        public boolean isAindaComTracinhos () {
            for (int i = 0; i < this.texto.length; i++) {
                if (this.texto[i] == '_') {
                    return true;
                }
            }
            return false;
            // percorre o vetor de char this.texto e verifica se o mesmo ainda contem algum underline ou se ja
            // foram todos substituidos por letras; retornar true caso ainda reste algum underline, ou false caso contrario
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
            // retorna um String com TODOS os caracteres que ha
            // no vetor this.texto, intercalados com espacos em
            // branco
        }

        @Override
        public boolean equals (Object obj)
        {
            if(this.texto == obj) return true;

            if (obj ==  null) return false;

            if (obj.getClass()!=this.getClass()) return false;

            tracinhosTest tra = (tracinhosTest)obj;

            if (this.texto.length != tra.texto.length) return false;

            for (int i = 0; i < this.texto.length; i++) {
                if(this.texto[i]!=tra.texto[i]){
                    return false;
                }
            }
            return true;
            // verificar se this e obj possuem o mesmo conte�do, retornando
            // true no caso afirmativo ou false no caso negativo
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

        public tracinhosTest (tracinhosTest t) throws Exception{ // construtor de c�pia
            this.texto = new char[t.texto.length];

            for (int i = 0; i < t.texto.length; i++) {
                this.texto[i] = t.texto[i];
            }
            // intanciar this.texto um vetor com o mesmo tamanho de t.texto
            // e compilar o conteudo de t.texto para this.texto
        }

        public Object clone ()
        {
            tracinhosTest t = null;
            try{
                t = new tracinhosTest(this);
            }catch (Exception ignored){}
            return t;
            // retornar uma copia de this
        }
}

//