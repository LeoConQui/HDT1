import java.util.Scanner;


public class menu {

    public static void main(String[] args) throws Exception{;

    Radio miRadio = new Radio();
	Scanner _in = new Scanner(System.in);

    int opcion;
    do {

        System.out.println("********************************************");
        System.out.println("*                                          *");
        System.out.println("*                   MENU                   *");
        System.out.println("*                                          *");
        System.out.println("*  1.  Seleccion de la frecuencia          *");
        System.out.println("*  2.  Cambiar emisora (adelante)          *");
        System.out.println("*  3.  Cambiar emisora (atras)             *");
        System.out.println("*  4.  Emisora AM actual                   *");
        System.out.println("*  5.  Emisora FM actual                   *");
        System.out.println("*  6.  Guardar emisora AM actual en # slot *");
        System.out.println("*  7.  Guardar emisora FM actual en # slot *");
        System.out.println("*  8.  Obtener # slot AM                   *");
        System.out.println("*  9.  Obtener # slot FM                   *");
        System.out.println("*  10. Desea encender/apgar                *");
        System.out.println("*                                          *");
        System.out.println("********************************************");
        System.out.println("\n");

        while (miRadio.isOn() == true) {
            System.out.println("Ingrese una opcion");
            opcion = _in.nextInt();
            _in.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese frecuencia AM o FM");
                    String freq = _in.nextLine();
                    miRadio.setFrequence(freq);
                    break;
                case 2:
                    miRadio.Forward();
                    break;
                case 3:
                    miRadio.Backward();
                    break;
                case 4:
                    miRadio.getAMActualStation();
                    break;
                case 5:
                    miRadio.getFMActualStation();
                    break;  



                case 6:
                    System.out.println("Ingrese estación que desee guardar");
                    int freqAM = _in.nextInt();
                    _in.nextLine();
                    System.out.println("Ingrese el slot en que lo quiere guardar. - De 1 a 12 - ");
                    int slotPosAM = _in.nextInt();
                    _in.nextLine();
                    if (miRadio.getFrequence().equals("AM")) {
                        miRadio.saveAMStation(freqAM, slotPosAM-1);
                    }
                    
                    break;
                case 7:
                    System.out.println("Ingrese estación que desee guardar");
                    int freqFM = _in.nextInt();
                    _in.nextLine();
                    System.out.println("Ingrese el slot en que lo quiere guardar. - De 1 a 12 - ");
                    int slotPosFM = _in.nextInt();
                    _in.nextLine();
                    if (miRadio.getFrequence().equals("AM")) {
                        miRadio.saveAMStation(freqFM, slotPosFM-1);
                    }
                    break;                


                case 8:
                    System.out.println("Ingrese el número de slot que desea ver. - Entre 1 a 12 - ");
                    int slotAM = _in.nextInt();
                    _in.nextLine();
                    if (miRadio.getFrequence().equals("AM")) {
                        miRadio.getAMSlot(slotAM-1);
                    }
                    break;

                case 9:
                    System.out.println("Ingrese el número de slot que desea ver. - Entre 0 a 12 - ");
                    int slotFM = _in.nextInt();
                    _in.nextLine();
                    if (miRadio.getFrequence().equals("FM")) {
                        miRadio.getAMSlot(slotFM);
                    }
                    break;

                case 10:
                    System.out.println("Si desea apagar ingrese 1 si desea encender ingrese 2");
                    int op = _in.nextInt();
                    _in.nextLine();
                    if (op == 1) {
                        miRadio.off();
                        break;
                    }else{
                        miRadio.on();
                        break;
                    }

                default:
                    System.out.println("Ingeso una opcion invalida \n");
            }
        }
    } while (opcion <= 10);
}
}
