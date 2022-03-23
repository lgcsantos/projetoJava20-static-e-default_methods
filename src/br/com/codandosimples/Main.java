package br.com.codandosimples;


interface Veiculo {
    String getModelo();
    void acelerar();
    void desacelerar();

    default String ligarAlarme(){
        return "Ligando Alarme do Veiculo";
    }

    default String desligarAlarme(){
        return "Desligando Alarme do Veiculo";
    }

    static int calcularCavalosDePotencia( int rpm, int toque){
        return ( rpm * toque )/ 5254;
    }
}

interface Alarme {

    default String ligarAlarme(){
        return "Ligando Alarme";
    }

    default String desligarAlarme(){
        return "Desligar Alarme";
    }

}

class Carro implements Veiculo, Alarme {
    private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }  // CONSTRUTOR

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando...");
    }

    @Override
    public void desacelerar() {
        System.out.println("O carro está desacelerando...");
    }

    @Override
    public String ligarAlarme() {
        return Veiculo.super.ligarAlarme();
    }

    @Override
    public String desligarAlarme() {
        return Alarme.super.desligarAlarme();
    }
}


public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Porsche");
        System.out.println(carro.getModelo());

        carro.acelerar();
        carro.desacelerar();

        System.out.println(carro.ligarAlarme());
        System.out.println(carro.desligarAlarme());

        System.out.println(Veiculo.calcularCavalosDePotencia(2500,480));
    }
}
