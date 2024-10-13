/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultorio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza Cano
 */
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private int dniPa;
    private String nombrePa;
    private String apellidoPa1;
    private String apellidoPa2;
    private int tlf;

    // contructor por defecto
    public Paciente() {
    }

    // constructor parametrizado
    public Paciente(int dniPa, String nombrePa, String apellidoPa1, String apellidoPa2, int tlf) {
        if (!calcularLetraDNI(dniPa)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        if (nombrePa.length() > 20 || !validarTexto(nombrePa)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        if (apellidoPa1.length() > 40 || !validarTexto(apellidoPa1)) {
            throw new IllegalArgumentException("El primer apellido no es válido.");
        }
        if (apellidoPa2.length() > 40 || !validarTexto(apellidoPa2)) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        if (!validarNumeroTelefono(tlf)) {
            throw new IllegalArgumentException("El telefono no es valido.");
        }

        this.dniPa = dniPa;
        this.nombrePa = nombrePa;
        this.apellidoPa1 = apellidoPa1;
        this.apellidoPa2 = apellidoPa2;
        this.tlf = tlf;
    }

    // constructor de copia
    public Paciente(Paciente otroPaciente) {
        this.dniPa = otroPaciente.dniPa;
        this.nombrePa = otroPaciente.nombrePa;
        this.apellidoPa1 = otroPaciente.apellidoPa1;
        this.apellidoPa2 = otroPaciente.apellidoPa2;
        this.tlf = otroPaciente.tlf;
    }

    public Integer getDniPa() {
        return dniPa;
    }

    public void setDniPa(int dniPa) {
        if (!calcularLetraDNI(dniPa)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        this.dniPa = dniPa;
    }

    public String getNombrePa() {
        return nombrePa;
    }

    public void setNombrePa(String nombrePa) {
        if (nombrePa.length() > 20 || !validarTexto(nombrePa)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        this.nombrePa = nombrePa;
    }

    public String getApellidoPa1() {
        return apellidoPa1;
    }

    public void setApellidoPa1(String apellidoPa1) {
        if (apellidoPa1.length() > 40 || !validarTexto(apellidoPa1)) {
            throw new IllegalArgumentException("El primer apellido no es válido.");
        }
        this.apellidoPa1 = apellidoPa1;
    }

    public String getApellidoPa2() {
        return apellidoPa2;
    }

    public void setApellidoPa2(String apellidoPa2) {
        if (apellidoPa2.length() > 40 || !validarTexto(apellidoPa2)) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        this.apellidoPa2 = apellidoPa2;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        if (!validarNumeroTelefono(tlf)) {
            throw new IllegalArgumentException("El telefono no es valido.");
        }
        this.tlf = tlf;
    }

    public static boolean validarNumeroTelefono(int numeroTelefono) {
        // Convertir el número a cadena para poder verificar su longitud
        String numeroStr = String.valueOf(numeroTelefono);

        // Verificar que tenga exactamente 10 dígitos
        if (numeroStr.length() != 9) {
            return false;
        }

        // Verificar que todos los caracteres sean dígitos
        for (char c : numeroStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // metodo para validar una cadena de texto
    public static boolean validarTexto(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+(?:\\s[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
    // metodo para validar un dni

    private static boolean calcularLetraDNI(int dni) {
        int indice = dni % 23;
        if (indice >= 0 && indice <= 23) {
            return true;
        } else {
            return false;
        }
    }

    // Mostrar paciente
    @Override
    public String toString() {
        return "Paciente{" + "dniPa=" + dniPa + ", nombrePa=" + nombrePa + ", apellidoPa1=" + apellidoPa1 + ", apellidoPa2=" + apellidoPa2 + ", tlf=" + tlf + '}';
    }

}
