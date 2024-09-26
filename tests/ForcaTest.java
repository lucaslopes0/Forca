//import java.io.*;
package Forca.tests;

import Forca.tests.ControladorErros.ControladorDeErrosTest;
import Forca.tests.bancodepalavras.BancoDePalavrasTest;
import Forca.tests.controladordeletrasjadigitadas.ControladorDeLetras;
import Forca.tests.palavras.PalavraTest;
import Forca.tests.tracinhos.tracinhosTest;

public class ForcaTest {
    public static void main (String[] args){
        char continuar = ' ';

        do
        {
            PalavraTest palavra = BancoDePalavrasTest.getPalavraSorteada();

            tracinhosTest tracinhos = null;
            try
            {
                tracinhos = new tracinhosTest (palavra.getTamanho());
            }
            catch (Exception erro)
            {}

            ControladorDeLetras
                    controladorDeLetrasJaDigitadas =
                    new ControladorDeLetras ();

            ControladorDeErrosTest controladorDeErros = null;
            try
            {
                controladorDeErros = new ControladorDeErrosTest ((int)(palavra.getTamanho()*0.6));
            }
            catch (Exception ignored)
            {}

            while (tracinhos.isAindaComTracinhos() &&
                    !controladorDeErros.isAtingidoMaximoDeErros())
            {
                System.out.println ("Palavra...: "+tracinhos);
                System.out.println ("Digitadas.: "+controladorDeLetrasJaDigitadas);
                System.out.println ("Erros.....: "+controladorDeErros);

                try
                {
                    System.out.print   ("Qual letra? ");
                    char letra = Character.toUpperCase (TecladoTest.getUmChar());

                    if (controladorDeLetrasJaDigitadas.isJaDigitada(letra))
                        System.err.println ("Essa letra ja foi digitada!\n");
                    else
                    {
                        controladorDeLetrasJaDigitadas.registre (letra);

                        int qtd = palavra.getQuantidade (letra);

                        if (qtd==0)
                        {
                            System.err.println ("A palavra nao tem essa letra!\n");
                            controladorDeErros.registreUmErro ();
                        }
                        else
                        {
                            for (int i=0; i<qtd; i++)
                            {
                                int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,letra);
                                tracinhos.revele (posicao, letra);
                            }
                            System.out.println ();
                        }
                    }
                }
                catch (Exception erro)
                {
                    System.err.println (erro.getMessage());
                }
            }

            if (controladorDeErros.isAtingidoMaximoDeErros ())
                System.out.println ("Que pena! Voce perdeu! A palavra era "+palavra+"\n");
            else // !tracinhos.isAindaComTracinhos()
                System.out.println ("Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

            for(;;)
            {
                try
                {
                    System.out.print ("Deseja jogar de novo (S/N)? ");
                    continuar = Character.toUpperCase (TecladoTest.getUmChar());
                    if (continuar!='S' && continuar!='N')
                        System.err.println ("Opcao invalida! Tente novamente...");
                    else
                        break;
                }
                catch (Exception erro)
                {
                    System.err.println ("Opcao invalida! Tente novamente...");
                }
            }
        }
        while (continuar=='S');
    }
}

//