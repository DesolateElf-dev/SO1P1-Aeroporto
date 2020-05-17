package controller;
//teste git
import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread{
	
	private int idAviao;
	private Semaphore semaforoPista;
	private Semaphore pistaSul;
	private Semaphore pistaNorte;
	
	public ThreadAeroporto(int idAviao, Semaphore semaforoPista, Semaphore pistaNorte, Semaphore pistaSul) {
		this.idAviao = idAviao;
		this.semaforoPista = semaforoPista;
		this.pistaNorte = pistaNorte;
		this.pistaSul = pistaSul;
	}
	
	@Override
	public void run() { //procedimento decolagem em 4 fases
		
		try {
			semaforoPista.acquire();//semaforo para dois avi�es circulando na pista
			aviaoManobrando();
			aviaoTaxiando();
			
			int pista = (int)((Math.random()*2)+1);//aleatoriza 1 para pistaNorte ou 2 para pistaSul
			if (pista == 1) {
				pistaNorte.acquire();
				aviaoDecolando(pista);
			} else {
				pistaSul.acquire();
				aviaoDecolando(pista);
			}
			
			aviaoAfastando();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("O avi�o "+idAviao+" se afastou da �rea");
			semaforoPista.release();
			pistaSul.release();
			pistaNorte.release();
		}
	}
	
	private void aviaoManobrando() { //procedimento para randomizar o tempo de manobra
		
		System.out.println("O avi�o "+idAviao+" est� manobrando");
		int tempo = (int)((Math.random()*5)+3);	//aleatoriza um tempo entre 3 e 7 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoTaxiando() { //procedimento para randomizar o tempo de taxiamento
		
		System.out.println("O avi�o "+idAviao+" est� taxiando");
		int tempo = (int)((Math.random()*6)+5);//aleatoriza um tempo entre 5 e 10 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoDecolando(int pista) { //procedimento para randomizar o tempo de decolagem e dizer qual pista ele decolar�
		
		if(pista == 1) {
			System.out.println("O avi�o "+idAviao+" est� decolando pela pista Norte");
		} else {
			System.out.println("O avi�o "+idAviao+" est� decolando pela pista Sul");
		}
		
		int tempo = (int)((Math.random()*4)+1);//aleatoriza um tempo entre 1 e 4 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoAfastando() { //procedimento para randomizar o tempo de afastamento da �rea
		
		int tempo = (int)((Math.random()*6)+3);//aleatoriza um tempo entre 3 e 8 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
