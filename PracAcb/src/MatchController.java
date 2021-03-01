import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MatchController {
    private Connection connection;
    private TeamController teamController;
    private PlayerController playerController;
    public MatchController(Connection c) {
        this.connection = c;
        teamController = new TeamController(c);
        playerController = new PlayerController(c);
    }

    public void createMatch() throws SQLException, IOException {

        Statement st = connection.createStatement();

        Scanner sc = new Scanner(System.in);
        teamController.showTeams();
        System.out.println("Introdueixi l'equip local");
        String local = sc.nextLine();
        System.out.println("Introdueixi l'equip visitant");
        String away = sc.nextLine();

        System.out.println("Introdueix la data de naixement del partit(yyyy-mm-dd)");
        java.util.Date data = java.sql.Date.valueOf(sc.nextLine());
        System.out.println("introdueixi l'assistencia al parit");
        int assistencia = sc.nextInt();
        sc.nextLine();
        playerController.showPlayerFromTeam();
        System.out.println("Introdueixi el codi de la llicencia de la federació del jugador que ha sigut el MVP ");
        String code = sc.nextLine();
        //st.executeUpdate("INSERT INTO match (name, type, country, city, court_name) VALUES('"+name+"','"+type+"','"+country+"','"+city+"','"+court+"')");



        st.close();
    }

}
