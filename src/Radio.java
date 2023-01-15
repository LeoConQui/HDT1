/** La clase radio modela la radio que se debe implementar en la HDT1
 * @author Leonel Contreras 18797
 * @version 1.0
 */

 public class Radio implements IRadio{
    
    // atributos 
    private boolean encendido; 

    private String frequence;

    private double actualFMstation;

    private int actualAMstation; 

    private int[] savedAMstations;

    private double[] savedFMstations;

    // metodos

    public  Radio() {
        // por defecto el radio inicia encendido
        this.encendido = true;

        // la radio inicia por defecto en la frecuencia AM
        this.frequence = "AM";

        // la radio inicia por defecto en la estacion 530
        this.actualAMstation = 530;

        // incializamos las listas de estaciones AM y FM, ambas con 12 slots disponibles
        this.savedAMstations = new int[12];
        this.savedFMstations = new double[12];
    }

    @Override
    public void on(){
        this.encendido = true;
    }

    @Override
    public void off() {
        this.encendido = false;
    }

    @Override
    public boolean isOn() {
        if (encendido) {
            return encendido;
        }else{
            return false;
        }
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        if (freq.equals("AM") || freq.equals("FM") ) {
            this.frequence = freq;
        }else{
            throw new Exception("La frecuencia ingresada no es valida");
        }
    }

    @Override
    public String getFrequence() {
        return this.frequence;
    }

    @Override 
    public void Forward() {
        // verificamos en que fracuencia esta el radio
        if (frequence.equals("AM")) {
            // si la frecuencia es AM, es step es de 10
            this.actualAMstation += 10;
            // cuando llega al maximo del rango, se retorna a la primera estacion
            if(this.actualAMstation >=1610){
                this.actualAMstation = 530;
            }
        }else{
            // si la frecuencia es FM, el step es de 0.2
            this.actualFMstation += 0.2;
            // si llegamos al maximo de rango, se retorna a la primera estacion
            if (this.actualFMstation>=107.9) {
                this.actualFMstation = 87.9;
            }
        }
    }

    @Override
    public void Backward() {
        // verificamos en que frecuencia esta el radio
        if (frequence.equals("AM")) {
            // si la frecuncia es AM, el step es de 10
            this.actualAMstation -= 10;
            // cuando llegamos al minimo del rango, nos vamos a la ultima estacion
            if (this.actualAMstation<=530) {
                this.actualAMstation = 1610;
            }
        } else {
            // si la frecuencia es FM, el step es de 0.2
            this.actualFMstation -= 0.2;
            // cuando llegamos al minimo del rango, nos vamos a la ultima estacion
            if (this.actualFMstation<=87.9) {
                this.actualFMstation = 107.9;
            }
        }
    }

    @Override
    public double getFMActualStation() {
        return this.actualFMstation;
    }

    @Override
    public int getAMActualStation() {
        return this.actualAMstation;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        this.actualFMstation = actualStation;
    }

    @Override
    public void setAMActualStation(int actualStation) {
        this.actualAMstation = actualStation;
    }

    @Override
    public void saveFMStation(double actualStation, int slot){
        this.savedFMstations[slot] = actualStation;
    }

    @Override
    public void saveAMStation(int actualStation, int slot){
        this.savedAMstations[slot] = actualStation;
    }

    @Override
    public double getFMSlot(int slot){
        return this.savedFMstations[slot];
    }

    @Override
    public int getAMSlot(int slot){
        return this.savedAMstations[slot];
    }

}