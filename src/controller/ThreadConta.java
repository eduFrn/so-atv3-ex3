package controller;

import java.util.concurrent.Semaphore;

public class ThreadConta extends Thread {

	private Semaphore semaphore;
	private int codigo;
	private double saldo;
	private double valor;

	private boolean saque;

	private Semaphore semSaque;
	private Semaphore semDeposito;

	public ThreadConta(int codigo, double saldo, double valor, boolean saque, Semaphore semaphore, Semaphore semSaque,
			Semaphore semDeposito) {
		this.codigo = codigo;
		this.saldo = saldo;
		this.valor = valor;
		this.saque = saque;
		this.semaphore = semaphore;

		this.semSaque = semSaque;
		this.semDeposito = semDeposito;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();

			if (saque) {
				semSaque.acquire();
				saque();
			} else {
				semDeposito.acquire();
				deposito();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (saque) {
				semSaque.release();
			} else {
				semDeposito.release();
			}
			semaphore.release();

		}
	}

	private void saque() {
		double novoSaldo = saldo - valor;
		if(novoSaldo < 0) {
			novoSaldo = 0;
		}
		
		System.out.println("Foi realizado um saque de R$" + String.format("%.2f", valor) + " na conta de código: "
			+ codigo + ". Saldo atual -> R$" + String.format("%.2f", novoSaldo)+" | Saldo anterior -> R$"+String.format("%.2f", saldo));
		
		saldo-=valor;
	}

	private void deposito() {
		double novoSaldo = saldo - valor;
		
		System.out.println("Foi realizado um depósito de R$" + String.format("%.2f", valor) + " na conta de código: "
			+ codigo + ". Saldo atual -> R$" + String.format("%.2f", novoSaldo)+" | Saldo anterior -> R$"+String.format("%.2f", saldo));
		
		saldo-=valor;
	}

}
