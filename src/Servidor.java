import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor {
	
	private ArrayList<Socket> lista;
	
	public Servidor(int puerto) {
		
		lista = new ArrayList<Socket>();
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			
			System.out.println("Servidor en L�nea...");
			
			//acepta 4 usuarios
			for (int i = 1; i <= 1 ; i++) {
				Socket cliente = servidor.accept();
				lista.add(cliente);
				System.out.println("hay " + lista.size() + " usuarios conectados");
				new ServidorHilo(cliente, lista).start();
			}
			
			new Partida(lista);
			
			//se conectaron los 4 clientes
			//partida en juego
			boolean inGame = true;
			while(inGame){
				
			}
			
			
			servidor.close();
			System.out.println("El Servidor se ha cerrado");
						
		} catch (Exception e) {
			System.err.println("Ocurri� un problema con el Servidor");
		}
	}

	public static void main(String[] args) {
		new Servidor(10000);
	}
}
