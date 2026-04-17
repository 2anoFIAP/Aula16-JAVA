package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Veiculo {
    private String modelo;
    private LocalDate dataCompra;
    private double valorCompra;

    public Veiculo() {
    }

    public Veiculo(String modelo, LocalDate dataCompra, double valorCompra) {
        this.modelo = modelo;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int calcularIdadeVeicular() {
        LocalDate dataAtual = LocalDate.now();
        Period dataFinal = Period.between(dataCompra, dataAtual);
        return dataFinal.getYears();
    }

    public double calcularValorAtual() {
        int idade = calcularIdadeVeicular();
        if (idade > 9) {
            JOptionPane.showMessageDialog(null, "ERRO: IDade do veiculo (" + idade + " anos) excede o limite de 9 anos.");
            System.exit(0);
        } else {
            double taxaDepreciado = idade * 0.10;
            double valorDepreciado = valorCompra * taxaDepreciado;
            return valorCompra - valorDepreciado;
        }
        return 0;
    }
}
