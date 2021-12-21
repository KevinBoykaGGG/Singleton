package com.fcfm.alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fcfm.alumnos.dao.AlumnosDAO;
import com.fcfm.alumnos.dto.AlumnosDTO;

import Facultad.FacultadNombre;

public class Main {

	public static void main(String[] args) {

		int opcion = -1;
		String Facultad;

		Scanner entrada = new Scanner(System.in);
		AlumnosDAO alumnosDAO = new AlumnosDAO();
		FacultadNombre f = FacultadNombre.getInstance();

		// aqui pido facultad//
		System.out.println("\nIngresa el nombre de la facultad: ");
		Facultad = entrada.nextLine();
		f.setNombreFacu(Facultad);
		

		try {

			while (opcion != 0) {

				System.out.println(
						"\n\nMENU\n\n1)INSERTAR\n\n2)ACTUALIZAR\n\n3)BORRAR\n\n4)MOSTRAR TODO\n\n5)SALIR\n\nRespuesta:");
				opcion = entrada.nextInt();
				switch (opcion) {
				case 1:// insertar datos//

					alumnosDAO.Insert();
					System.out.println("Alumno insertado correctamente");
					break;
				case 2:// modificar alumno//

					alumnosDAO.UpdateAlumno();
					System.out.println("Alumno actualizado correctamente");
					break;
				case 3:// Borrar de tabla//

					alumnosDAO.DeleteAlumno();
					System.out.println("Alumno Borrado correctamente\n\n");

				case 4:// mostrar tabla//

					List<AlumnosDTO> alumnoOut = alumnosDAO.findAll();
					show(alumnoOut);

					break;
				case 5:
					opcion = 0;
					break;

				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void show(List<AlumnosDTO> rs) {

		FacultadNombre f = FacultadNombre.getInstance();
		for (AlumnosDTO actual : rs) {
			System.out.println(
					actual.getId() + " " + actual.getMatricula() + " " + actual.getNombre() + " " + actual.getApellido()
							+ " " + actual.getGrupo() + " " + actual.getMateria() + " " + actual.getCalificacion()

			);
			System.out.println("Pertenece a: " + f.getNombreFacu()+"\n");
		}

		

	}

}
