import javax.swing.plaf.synth.SynthPasswordFieldUI;

/**
 * Principal es la clase que interactua con el usuario
 * @author Leonel Contreras 18797
 */

import java.util.Scanner;
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Radio miradio = new Radio();

        System.out.println("Menu");
        // declaramos dos variables scanner 
        Scanner texto = new Scanner(System.in);
        Scanner numero = new Scanner(System.in);

        int opcion = 0;

        while (opcion!=8) {
            System.out.println(" ");
            System.out.println("1. Seleccionar frequencia");
            System.out.println("2. Cambiar emisora (adelante)");
            System.out.println("3. Cambiar emisora (atras)");
            System.out.println("4. Emisora actual");
            System.out.println("5. Guardar emisora en slot");
            System.out.println("6. Obtener numero de slot");
            System.out.println("7. Apagar o Encender la radio");
            System.out.println("8. Salir");
            System.out.println(" ");

            System.out.println("Ingrese una opcion");
            opcion = numero.nextInt();

            if (opcion ==1 && miradio.isOn()== true) {
                try {
                    System.out.println("Ingrese AM o FM");
                    String freq = texto.nextLine();
                    miradio.setFrequence(freq);
                    System.out.println("Se ha puesto la radio en la frecuencia " + miradio.getFrequence());
                    if (miradio.getFrequence().equals("FM")) {
                        miradio.setFMActualStation(87.9);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else if(opcion == 1 && miradio.isOn() == false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion ==2 && miradio.isOn()==true) {
                miradio.Forward();
                if(miradio.getFrequence().equals("AM")){
                    System.out.println("Se ha cambiado a la estacion: " + miradio.getAMActualStation());
                }else{
                    System.out.println("Se ha cambiado a la estacion " + miradio.getFMActualStation());
                }
            }else if(opcion == 2 && miradio.isOn()==false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion == 3 && miradio.isOn()==true) {
                miradio.Backward();
                if (miradio.getFrequence().equals("AM")) {
                    System.out.println("Se ha cambiado a la estacion " + miradio.getAMActualStation());
                }else{
                    System.out.println("Se ha cambiado a la estacion " + miradio.getFMActualStation());
                }
            }else if(opcion == 3 && miradio.isOn()==false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion == 4 && miradio.isOn()== true) {
                if (miradio.getFrequence().equals("AM")) {
                    System.out.println("Usted esta en la frecuencia AM y la emisora actual es: " + miradio.getAMActualStation());
                }else{
                    System.out.println("Usted esta en la frecuencia FM y la emisora actual es: " + miradio.getFMActualStation());
                }
            }else if(opcion == 4 && miradio.isOn()==false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion == 5 && miradio.isOn()==true) {
                if (miradio.getFrequence().equals("AM")) {
                    System.out.println("Ingrese la estacion a guardar");
                    int estacion = numero.nextInt();
                    System.out.println("Ingrese el slot");
                    int slot = numero.nextInt();
                    miradio.saveAMStation(estacion, slot);
                    System.out.println("Se ha guardado la estacion con exito");
                }else{
                    System.out.println("Ingrese la estacion a guardar");
                    double estacion = numero.nextDouble();
                    System.out.println("Ingrese el slot");
                    int slot = numero.nextInt();
                    miradio.saveFMStation(estacion, slot);
                    System.out.println("Se ha guardado la estacion con exito");
                }
            }else if(opcion == 5 && miradio.isOn()==false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion ==6 && miradio.isOn()==true) {
                System.out.println("Ingrese el slot que desea ver");
                int slot = numero.nextInt();
                if (miradio.getFrequence().equals("AM")) {
                    System.out.println("La estacion en el slot " + slot + " es: "+miradio.getAMSlot(slot)+ " AM");
                }else{
                    System.out.println("La estacion en el slot " + slot + " es: "+miradio.getFMSlot(slot)+ " FM");
                }
            }else if(opcion == 6 && miradio.isOn()==false){
                System.out.println("La radio se encuentra apagada");
            }

            if (opcion ==7) {
                System.out.println("1. Apagar la radio");
                System.out.println("2. Encender la radio");

                int boton = numero.nextInt();
                if (boton == 1) {
                    miradio.off();
                    System.out.println("Usted ha apagado la radio");
                }else{
                    miradio.on();
                    System.out.println("Usted ha encendido la radio");
                }
            }
        }
        System.out.println(" Salir");
    }
}