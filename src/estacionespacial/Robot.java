
package estacionespacial;

public class Robot extends Thread {
    int idRobot;
    String nombre;
    Herramienta herramienta;

    public Robot(int idRobot, String nombre, Herramienta herramienta) {
        this.idRobot = idRobot;
        this.nombre = nombre;
        this.herramienta = herramienta;
    }
    

    @Override
    public void run() {
         
         while(herramienta.numPiezasColocadas < herramienta.MAX_PIEZAS){
         herramienta.cogerDestornillador(this);
         herramienta.cogerEquilibrador(this);
         
         herramienta.colocarPieza(this);
         
         herramienta.dejarDestornillador(this);
         herramienta.dejarEquilibrador(this);
         }
         Thread.yield();
        
    }

    
    
    
    
}
