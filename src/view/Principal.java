package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 2;
		Semaphore semaforoPista = new Semaphore (permissoes);
		Semaphore pistaSul = new Semaphore(1);
		Semaphore pistaNorte = new Semaphore(1);

		for(int idAviao=0 ; idAviao<14 ; idAviao++) {
			Thread tAeroporto = new ThreadAeroporto(idAviao, semaforoPista, pistaNorte, pistaSul);
			tAeroporto.start();
		}
	}
}
