package Forca;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax<0) throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
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
    }
    @Override
    public int hashCode ()
    {
        int hs = 1;
        hs = hs*11+this.qtdMax;

        return hs;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception // construtor de cópia
    {
        try {
            c.qtdMax = this.qtdMax;
            c.qtdErr = this.qtdErr;
        }catch (Exception err){
            throw new Exception("Err!");
        }
    }
    public Object clone ()
    {
        ControladorDeErros c = null;
        try {
            c = new ControladorDeErros(this);
        }catch (Exception ignored){}
        return c;
    }
}
