package com.db1.db1start;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.db1.db1start.Operacoes.Deposito;

public class Application {
    public static void main(String[] args) {
        List<ContaCorrente> contasCorrentes = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("100.994.234-32", "Leonardo", new Date()));
        clientes.add(new Cliente("122.423.454-54", "Maria", new Date()));
        clientes.add(new Cliente("542.912.564-35", "João", new Date()));

        contasCorrentes.add(new ContaCorrente(clientes.get(0), 1200.0));
        contasCorrentes.add(new ContaCorrente(clientes.get(1), 1200.0));
        contasCorrentes.add(new ContaCorrente(clientes.get(2), 1200.0));

        System.out.println(contasCorrentes.get(0).getSaldo());
        contasCorrentes.get(0).depositar(500.0);
        printSeparador();

        System.out.println(contasCorrentes.get(0).getSaldo());
        System.out.println(contasCorrentes.get(1).getSaldo());
        contasCorrentes.get(0).transferir(200.0, contasCorrentes.get(1));
        printSeparador();

        System.out.println(contasCorrentes.get(0).getSaldo());
        System.out.println(contasCorrentes.get(1).getSaldo());
        Deposito.depositar(1555.50, contasCorrentes.get(1));
        // depositar não requere uma conta, por isso o método estático

        contasCorrentes.get(0).extrato();
        contasCorrentes.get(1).extrato();
    }

    public static void printSeparador() {
        System.out.println("------------------------------");
    }
}
