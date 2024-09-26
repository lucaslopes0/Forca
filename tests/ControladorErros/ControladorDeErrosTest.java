package Forca.tests.ControladorErros;

public class ControladorDeErrosTest implements Cloneable{
    private int qtdMax, qtdErr=0;

    public ControladorDeErrosTest (int qtdMax) throws Exception
    {
        if (qtdMax<0) throw new Exception ("Error: Quantidade invalida");

        this.qtdMax=qtdMax;

        // verifica se qtdMax fornecida não é positiva, lançando
        // uma exceção.
        // armazena qtdMax fornecida em this.qtdMax.
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
        // verifica se this.qtdErr ja é igual a this.qtdMax,
        // lançando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
        // retorna true se this.qtdErr for igual a this.qtdMax,
        // ou então false, caso contrario.
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this.qtdMax == (int)obj){
            return true;
        }else return false;
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
    }

    @Override
    public int hashCode ()
    {
        int hs = 1;
        hs = hs*11+this.qtdMax;

        return hs;
        // calcular e retornar o hashcode de this
    }

    public ControladorDeErrosTest (ControladorDeErrosTest c) throws Exception // construtor de cópia
    {
        try {
            c.qtdMax = this.qtdMax;
            c.qtdErr = this.qtdErr;
        }catch (Exception err){
            throw new Exception("Err!");
        }
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
    }

    public Object clone ()
    {
        ControladorDeErrosTest c = null;
        try {
            c = new ControladorDeErrosTest(this);
        }catch (Exception Ignored){}
        return c;
        // returnar uma cópia de this
    }

}
