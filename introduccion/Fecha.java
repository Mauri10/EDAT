/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion;

/**
 *
 * @author Escritorio
 */
public class Fecha {
    //Atributos

    private int dia;
    private int mes;
    private int anio;

    //Constructores
    public Fecha() //constructor sin parÃ¡metros
    {
        dia = 1;
        mes = 1;
        anio = 1900;
    }

    public Fecha(int elDia, int elMes, int elAnio) {
        dia = elDia;
        mes = elMes;
        anio = elAnio;
    }

    //Observadores	
    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAnio() {
        return this.anio;
    }
    // modificadoras 

    public void setDia(int elDia) {
        if (elDia > 31 || elDia < 1) {
            dia = 0;
        } else {
            if (elDia < 29) {
                dia = elDia;
            } else {
                switch (elDia) {

                    case 29:
                        if (mes == 2) {
                            if (esBisiesto()) {
                                dia = elDia;
                            } else {
                                dia = 0;
                            }
                        } else {
                            dia = elDia;
                        }
                        break;

                    case 30:
                        if (mes == 2) {
                            dia = 0;
                        } else {
                            dia = elDia;
                        }
                        break;

                    case 31:
                        if (mes == 2 || mes == 11 || mes == 4 || mes == 6 || mes == 9) {
                            dia = 0;
                        } else {
                            dia = elDia;
                        }
                        break;
                }
            }
        }

    }

    public void setDia(int elDia, int elMes, int elAnio) {
        if (elDia > 31 || elDia < 1) {
            dia = 0;
        } else {
            if (elDia < 29) {
                dia = elDia;
            } else {
                switch (elDia) {
                    case 29:
                        if (elMes == 2) {
                            if (esBisiesto(elAnio)) {
                                dia = elDia;
                            } else {
                                dia = 0;
                            }
                        } else {
                            dia = elDia;
                        }
                        break;

                    case 30:
                        if (elMes == 2) {
                            dia = 0;
                        } else {
                            dia = elDia;
                        }
                        break;

                    case 31:
                        if (elMes == 2 || elMes == 11 || elMes == 4 || elMes == 6 || elMes == 9) {
                            dia = 0;
                        } else {
                            dia = elDia;
                        }
                        break;
                }
            }
        }

    }

    public void setMes(int elMes) {
        if (elMes > 0 && elMes < 13) {
            mes = elMes;
        } else {
            mes = 0;
        }
    }

    public void setAnio(int elAnio) {
        anio = elAnio;
    }

    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    public boolean esBisiesto(int elAnio) {
        boolean bisiesto = false;

        if ((elAnio % 4 == 0) && ((elAnio % 100 != 0) || (elAnio % 400 == 0))) {
            bisiesto = true;
        }

        return bisiesto;

    }

    public boolean esBisiesto() {
        boolean bisiesto = false;

        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
            bisiesto = true;
        }

        return bisiesto;

    }

    public boolean equals(Fecha otraFecha) {
        return this.dia == otraFecha.getDia() && this.mes == otraFecha.getMes() && this.anio == otraFecha.getAnio();

    }
}
