package org.example;

import org.example.Model.Funcionario;
import org.example.service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();

        //inserir funcionários
        funcionarioService.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarioService.adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarioService.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarioService.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarioService.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarioService.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarioService.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarioService.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarioService.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarioService.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));

        //Remover funcionario João
        funcionarioService.removerFuncionario("João");

        //Imprimir todos os funcionários com todas suas informações
        funcionarioService.listarTodos().forEach(System.out::println);

        //Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarioService.atualizarSalario(10);
        //funcionarioService.listarTodos().forEach(System.out::println);


        //Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        //Imprimir os funcionários, agrupados por função.
        System.out.println("\nAgrupando por função");
        System.out.println(funcionarioService.agruparPorFuncao());

        //Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\nAniversariantes dos meses 10 e 12: ");
        System.out.println(funcionarioService.aniversariantesdoMes10e12());

        //Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("\nFuncionário mais velho: ");
        funcionarioService.exibirFuncComMaiorIdade();


        //Imprimir a lista de funcionários por ordem alfabética.
        funcionarioService.listarEmOrdemAlfabetica().forEach(System.out::print);

        //Imprimir o total dos salários dos funcionários.
        funcionarioService.salarioTotal();

        //Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("\nQuantidade de salários mínimos: ");
        funcionarioService.QtdeSalariosMinimos();




    }
}