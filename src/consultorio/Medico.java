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
public class Medico implements Serializable {

    private int dniMe;
    private String nombreMe;
    private String apellidoMe1;
    private String apellidoMe2;
    private int cod_consul;

    // constructor por defecto
    public Medico() {

    }
    // constructor parametrizado 

    public Medico(int dniMe, String nombreMe, String apellidoMe1, String apellidoMe2, int cod_consul) {
        if (!calcularLetraDNI(dniMe)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        if (nombreMe.length() > 20 || !validarTexto(nombreMe)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        if (apellidoMe1.length() > 40 || !validarTexto(apellidoMe1)) {
            throw new IllegalArgumentException("El primer apellido no es válido.");
        }
        if (apellidoMe2.length() > 40 || !validarTexto(apellidoMe2)) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        if (cod_consul > 999) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }

        this.dniMe = dniMe;
        this.nombreMe = nombreMe;
        this.apellidoMe1 = apellidoMe1;
        this.apellidoMe2 = apellidoMe2;
        this.cod_consul = cod_consul;
    }

    // constructor de copia 
    public Medico(Medico otroMedico) {
        this.dniMe = otroMedico.dniMe;
        this.nombreMe = otroMedico.nombreMe;
        this.apellidoMe1 = otroMedico.apellidoMe1;
        this.apellidoMe2 = otroMedico.apellidoMe2;
        this.cod_consul = otroMedico.cod_consul;
    }

    public Integer getDniMe() {
        return dniMe;
    }

    public void setDniMe(int dniMe) {
        if (!calcularLetraDNI(dniMe)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        this.dniMe = dniMe;
    }

    public String getNombreMe() {
        return nombreMe;
    }

    public void setNombreMe(String nombreMe) {
        if (nombreMe.length() > 20 || !validarTexto(nombreMe)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }

        this.nombreMe = nombreMe;
    }

    public String getApellidoMe1() {
        return apellidoMe1;
    }

    public void setApellidoMe1(String apellidoMe1) {
        if (apellidoMe1.length() > 40 || !validarTexto(apellidoMe1)) {
            throw new IllegalArgumentException("El primer apellido no es válido.");
        }
        this.apellidoMe1 = apellidoMe1;
    }

    public String getApellidoMe2() {
        return apellidoMe2;
    }

    public void setApellidoMe2(String apellidoMe2) {
        if (apellidoMe2.length() > 40 || !validarTexto(apellidoMe2)) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        this.apellidoMe2 = apellidoMe2;
    }

    public int getCod_consul() {
        return cod_consul;
    }

    public void setCod_consul(int cod_consul) {
        if (cod_consul > 999) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        this.cod_consul = cod_consul;
    }

    // metodo para validar una cadena de texto mediante una expresion regular
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

    // mostrar medico 
    @Override
    public String toString() {
        return "Medico{" + "dniMe=" + dniMe + ", nombreMe=" + nombreMe + ", apellidoMe1=" + apellidoMe1 + ", apellidoMe2=" + apellidoMe2 + ", cod_consul=" + cod_consul + '}';
    }

}
