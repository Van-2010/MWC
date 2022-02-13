package Vista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Modelo.AccionsDev;
import Modelo.Developer;

public class Main {


	public static  void main(String[] args) throws JSONException, FileNotFoundException, IOException, ParseException  {

		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				listarDeveloper();
				break;
			case 2:
				Scanner teclado = new Scanner(System.in);
				System.out.println("Introduce el id: ");
				int id=teclado.nextInt();
				System.out.println("Introduce el nombre: ");
				String name = teclado.next();
				System.out.println("Introduce el email: ");
				String email = teclado.next();
				System.out.println("Introduce el teléfono: ");
				String phone = teclado.next();
				System.out.println("Introduce la categoria: ");
				String categoria = teclado.next();

				Developer developer=new Developer(id,name,email,phone,categoria);

				crearDeveloper(developer);

				break;
			case 3:
				teclado = new Scanner(System.in);
				listarDeveloper();
				System.out.println("Introduce el id que qquieres cambiar: ");
				id=teclado.nextInt();
				System.out.println("Introduce el nombre quue quieres cambiar: ");
				name = teclado.next();
				System.out.println("Introduce el email que quuieres cambiar: ");
				email = teclado.next();
				System.out.println("Introduce el teléfono que quieres cambiar: ");
				phone = teclado.next();
				System.out.println("Introduce la categoria que quieres cambiar: ");
				categoria = teclado.next();
				Developer developer1=new Developer(id,name,email,phone,categoria);
				updateDeveloper(developer1);
				listarDeveloper();

				break;
			case 4:
				teclado = new Scanner(System.in);
				listarDeveloper();
				System.out.println("Cual es el id que desea eliminar: ");
				id=teclado.nextInt();
				eliminarDeveloper(id);
				listarDeveloper();
				break;
			case 5:

				try {

					JSONParser parser = new JSONParser();
					JSONArray listaDev = (JSONArray) parser.parse(new FileReader("C:\\Users\\S4401\\OneDrive\\Documentos\\mwc22.json"));

					for (Object object : listaDev) {
						JSONObject jsonObject = (JSONObject) object;

						name = (String) jsonObject.get("name");	
						email = (String) jsonObject.get("email");
						String category = (String) jsonObject.get("category");
						phone = (String) jsonObject.get("phone");
						String date = (String) jsonObject.get("date");

					}

					System.out.println(listaDev );

				} catch (Exception e) {
					System.out.println("Excepcion leyendo fichero de configuracion " + e);
				}

				break;
			case 0:
				System.out.println("Gracies per utilitzar l'aplicacio");
				sortir = true;
				break;	
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 8;

		do {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("1. Listar developers 1.");
			System.out.println("2. Añadir developer 2.");
			System.out.println("3. Actualizar nombre 3.");
			System.out.println("4. Eliminar developer 4.");
			System.out.println("5. Ver listado developer 5.");

			System.out.println("0. Salir de la aplicació.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Elija una opción válida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}
	public static void crearDeveloper(Developer developer) {
		AccionsDev dev = new AccionsDev();
		try {
			dev.addDeveloper(developer);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void updateDeveloper(Developer developer) {
		AccionsDev dev= new AccionsDev();
		try {
			dev.updateDeveloper(developer);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public static void listarDeveloper(){

		AccionsDev dev = new AccionsDev();
		try {
			dev.listarDeveloper();
			ArrayList<Developer> developer = dev.listarDeveloper();

			developer.forEach(x -> System.out.println(x.toString()));
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void eliminarDeveloper(int id) {
		AccionsDev dev = new AccionsDev();
		try {
			dev.eliminarDeveloper(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

