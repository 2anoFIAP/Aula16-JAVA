package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    //atributos
    private String nome;
    private LocalDate dataNascimento;

    //construtores
    public Pessoa (){ //Construtor vázio inicializa os atributos sem os valores, então eles estarão com valores 0 ou nulos.
    }
    public Pessoa (String nome, LocalDate dataNascimento){ //já inicializa os atributos com o valor que vamos passar com os parametros, já começa com valor.
        this.nome = nome;
        setDataNascimento(dataNascimento);
    }

    //métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        try {
            LocalDate inicio = LocalDate.parse("1900-01-01").minusDays(1); //Parse converte string em inteiro ou valor válido para analise (foi o que eu entendi). Minus: subtrai o dia, mês ou ano da data colocada.
            LocalDate fim = LocalDate.now().plusDays(1); //plus: soma mais um dia ou mês ou ano na data atual.
            if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(fim)){ //Condição para que a data fique entre duas datas especificas.
                this.dataNascimento = dataNascimento;
            } else {
                throw new Exception("ERRO: Insira uma data válida, dentro da faixa permitida.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0); //metodo que encerra o programa após mensagem de erro (tipo um break)
        }
    }

    // métodos da classe
    public int calcularIdade(){
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears(); //tem que especificar o que será retornado
    }
}