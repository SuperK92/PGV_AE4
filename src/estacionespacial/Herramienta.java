
package estacionespacial;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Herramienta {
    final int MAX_DESTORNILLADORES = 3;
    int numDestornilladores = MAX_DESTORNILLADORES;
    final int MAX_EQUILIBRADORES = 3;
    int numEquilibradores = MAX_EQUILIBRADORES;
    final int MAX_PIEZAS = 100;
    int numPiezasColocadas = 0;

    
    public synchronized void dejarDestornillador(Robot robot){
        while(numDestornilladores == MAX_DESTORNILLADORES){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Herramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numDestornilladores++;
        System.out.println("" + robot.nombre + " ha dejado el destornillador.");
        System.out.println("Nº destornilladores disponibles: " + numDestornilladores);
        notifyAll();
    }
    
    public synchronized void cogerDestornillador(Robot robot){
        while(numDestornilladores == 0){
            try {
                System.out.println("" + robot.nombre + " está esperando por un destornillador.");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Herramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numDestornilladores--;
        System.out.println("" + robot.nombre + " ha cogido el destornillador.");
        System.out.println("Nº destornilladores disponibles: " + numDestornilladores);
        notifyAll();
    }
    
    public synchronized void dejarEquilibrador(Robot robot){
        while(numEquilibradores == MAX_EQUILIBRADORES){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Herramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numEquilibradores++;
        System.out.println("" + robot.nombre + " ha dejado el equilibrador.");
        System.out.println("Nº equilibradores disponibles: " + numEquilibradores);
        notifyAll();
    }
    
    public synchronized void cogerEquilibrador(Robot robot){
        while(numEquilibradores == 0){
            try {
                System.out.println("" + robot.nombre + " está esperando por un equilibrador.");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Herramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numEquilibradores--;
        System.out.println("" + robot.nombre + " ha cogido el equilibrador.");
        System.out.println("Nº equilibradores disponibles: " + numEquilibradores);
        notifyAll();
    }
    
    public synchronized void colocarPieza(Robot robot){
        if(numPiezasColocadas < MAX_PIEZAS){
            numPiezasColocadas++;
            System.out.println("" + robot.nombre + " ha colocado una pieza.");
            System.out.println("Nº piezas colocadas: " + numPiezasColocadas);
        }
    }
}
