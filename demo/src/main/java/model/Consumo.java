package model;

public class Consumo{
    String date;
    String type;
    Double fuel;
    Double kilometers;
    Double rendimento;

    public Consumo(){}

    public Consumo(String date, String type, Double fuel, Double kilometers) {
        this.date = date;
        this.type = type;
        this.fuel = fuel;
        this.kilometers = kilometers;
        this.rendimento = kilometers/fuel;
    }
    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getFuel() {
        return fuel;
    }
    public void setFuel(Double fuel) {
        this.fuel = fuel;
    }
    public Double getKilometers() {
        return kilometers;
    }
    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }
}