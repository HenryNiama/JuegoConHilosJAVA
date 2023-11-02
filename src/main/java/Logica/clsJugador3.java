/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class clsJugador3 extends Thread {

    private int numero; //atributo para definir el número de jugador.
    private String nombre; //atributo para definir el nombre del jugador
    private boolean continuar = true;//flag para saber si continua el procedimiento

    public clsJugador3() {//implementación del constructor.
        numero = 3;
        nombre = JOptionPane.showInputDialog(null, "Digite el nombre del jugador 3: ");
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
    public clsJugador3(Fisico.FormaHilos aThis) {
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
                //Establece el avance del jugador3: 
                int avance = (int) (Math.random() * 4);
                //invoca al método moverJugador3 que se encuentra en el formulario FormaHilos
                formHilo.moverJugador3(avance);
                //Para validar si se debe continuar;
                continuar = formHilo.seguir;
                //Descanza por 15 segundos
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(clsJugador3.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
