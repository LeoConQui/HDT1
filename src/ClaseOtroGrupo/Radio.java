/**
 * Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 1
 * 16-01-2023
 * Clase Radio: modela un radio, implementa la interface IRadio y define lo que hace cada método. 
 */

public class Radio implements IRadio{

    //Atributos
    private String frequence;
    private double fMActualStation;
    private int aMActualStation;
    private int[] slotsAM;
    private double[] slotsFM;
    private boolean encendido;

    //constructores

    public Radio() {
        frequence = "FM";
        fMActualStation = 87.9;
        aMActualStation = 530;
        slotsAM = new int[12];
        slotsFM = new double[12];
        encendido = false;
    }


    public Radio(String frequence, double fMActualStation, int aMActualStation, int[] slotsAM, double[] slotsFM, boolean encendido) {
        this.frequence = frequence;
        this.fMActualStation = fMActualStation;
        this.aMActualStation = aMActualStation;
        this.slotsAM = slotsAM;
        this.slotsFM = slotsFM;
        this.encendido = encendido;
    }

    //Métodos
    
    @Override
    public void on() {
        // TODO Auto-generated method stub
        this.encendido = true;
    }

    @Override
    public void off() {
        // TODO Auto-generated method stub
        this.encendido = false;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isOn() {
        // TODO Auto-generated method stub
        return encendido;
    }

    
    /** 
     * @param freq
     * @throws Exception
     */
    @Override
    public void setFrequence(String freq) throws Exception {
        // TODO Auto-generated method stub
        if(freq.equalsIgnoreCase("AM") || freq.equalsIgnoreCase("FM")){
            this.frequence = freq.toUpperCase();
        }
    }

    
    /** 
     * @return String
     */
    @Override
    public String getFrequence() {
        // TODO Auto-generated method stub
        return frequence;
    }

    @Override
    public void Forward() {
        // TODO Auto-generated method stub
        if (this.getFrequence() == "AM" && this.getAMActualStation() < 1610){
            aMActualStation = aMActualStation + 10;
        }
        else if (this.getFrequence() == "AM" && this.getAMActualStation() == 1610){
            aMActualStation = 530;
        }
        else if (this.getFrequence() == "FM" && this.getFMActualStation() < 107.9){
            this.setFMActualStation(fMActualStation + 0.200000000000000000000000000000000000);
        }
        else if (this.getFrequence() == "FM" && this.getFMActualStation() == 107.9){
            this.setFMActualStation(87.9);
        } 
    }

    @Override
    public void Backward() {
        // TODO Auto-generated method stub
        if (this.getFrequence() == "AM" && this.getAMActualStation() > 530){
            aMActualStation = aMActualStation - 10;
        }
        else if (this.getFrequence() == "AM" && this.getAMActualStation() == 530){
            aMActualStation = 1610;
        }
        else if (this.getFrequence() == "FM" && this.getFMActualStation() > 87.9){
            fMActualStation = fMActualStation - 0.2;
        }
        else if (this.getFrequence() == "FM" && this.getFMActualStation() == 87.9){
            fMActualStation = 107.9;
        } 
        
    }

    
    /** 
     * @return double
     */
    @Override
    public double getFMActualStation() {
        // TODO Auto-generated method stub
        return this.fMActualStation;
    }

    
    /** 
     * @return int
     */
    @Override
    public int getAMActualStation() {
        // TODO Auto-generated method stub
        return this.aMActualStation;
    }

    
    /** 
     * @param actualStation
     */
    @Override
    public void setFMActualStation(double actualStation) {
        // TODO Auto-generated method stub
        this.fMActualStation = actualStation;
        
    }

    
    /** 
     * @param actualStation
     */
    @Override
    public void setAMActualStation(int actualStation) {
        // TODO Auto-generated method stub
        this.aMActualStation = actualStation;
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveFMStation(double actualStation, int slot) {
        // TODO Auto-generated method stub
        this.slotsFM[slot] = actualStation;
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveAMStation(int actualStation, int slot) {
        // TODO Auto-generated method stub
        this.slotsAM[slot] = actualStation;
    }

    
    /** 
     * @param slot
     * @return double
     */
    @Override
    public double getFMSlot(int slot) {
        // TODO Auto-generated method stub
        return slotsFM[slot];
    }

    
    /** 
     * @param slot
     * @return int
     */
    @Override
    public int getAMSlot(int slot) {
        // TODO Auto-generated method stub
        return slotsAM[slot];
    }
    
}
