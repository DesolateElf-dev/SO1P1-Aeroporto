package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;

		for(int idAviao=0 ; idAviao<12 ; idAviao++) {
			Thread tAeroporto = new ThreadAeroporto(idAviao);
			tAeroporto.start();
		}
	}
}
