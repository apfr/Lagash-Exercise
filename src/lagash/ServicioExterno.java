package lagash;

/**
 *
 * @author Agustina
 */
public class ServicioExterno implements IControladorParquimetro {

    private String patente;                         // consulta la patente del auto actualmente estacionado
    private static int minutosEstacionado;          // consulta los minutos que lleva estacionado el auto actual   
    private int centavosPorHora;                    // consulta o establece el precio por hora de estacionamiento
    private static String email = "";
    private boolean abonado;

    // CONSTRUCTORES
    public ServicioExterno() {
    }

    public ServicioExterno(boolean abonado) {
        this.abonado = abonado;
    }  
    
    public ServicioExterno(String patente, int minutosEstacionado, int centavosPorHora, String email, boolean abonado) {
        this.patente = patente;
        this.minutosEstacionado = minutosEstacionado;
        this.centavosPorHora = centavosPorHora;
        this.email = email;
        this.abonado = abonado;
    }

    // GETTERS Y SETTERS
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getMinutosEstacionado() {
        return minutosEstacionado;
    }

    public void setMinutosEstacionado(int minutosEstacionado) {
        this.minutosEstacionado = minutosEstacionado;
    }

    public int getCentavosPorHora() {
        return centavosPorHora;
    }

    public void setCentavosPorHora(int centavosPorHora) {
        this.centavosPorHora = centavosPorHora;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAbonado() {
        return abonado;
    }

    public void setAbonado(boolean abonado) {
        this.abonado = abonado;
    }



    // MÉTODOS
    public static String obtenerEmailPorPatente(String patente) {
        ServicioExterno.email = email;
        System.out.print("\tPatente " + patente + " con email: " + email + "\n");
        return email;
    }

    public static void enviarMail(String asunto, String cuerpo, String destinatario) {
        System.out.println("\t" + asunto);
        System.out.println("\tCuerpo: ");
        System.out.println("\t\t\t\t" + importeAPagar());
        System.out.println("\tDestinatario: " + destinatario);
    }

    public static String importeAPagar() {                 // se cobrarán $40 por hora   
        int importe = 0;
        String aux = "";

        if (minutosEstacionado <= 60) {
            importe = 40;
            System.out.println("\tTiempo utilizado en el estacionamiento: " + minutosEstacionado + " minutos. \n\tSe deben abonar $" + importe + " pesos.");
        } else if (minutosEstacionado > 60 && minutosEstacionado <= 120) {
            importe = 80;
            System.out.println("\tTiempo utilizado en el estacionamiento: " + minutosEstacionado + " minutos. \n\tSe deben abonar $" + importe + " pesos.");
        }
        return aux;
    }

    // MÉTODOS HEREDADOS DE LA INTERFAZ      
    
    // AUTO NO ESTACIONADO    

    public Integer autoNoEstacionado(String patente, int minutosEstacionado) {      // notifica al parquímetro del evento de detección de un nuevo auto estacionado  
        try {
            if (patente.equals(null) && minutosEstacionado == 0) {
                
                if (patente.equals(null)) {
                    return null;
                    
                } else if (minutosEstacionado == 0) {
                    return 0;                    
                }
                    System.out.println(getPatente());
                    System.out.println(getMinutosEstacionado());
                }

        } catch (NullPointerException e) {
            System.out.println(patente);
            System.out.println(minutosEstacionado);
        }
        return 0;
    }
    
    
    // AUTO DETECTADO PROCEDIMIENTO
    @Override
    public void autoDetectado(String patente){
        System.out.println("\tNuevo auto ingresado al estacionamiento: " + patente);
    }
    
    // AUTO DETECTADO FUNCIÓN
    
//    @Override
//    public Integer autoDetectado(String patente, int minutosEstacionado) {      // notifica al parquímetro del evento de detección de un nuevo auto estacionado  
//        try {
//            if (patente.equals(null) && minutosEstacionado == 0) {
//                
//                if (patente.equals(null)) {
//                    return null;
//                    
//                } else if (minutosEstacionado == 0) {
//                    return 0;                    
//                }
//                    System.out.println(getPatente());
//                    System.out.println(getMinutosEstacionado());
//                }
//
//        } catch (NullPointerException e) {
//            System.out.println(patente);
//            System.out.println(minutosEstacionado);
//        }
//
//        System.out.println("Nuevo auto ingresado al estacionamiento: " + patente);
//        return 0;
//    }
    
    
    // AVANZAR MINUTOS
    @Override
    public void avanzarMinutos() {                   // notifica al parquímetro que avanzó un minuto
        minutosEstacionado = 0;  
        
        for(int i = 0; i < 59; i++){
            minutosEstacionado++;
            System.out.println("El auto con patente " + getPatente() + " ha avanzado: " + minutosEstacionado + " minutos.");    
        }     
    }
    
    // ESTACIONAMIENTO FIN
    @Override
    public void estacionamientoFinalizado() {        //notificar al parquímetro que el auto estacionado se retiró
        boolean abonado = false;
        
        if(isAbonado() != true){        // FALSE
            System.out.println("\tAún no abona su estacionamiento. Por favor revise su casilla de emails.");
        }        
        if(isAbonado() != false) {      // TRUE
            System.out.println("\tCliente abonó servicio. Estacionamiento finalizado.");
        } 
    }
}
