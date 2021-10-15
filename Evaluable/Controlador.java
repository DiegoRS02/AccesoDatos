package Evaluable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class Controlador {

	private Vista vista;
	private Modelo modelo;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;

		//Introducimos el texto dentro de una ArrayList
		
		ArrayList<String> texto = modelo.contenidofichero(modelo.getFicheri_lectura());

		for (int i = 0; i < texto.size(); i++) {

			vista.getTextAreaOriginal().append(texto.get(i) + "\n");

		}

		//Implementamos la acción del botón buscar
		
		vista.getBtnBuscar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				String palabra = vista.getTextFieldBuscar().getText();

				int cont = modelo.buscartexto(palabra);

				vista.getTextAreaModificado().setText("" + cont);

			}
		});

		//Implementamos la acción del botón reemplazar
		
		
		vista.getBtnReemplazar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String palabra = vista.getTextFieldBuscar().getText();

				String cambiar = vista.getTextFieldReemplazar().getText();

				String cadena = vista.getTextAreaOriginal().getText();

				String cambios = modelo.reemplazartexto(cadena, palabra, cambiar);

				vista.getTextAreaModificado().setText("" + cambios);
			}

		});

	}
}
