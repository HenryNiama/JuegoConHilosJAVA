//se crea la clase clsJugador1 y toda la funcionalidad de la misma con
//herencia de la clase Thread
package Logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class clsJugador1 extends Thread {

    private int numero; //atributo para definir el número de jugador.
    private String nombre; //atributo para definir el nombre del jugador
    private boolean continuar = true;//flag para saber si continua el procedimiento

    public clsJugador1() {//implementación del constructor.
        numero = 1;
        nombre = JOptionPane.showInputDialog(null, "Digite el nombre del jugador 1: ");
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    //declara una variable objeto de tipo FormaHilos
    public Fisico.FormaHilos formHilo;

    //constructor que recibe por defecto el formulario FormaHilos y lo asigna a formHilo.
    public clsJugador1(Fisico.FormaHilos aThis) {
        formHilo = aThis;
    }

    //metodo que detiene la ejecucion del hilo
    public void detenerHilo() {
        continuar = false;
    }

    @Override//Se sobreescribe el metodo run()
    public void run() {
        while (continuar) {//Hagase mientras continuar sea verdadero

            try {
                //Establece el avance del jugador1: 
                int avance = (int) (Math.random() * 4);
                //invoca al método moverJugador1 que se encuentra en el formulario FormaHilos
                formHilo.moverJugador1(avance);
                //Para validar si se debe continuar;
                continuar = formHilo.seguir;
                //Descanza por 15 segundos
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(clsJugador1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
