
package estacionespacial;

public class EstacionEspacial {

    public static void main(String[] args) {
        Herramienta herramienta = new Herramienta();
        
        for(int i = 0; i < 10; i++) {
            Robot robot = new Robot(i + 1, "Robot" + (i + 1), herramienta);
            robot.start();
        }
        
    }
    
}
