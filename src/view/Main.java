package view;

import java.util.concurrent.Semaphore;

import controller.ThreadConta;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		Semaphore deposito = new Semaphore(1);
		Semaphore saque = new Semaphore(1);
		
		
		for (int i = 0; i < 20; i++) {
			
			boolean isSaque = (int)(Math.random() * 2) == 0;
			
			int codigo = (int)(Math.random()*1000);
			double saldo = Math.random()*5000;
			double valor = Math.random()*3000;
			
			Thread conta = new ThreadConta(codigo, saldo, valor, isSaque, semaphore, saque, deposito);
			conta.start();
		}

	}

}
