package lagash;

/**
 *
 * @author Agustina
 */
public class Main {

    public static void main(String[] args) {

        String email = "";
        
        
        //---------------------- CLIENTE 1 (devuelve null y 0 porque no hay auto detectado) -----------------------------
        System.out.println("\n-------------------------------------------------------------- CLIENTE 1 --------------------------------------------------------------\n");
        ServicioExterno SE1 = new ServicioExterno(false);

        //AUTO DETECTADO        
        System.out.println("> Auto detectado: \n");

        //AUTO DETECTADO PROCEDIMIENTO
        SE1.autoDetectado(SE1.getPatente());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");

        //AUTO DETECTADO FUNCIÓN
        //SE1.autoDetectado(SE1.getPatente(), SE1.getMinutosEstacionado());
        
        //AUTO NO ESTACIONADO       
        SE1.autoNoEstacionado(SE1.getPatente(), SE1.getMinutosEstacionado());
        
//        //ESTACIONAMIENTO FINALIZADO    
//        System.out.println("\n> Estado estacionamiento: \n");
//        SE1.estacionamientoFinalizado();

        
        
        
        // ---------------------- CLIENTE 2 -----------------------------
        System.out.println("\n-------------------------------------------------------------- CLIENTE 2 --------------------------------------------------------------");
        ServicioExterno SE2 = new ServicioExterno("RTX570", 59, 400, "juanabr@gmail.com", true);
        
        // AUTO DETECTADO
        System.out.println("\n> Auto detectado: \n");
        
        //AUTO DETECTADO PROCEDIMIENTO
        SE2.autoDetectado(SE2.getPatente());
        
        //AUTO DETECTADO FUNCIÓN
        //SE2.autoDetectado(SE2.getPatente(), SE2.getMinutosEstacionado());
        
        //AUTO NO ESTACIONADO       
        SE2.autoNoEstacionado(SE2.getPatente(), SE2.getMinutosEstacionado());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");
        

        System.out.println("\n> Obtener email por patente: \n");
        email = ServicioExterno.obtenerEmailPorPatente(SE2.getPatente());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");

        // ENVIAR MAIL     
        System.out.println("\n> Enviar mail: \n");
        ServicioExterno.enviarMail("Asunto: Importe a pagar\n", "\tCuerpo: ", SE2.getEmail());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");
        
        // ESTACIONAMIENTO FINALIZADO    
        System.out.println("\n> Estado estacionamiento: \n");
        SE2.estacionamientoFinalizado();
        System.out.println("\n");
        
        //AVANZAR MINUTOS   -- ejemplo
        System.out.println("\n> Minutos avanzados: \n");
        SE2.avanzarMinutos();
        
        
        

        //---------------------- CLIENTE 3 -----------------------------
        System.out.println("\n-------------------------------------------------------------- CLIENTE 3 --------------------------------------------------------------");
        ServicioExterno SE3 = new ServicioExterno("QWR789", 70, 800, "julian123@gmail.com", false);
        
        // AUTO DETECTADO
        System.out.println("\n> Auto detectado: \n");
        
        //AUTO DETECTADO PROCEDIMIENTO
        SE3.autoDetectado(SE3.getPatente());
        
        //AUTO DETECTADO FUNCIÓN
        //SE3.autoDetectado(SE3.getPatente(), SE3.getMinutosEstacionado());
        
        //AUTO NO ESTACIONADO       
        SE3.autoNoEstacionado(SE3.getPatente(), SE3.getMinutosEstacionado());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");
        

        System.out.println("\n> Obtener email por patente: \n");
        email = ServicioExterno.obtenerEmailPorPatente(SE3.getPatente());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");
        
        // ENVIAR MAIL      
        System.out.println("\n> Enviar mail: \n");
        ServicioExterno.enviarMail("Asunto: Importe a pagar\n", "\nCuerpo: ", SE3.getEmail());
        System.out.println("\t\t\t\t\t\t\t\t----------------------------------");

        // ESTACIONAMIENTO FINALIZADO        
        System.out.println("\n> Estado estacionamiento: \n");
        SE3.estacionamientoFinalizado();
        
        System.out.println("\n");
    }

}
