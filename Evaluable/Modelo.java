package Evaluable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {

	private String fichero_lectura;
	private String fichero_escritura;

	/*Introducimos los ficheros de :
	 * Lectura 
	 * Escritura
	 */
	
	
	public Modelo() {

		fichero_lectura = "C:\\Users\\DAM 2\\Desktop\\AE_02_T1_2_Streams_Material\\AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "C:\\Users\\DAM 2\\Desktop\\AE_02_T1_2_Streams_Material\\Editar.txt";

	}

	public String getFicheri_lectura() {
		return fichero_lectura;
	}

	public String getFichero_escritura() {
		return fichero_escritura;
	}

	public String ficheroEscritur() {
		return fichero_lectura;

	}

	
	//Obtenemos el contenido del fichero
	
	public ArrayList<String> contenidofichero(String fichero) {

		FileReader archivo;

		String cadtext;
		
		ArrayList<String> contenido = new ArrayList();

		try {

			archivo = new FileReader(fichero);

			BufferedReader leer = new BufferedReader(archivo);
			
			while ((cadtext = leer.readLine()) != null) {

				contenido.add(cadtext);

			}

			leer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return contenido;

	}

	
	 /*
	  * Introducimos el proceso de buscartexto para encontrar la letra o palabra que queramos buscar y nos devuelva 
	    la cantidad de veces que se encuentra la palabra
	  */
	    
	public int buscartexto(String textobuscar) {

		ArrayList<String> buscapal = contenidofichero(getFicheri_lectura());

		int cont = 0;

		for (int i = 0; i < buscapal.size(); i++) {

			int posi = buscapal.get(i).indexOf(textobuscar);

			if (posi >= 0) {

				cont++;

				while (buscapal.get(i).indexOf(textobuscar, posi++) + 1 != 0) {

					cont++;

					posi = buscapal.get(i).indexOf(textobuscar, posi++) + 1;

				}

			}

		}

		return cont;

	}

	//Introducimos el proceso de reemplazar la palabra o texto y utilizamos el metodo replaceAll
	
	
	public String reemplazartexto(String cadtext, String textobuscar, String textoReemplazar) {

		String cambio = cadtext.replaceAll(textobuscar, textoReemplazar);

		return cambio;

	}

}
