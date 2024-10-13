/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultorio;

import java.util.Date;

/**
 *
 * @author Antonio Atienza Cano
 */
public class Cita {

    private int dniPa;
    private int dniMe;
    private Date fecha;
    private int hora;

    // constructor de copia
    public Cita() {

    }

    public Cita(int dniPa, int dniMe, Date fecha, int hora) {
        if (!calcularLetraDNI(dniPa)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        if (!calcularLetraDNI(dniMe)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        if (hora > 0 || hora > 24) {
            throw new IllegalArgumentException("la hora introducida no es valida");
        }
        this.dniPa = dniPa;
        this.dniMe = dniMe;
        this.fecha = fecha;
        this.hora = hora;
    }

    // contructor de copia
    public Cita(Cita otraCita) {
        this.dniMe = otraCita.dniMe;
        this.dniPa = otraCita.dniPa;
        this.fecha = otraCita.fecha;
        this.hora = otraCita.hora;
    }

    public int getDniPa() {
        return dniPa;
    }

    public void setDniPa(int dniPa) {
        if (!calcularLetraDNI(dniPa)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        this.dniPa = dniPa;
    }

    public int getDniMe() {
        return dniMe;
    }

    public void setDniMe(int dniMe) {
        if (!calcularLetraDNI(dniMe)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        this.dniMe = dniMe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora > 0 || hora > 24) {
            throw new IllegalArgumentException("la hora introducida no es valida");
        }
        this.hora = hora;
    }

    private static boolean calcularLetraDNI(int dni) {
        int indice = dni % 23;
        if (indice >= 0 && indice <= 23) {
            return true;
        } else {
            return false;
        }
    }

    // mostrar cita
    @Override
    public String toString() {
        return "Cita{" + "dniPa=" + dniPa + ", dniMe=" + dniMe + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

}
