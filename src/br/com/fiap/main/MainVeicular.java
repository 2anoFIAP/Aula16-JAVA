package br.com.fiap.main;

import br.com.fiap.bean.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class MainVeicular {
    public static void main(String[] args) {
        Veiculo veiculo1;
        String aux, modelo;
        LocalDate dataCompra;
        double valorCompra;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            modelo = JOptionPane.showInputDialog("Informe o modelo do veículo:");
            aux = JOptionPane.showInputDialog("Insira a data de compra do veículo (Ex: dd/mm/aaaa):");
            dataCompra = LocalDate.parse(aux, dtf);

            aux = JOptionPane.showInputDialog("Informe o valor da compra do veículo:");
            valorCompra = Double.parseDouble(aux);

            veiculo1 = new Veiculo(modelo, dataCompra, valorCompra);
            String mensagem = String.format(
                    "Modelo: %s\n" + "Data de Compra: %s\n" + "Idade do Veículo: %d anos\n" + "Valor Atual Estimado: R$ %.2f", veiculo1.getModelo(), dtf.format(veiculo1.getDataCompra()), veiculo1.calcularIdadeVeicular(), veiculo1.calcularValorAtual()
            );
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        }
    }
}