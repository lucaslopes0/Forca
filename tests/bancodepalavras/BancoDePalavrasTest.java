package Forca.tests.bancodepalavras;

import Forca.tests.palavras.PalavraTest;

public class BancoDePalavrasTest {
    private static String[] palavras =
            {
                    "JAVA",
                    "CLASSE",
                    "OBJETO",
                    "INSTANCIA",
                    "PUBLICO",
                    "PRIVATIVO",
                    "METODO",
                    "CONSTRUTOR",
                    "SETTER",
                    "GETTER",
                    "LUZ",
                    "PRAZER"
            };
    public static PalavraTest getPalavraSorteada ()
    {
        PalavraTest palavra = null;
        try
        {
            palavra = new PalavraTest (BancoDePalavrasTest.palavras[(int)(Math.random() * BancoDePalavrasTest.palavras.length)]);
        }
        catch (Exception e)
        {}
        System.out.println(palavra);
        return palavra;
    }
}
