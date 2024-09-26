package Forca.tests.controladordeletrasjadigitadas;

public class ControladorDeLetras implements Cloneable{
    private String letrasJaDigitadas;

    public ControladorDeLetras()
    {
        this.letrasJaDigitadas = "";
        System.out.println(this.letrasJaDigitadas);
        // torna this.letrasJaDigitadas igual ao String vazio
    }

    public boolean isJaDigitada (char letra)
    {
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            if (this.letrasJaDigitadas.charAt(i) == letra) {
                return true;
            }
        }
        return false;
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
    }

    public void registre (char letra) throws Exception
    {
        if (this.isJaDigitada(letra)) throw new Exception("Error: Letra Já Digitada!");

        this.letrasJaDigitadas += letra;
        // verifica se a letra fornecida ja foi digitada (pode usar
        // o método this.isJaDigitada, para isso), lancando uma exceção
        // em caso afirmativo.
        // concatena a letra fornecida a this.letrasJaDigitadas.
    }
    @Override
    public String toString ()
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            str.append(this.letrasJaDigitadas.charAt(i));
            if (i < this.letrasJaDigitadas.length()-1){
                str.append(",");
            }
        }
        return str.toString();
        // retorna um String com TODAS as letras presentes em
        // this.letrasJaDigitadas separadas por vírgula (,).
    }
    @Override
    public boolean equals (Object obj)
    {
        if (this.letrasJaDigitadas == obj) return true;

        if(obj == null) return false;

        if (obj.getClass() != this.letrasJaDigitadas.getClass()) return false;

        ControladorDeLetras ctrl = (ControladorDeLetras) obj;

        if (ctrl.letrasJaDigitadas.length() != this.letrasJaDigitadas.length()) return false;

        for (int i = 0; i < ctrl.letrasJaDigitadas.length(); i++) {
            if (ctrl.letrasJaDigitadas.charAt(i) != this.letrasJaDigitadas.charAt(i)){
                return false;
            }
        }
        return true;
        // verificar se this e obj são iguais
    }
    @Override
    public int hashCode ()
    {
        int hs = 1;
        if (this.letrasJaDigitadas!=null) {
            for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
                hs = hs * 11 + this.letrasJaDigitadas.charAt(i);
            }
        }
        if (hs<0) hs=-hs;
        return hs;
        // calcular e retornar o hashcode de this
    }

    public ControladorDeLetras(ControladorDeLetras c) throws Exception // construtor de cópia
    {
        try {
            c.letrasJaDigitadas=this.letrasJaDigitadas;
        }catch (Exception err){
            throw new Exception("Error");
        }
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
    }

    public Object clone ()
    {
        ControladorDeLetras ctr = null;
        try {
            ctr = new ControladorDeLetras(this);
        }catch (Exception ignored){}
        return ctr;
        // criar uma cópia do this com o construtor de cópia e retornar
    }

}


//