package controller;

public class ThreadAeroporto extends Thread{
	
	private int idAviao;
	private static int posicaoDecolagem;
	
	public ThreadAeroporto(int idAviao) {
		this.idAviao = idAviao;
	}
	
	@Override
	public void run() { //procedimento decolagem em 4 fases
		aviaoManobrando();
		aviaoTaxiando();
		aviaoDecolando();
		aviaoAfastando();
	}
	
	private void aviaoManobrando() {
		int tempo = (int)((Math.random()*5)+3);	//aleatoriza um tempo entre 3 e 7 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoTaxiando() {
		int tempo = (int)((Math.random()*6)+5);//aleatoriza um tempo entre 5 e 10 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoDecolando() {
		int tempo = (int)((Math.random()*4)+1);//aleatoriza um tempo entre 1 e 4 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void aviaoAfastando() {
		int tempo = (int)((Math.random()*6)+3);//aleatoriza um tempo entre 3 e 8 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
