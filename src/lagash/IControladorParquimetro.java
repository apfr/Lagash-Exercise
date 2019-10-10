
package lagash;

/**
 *
 * @author Agustina
 */

public interface IControladorParquimetro {      
    
    //public Integer autoDetectado(String patente, int minutosEstacionado);    
    public void autoDetectado(String patente);
    public void avanzarMinutos();
    public void estacionamientoFinalizado();

}
