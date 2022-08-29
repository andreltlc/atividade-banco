package user;

import user.TipoDeConta;

public class Conta {
  //Atributos
  private String numeroConta;
  private double saldo;
  private String nomePropietario;
  private TipoDeConta tipoDeConta;

  //Construtor
  public Conta (String accountNumber, String clientName, TipoDeConta tipoDeConta){
    this.numeroConta = accountNumber;
    this.saldo = 0;
    this.nomePropietario = clientName;
    this.tipoDeConta = tipoDeConta;
  }
  public void deposit( double value){
    saldo += value;
  }
  public void withdraw (double value){
    if (saldo >= value){
      saldo -= value;
    }
  }

  //Getters
  public double getSaldo(){

    return this.saldo;
  }

  public String getNumeroConta(){
    return this.numeroConta;
  }
}
