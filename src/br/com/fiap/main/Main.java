package br.com.fiap.main;

import br.com.fiap.bean.Pessoa;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1;
        String aux, nome;
        LocalDate dataNascimento;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            nome = JOptionPane.showInputDialog("Digite seu nome:").toUpperCase();
            aux = JOptionPane.showInputDialog("Informe sua data de nascimento completa(Exemplo: data/mês/ano):");
            dataNascimento = LocalDate.parse(aux, dtf);

            pessoa1 = new Pessoa(nome, dataNascimento);

            JOptionPane.showMessageDialog(null,String.format("Data de nascimento EUA: %s", pessoa1.getDataNascimento()));
            JOptionPane.showMessageDialog(null, String.format("Nome: %s\nData de Nasciemtno: %s\nIdade: %d anos", pessoa1.getNome(), pessoa1.getDataNascimento().format(dtf), pessoa1.calcularIdade()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}