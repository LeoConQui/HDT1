import java.util.Scanner;
public class IRadio {
    private Scanner _in;
    private IRadio miRadio;
    
    public RadioConsoleUI(Scanner _scanner, IRadio _radio) {
        _in = _scanner;
        miRadio = _radio;
    }

    do {

        System.println("********************************************");
        System.println("*                                          *");
        System.println("*                   MENU                   *");
        System.println("*                                          *");
        System.println("*  1.  Seleccion de la frecuencia          *");
        System.println("*  2.  Cambiar emisora (adelante)          *");
        System.println("*  3.  Cambiar emisora (atras)             *");
        System.println("*  4.  Emisora AM actual                   *");
        System.println("*  5.  Emisora FM actual                   *");
        System.println("*  6.  Guardar emisora AM actual en # slot *");
        System.println("*  7.  Guardar emisora FM actual en # slot *");
        System.println("*  8.  Obtener # slot AM                   *");
        System.println("*  9.  Obtener # slot FM                   *");
        System.println("*  10. Desea encender/apgar                *");
        System.println("*                                          *");
        System.println("********************************************");
        System.println("\n");

        while (this.encendido == true) {
            System.println("Ingrese una opcion");
            int opcion = _in.nextInt();
            switch (opcion) {
                case 1:
                    setFrequence();
                    break;
                case 2:
                    Forward();
                    break;
                case 3:
                    Backward();
                    break;
                case 4:
                    getAMActualStation();
                    break;
                case 5:
                    getFMActualStation();
                    break;  
                case 6:
                    saveAMStation();
                    break;
                case 7:
                    saveFMStation();
                    break;
                case 8:
                    getAMSlot();
                    break;
                case 9:
                    getFMSlot();
                    break;
                case 10:
                    System.println("Si desea apagar ingrese 1 si desea envender ingrese 2");
                    int op = _in.nextInt();
                    if (op == 1) {
                        off();
                        break;
                    }else{
                        on();
                        break;
                    }

                default:
                    System.println("Ingeso una opcion invalida \n");
            }
        }
    }while (opcion != 10);
}
