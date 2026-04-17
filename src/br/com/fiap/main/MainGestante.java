package br.com.fiap.main;

import br.com.fiap.bean.Gestante;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainGestante {
    public static void main(String[] args) {
        Gestante gestante1;
        String aux, nome;
        LocalDate data;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            nome = JOptionPane.showInputDialog("Informe seu nome: ");
            aux = JOptionPane.showInputDialog("Insira a data do inicio da sua gestacao (Ex: 10/07/2025");
            data = LocalDate.parse(aux, dtf);

            gestante1 = new Gestante(nome, data);
            JOptionPane.showMessageDialog(null, String.format("Data da gestacao: %s", gestante1.getDataDaGestacao()));
            JOptionPane.showMessageDialog(null, String.format("Nome: %s\nData da Gestacao: %s\nTempo de gestacao: %s", gestante1.getNome(), gestante1.getDataDaGestacao(), gestante1.tempoDeGestacao()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
