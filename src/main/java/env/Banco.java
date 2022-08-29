package env;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import user.*;

public class Banco {
  private ArrayList<Conta> contas;

  public Banco() {
    this.contas = new ArrayList();
  }

  private boolean contaExistente(String accountNumber){
    if(getConta(accountNumber) == null){
      return false;
    }
    return true;
  }

  public void realizarDepositoEmConta(double valor, String nConta){
    Conta conta = getConta(nConta);
    if (conta != null){
      conta.deposit(valor);
    }
  }
  public double extratoBancario( String nConta) {
    Conta conta = getConta(nConta);
    return conta.getSaldo();
  }

  private Conta getConta(String nConta) {

    for (Conta conta :
            contas) {
      if(conta.getNumeroConta().equals (nConta)){
        return conta;
      }
    }
    return null;
  }

  public void realizarSaqueEmConta (double valor, String nConta){
    Conta conta = getConta(nConta);
    if (conta != null){
      conta.withdraw(valor);
    }
  }
  public void realizarTransferencia(double valor, String nConta,String contaT){
    Conta conta = getConta(nConta);
    Conta conta1 = getConta(contaT);
    conta.withdraw(valor);
    conta1.deposit(valor);
  }



  public void criarConta(String accountNumber, String userName){
    if (!contaExistente(accountNumber)){
      contas.add(new Conta(accountNumber, userName, TipoDeConta.Corrente));
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    Banco bank = new Banco();
    bank.criarConta("1234","Geraldao");
    bank.realizarDepositoEmConta(10000,"1234");
    bank.criarConta("1002","Jose");
    bank.realizarDepositoEmConta(10000,"1002");

    int x, numero,y=0;
    String numeroConta2, numeroDeConta;
    double value, saldo, saldo2;

    System.out.println("### Welcome to the Bank ###");
    System.out.println("### 1 - Create Account ###");
    System.out.println("### 2 - LogIn Account ###");
    x =s.nextInt();
    if(x == 1){
      criarConta(s, r, bank);
    }
    if(x == 2) {
      System.out.println("### Enter your account Number ###");
      numeroDeConta = s.next();
      System.out.println("### What do you want ? ###");
      System.out.println("### 1 - See balance ###");
      System.out.println("### 2 - Deposit ###");
      System.out.println("### 3 - Withdraw ###");
      System.out.println("### 4 - Transfer ###");
      y = s.nextInt();
      if (y == 1) {
        saldo = bank.extratoBancario(numeroDeConta);
        System.out.println(saldo);
      }
      if(y == 2){
        System.out.println("### Enter the value of the deposit  ###");
        value = s.nextDouble();
        bank.realizarDepositoEmConta(value,numeroDeConta);
        saldo = bank.extratoBancario(numeroDeConta);
        System.out.println(saldo);
      }
      if(y == 3){
        System.out.println("### Enter the value of the withdraw  ###");
        value = s.nextDouble();
        bank.realizarSaqueEmConta(value,numeroDeConta);
        saldo = bank.extratoBancario(numeroDeConta);
        System.out.println(saldo);
      }
      if (y == 4){
        System.out.println("### Enter the account number of whom you want to trasfer  ###");
        numeroConta2 = s.next();
        System.out.println("### Enter the value of the transference  ###");
        value = s.nextDouble();
        bank.realizarTransferencia(value,numeroDeConta,numeroConta2);
        saldo = bank.extratoBancario(numeroDeConta);
        saldo2 = bank.extratoBancario(numeroConta2);
        System.out.println(saldo);
        System.out.println(saldo2);
      }
    }
  }

  private static void criarConta(Scanner s, Random r, Banco bank) {
    String numeroDeConta;
    String nome;
    int numero;
    System.out.println("### Digite seu nome ###");
    nome = s.next();
    numero = r.nextInt(0,1000);
    numeroDeConta = Integer.toString(numero);
    bank.criarConta(numeroDeConta,nome);
    System.out.println("### Conta Criada com Sucesso");
    System.out.println(nome +"### Esse e seu numero de conta: " + numeroDeConta);
  }

}
