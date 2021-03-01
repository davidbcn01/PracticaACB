import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class PlayerController {

	private Connection connection;
	private TeamController teamController;
	public PlayerController(Connection c) {
	this.connection = c;
	teamController = new TeamController(c);
	}
	public void showPlayerFromTeam() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;
		Scanner sc = new Scanner(System.in);
		teamController.showTeams();
		System.out.println("De quin equip vols veure els jugadors?(Introdueix el nom)");
		String team = sc.nextLine();
		rs = st.executeQuery("SELECT * FROM player WHERE team_name = '"+team+"'");
		while (rs.next()) {
			System.out.println("Federation License Code: " + rs.getString("federation_license_code") + " " +
					"Name: " + rs.getString("first_name") + " " +
					"Surname: " + rs.getString("last_name") + " " +
					"birth date: " + rs.getDate("birth_date") + " " +
					"gender: " + rs.getString("gender") + " " +
					"height: " + rs.getInt("height") + " " +
					"MVPs: " + rs.getInt("mvp_total")
			);
		}

		rs.close();
		st.close();
	}

	public void createPlayer() throws SQLException, IOException {

		Statement st = connection.createStatement();

		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix el codi de la llicencia de la federació del jugador");
		String code = sc.nextLine();
		System.out.println("Introdueix el nom del jugador");
		String name = sc.nextLine();
		System.out.println("Introdueix el cognom del jugador");
		String surname = sc.nextLine();
		System.out.println("Introdueix la data de naixement del jugador(yyyy-mm-dd)");
		java.util.Date data = java.sql.Date.valueOf(sc.nextLine());
		System.out.println("Introdueix el genere del jugador");
		String gender = sc.nextLine();
		System.out.println("Introdueix l'alçada del jugador");
		int height = sc.nextInt();
		sc.nextLine();
		System.out.println("Introdueix l'equip del jugador");
		String team = sc.nextLine();
		System.out.println("Introdueix el número de MVP del jugador");
		int mvp = sc.nextInt();
		sc.nextLine();



		st.executeUpdate("INSERT INTO player (federation_license_code, first_name, last_name, birth_date, gender, height, team_name, mvp_total) VALUES('"+code+"','"+name+"','"+surname+"','"+data+"','"+gender+"','"+height+"','"+team+"','"+mvp+"')");



		st.close();
	}

}
