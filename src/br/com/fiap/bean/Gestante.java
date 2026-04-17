package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Gestante {
    private String nome;
    private LocalDate dataDaGestacao;


    public Gestante() {
    }
    public Gestante(String nome, LocalDate dataDaGestacao) {
        this.nome = nome;
        setDataDaGestacao(dataDaGestacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDaGestacao() {
        return dataDaGestacao;
    }

    public void setDataDaGestacao(LocalDate dataDaGestacao) {
        try {
            LocalDate dataAtual = LocalDate.now();
            LocalDate noveMesesAntes = LocalDate.now().minusMonths(9);
            if (!dataDaGestacao.isBefore(noveMesesAntes) && !dataDaGestacao.isAfter(dataAtual)) {
                this.dataDaGestacao = dataDaGestacao;
            } else {
                throw new Exception("ERRO: Data da Gestacao fora do periodo real.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }

    public int tempoDeGestacao(){
        LocalDate dataAtual = LocalDate.now();
        Period dataFinal = Period.between(dataDaGestacao, dataAtual);
        return dataFinal.getMonths();
    }
}
