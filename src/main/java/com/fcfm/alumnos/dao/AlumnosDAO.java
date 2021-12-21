package com.fcfm.alumnos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fcfm.alumnos.dto.AlumnosDTO;

public class AlumnosDAO {
	
	private final String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=America/Monterrey";
	private final String user = "root";
	private final String pass = "root";
	Scanner entrada = new Scanner(System.in);
	
	public List<AlumnosDTO> findAll() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
		List<AlumnosDTO> alumnoOut = new ArrayList();
		while (rs.next()) {
			
			AlumnosDTO nuevo = new AlumnosDTO();
			nuevo.setId(rs.getInt("id"));
			nuevo.setMatricula(rs.getInt("matricula"));
			nuevo.setNombre(rs.getString("nombre"));
			nuevo.setApellido(rs.getString("apellido"));
			nuevo.setGrupo(rs.getInt("grupo"));
			nuevo.setMateria(rs.getString("materia"));
			nuevo.setCalificacion(rs.getInt("calificacion"));
			alumnoOut.add(nuevo);

		}
		con.close();
		return alumnoOut;
        
	}
	
	public void DeleteAlumno() throws SQLException{
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		AlumnosDTO Borrar = new AlumnosDTO();
		System.out.println("Ingresa el id del alumno a borrar: \n");
		Borrar.setId(entrada.nextInt());
		
		String query3 = "DELETE FROM alumnos WHERE id= " + Borrar.getId() + "";
		st.executeUpdate(query3);
		con.close();
		
	}
	
	public void UpdateAlumno() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		AlumnosDTO Update = new AlumnosDTO();
		
		System.out.println("ID de alumno a modificar :");
		Update.setId(entrada.nextInt());
		System.out.println("Matricula de alumno:");
		Update.setMatricula(entrada.nextInt());
		System.out.println("Nombre de alumno:");
		entrada.nextLine();
		Update.setNombre(entrada.nextLine());
		System.out.println("Apellido de alumno:");
		Update.setApellido(entrada.nextLine());
		System.out.println("Grupo:");
		Update.setGrupo(entrada.nextInt());
		System.out.println("Materia:");
		entrada.nextLine();
		Update.setMateria(entrada.nextLine());
		System.out.println("Calificacion:");
		Update.setCalificacion(entrada.nextInt());

		String query2 = "UPDATE alumnos SET matricula = " + Update.getMatricula() + ",nombre = '" + Update.getNombre()
				+ "',apellido = '" + Update.getApellido() + "'" + ",grupo = " + Update.getGrupo() + ",materia = '" + Update.getMateria()
				+ "',calificacion = " + Update.getCalificacion() + " WHERE id = " + Update.getId();

		st.executeUpdate(query2);
		con.close();
	}
	
	public void Insert() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		AlumnosDTO Insert = new AlumnosDTO();
		
		System.out.println("ID de alumno (Asegurate de no repetir uno ya existente):");
		Insert.setId(entrada.nextInt());
		System.out.println("Matricula de alumno:");
		Insert.setMatricula(entrada.nextInt());
		System.out.println("Nombre de alumno:");
		entrada.nextLine();
		Insert.setNombre(entrada.nextLine());
		System.out.println("Apellido de alumno:");
		Insert.setApellido(entrada.nextLine());
		System.out.println("Grupo:");
		Insert.setGrupo(entrada.nextInt());
		System.out.println("Materia:");
		entrada.nextLine();
		Insert.setMateria(entrada.nextLine());
		System.out.println("Calificacion:");
		Insert.setCalificacion(entrada.nextInt());
		
		String query = "INSERT INTO alumnos (id,matricula,nombre,apellido,grupo,materia,calificacion) VALUES ("
				+ Insert.getId() + "," + Insert.getMatricula() + ",'" + Insert.getNombre() + "','" + Insert.getApellido() + "'," + Insert.getGrupo() + ",'" + Insert.getMateria()
				+ "'," + Insert.getCalificacion() + ")";
		st.executeUpdate(query);
		
		con.close();
		
	}

}
