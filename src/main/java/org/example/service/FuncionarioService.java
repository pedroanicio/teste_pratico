package org.example.service;

import org.example.Main;
import org.example.Model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    public void removerFuncionario(String nome){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public List<String> listarTodos(){
        System.out.println("Imprimindo todos os funcionários:");
        return funcionarios.stream()
                .map(funcionario -> {
                    String dataNascimentoFormatada = funcionario.getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    return "Funcionario{" +
                            "nome='" + funcionario.getNome() + '\'' +
                            ", dataNascimento=" + dataNascimentoFormatada +
                            ", salario=" + funcionario.getSalario() +
                            ", funcao='" + funcionario.getFuncao() + '\'' +
                            '}';
                })
                .collect(Collectors.toList());
    }

    public void atualizarSalario(double valorAumento){
        double opr = valorAumento/100;
        for (Funcionario funcionario : funcionarios){
            funcionario.setSalario(funcionario.getSalario().add((funcionario.getSalario().multiply(BigDecimal.valueOf(opr)))));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(){
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> aniversariantesdoMes10e12(){
        List<Funcionario> aniversariantes = new ArrayList<>();

        for (Funcionario funcionario : funcionarios){
            if (funcionario.getDataNascimento().getMonth().equals(Month.OCTOBER) || funcionario.getDataNascimento().getMonth().equals(Month.DECEMBER)){
                aniversariantes.add(funcionario);
            }
        }
        return aniversariantes;
    }


    public int PegarIdadeFuncionario(Funcionario funcionario){
        int idade;
        LocalDate dataNascimento = funcionario.getDataNascimento();
        LocalDate dataAtual = LocalDate.now();

        if (dataNascimento != null){
            idade = Period.between(dataNascimento, dataAtual).getYears();
        } else {
            idade = 0;
        }


        return idade;
    }

    public void exibirFuncComMaiorIdade(){
        Funcionario funcionarioMaiorIdade = null;
        int idade = 0;

        for (Funcionario funcionario : funcionarios){
            if (PegarIdadeFuncionario(funcionario) >= idade){
                idade = PegarIdadeFuncionario(funcionario);
                funcionarioMaiorIdade = funcionario;
            }
        }
        System.out.println(funcionarioMaiorIdade.getNome());
        System.out.println("Idade: "+ idade);
    }

    public List<Funcionario> listarEmOrdemAlfabetica(){
        System.out.println("\nImprimindo em ordem alfabética");

        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        return funcionarios;

    }

    public void salarioTotal(){
        BigDecimal salarioTotal = BigDecimal.valueOf(0);

        for(Funcionario funcionario : funcionarios){
            salarioTotal = salarioTotal.add(funcionario.getSalario());
        }
        System.out.println("Salário total: "+salarioTotal);
    }

    public void QtdeSalariosMinimos(){
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212);
        for (Funcionario funcionario : funcionarios){
            BigDecimal qtde = funcionario.getSalario().divide(salarioMinimo, 1, RoundingMode.DOWN);
            System.out.print(funcionario.getNome()+": ");
            System.out.println(qtde);
        }
    }


}
