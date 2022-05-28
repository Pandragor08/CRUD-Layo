package com.example.mydrugs;

public class Medicamento {
    int id;
    String medicamento,matricula,precio;

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", medicamento='" + medicamento + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
