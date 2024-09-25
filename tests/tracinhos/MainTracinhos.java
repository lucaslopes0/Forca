package Forca.tests.tracinhos;

public class MainTracinhos{
    public static void main(String[] args) {
        tracinhosTest trc;
        do {
            trc = null;
            try {
                trc = new tracinhosTest(3);
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
            try {
                trc.revele(1, 'u');
                trc.revele(2, 'v');
                trc.revele(3, 'a');
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
            trc.isAindaComTracinhos();
            //System.out.println(this.texto);
        } while (trc.isAindaComTracinhos());
    }
}
