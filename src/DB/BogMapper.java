package DB;

import Entitet.Bog;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BogMapper {

    public static Bog opretBog(Bog bog) throws SQLException {

        String sql = "INSERT INTO bogtabel  (forfatter, title, udgivelseÅr ) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            try {

                ps.setString(1, bog.getForfatter());
                ps.setString(2, bog.getTitle());
                ps.setInt(3, bog.getUdgivelseår());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                bog.setBogId(resultSet.getInt(1));
                System.out.println(bog.toString());


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return bog;

        }

    }

    public static List<Bog> hentAllebøger() throws SQLException {

        List<Bog> bogList = new LinkedList<>();
        String sql = "select *  from bogtabel ";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int BogId = resultSet.getInt("BogId");
                String forfatter = resultSet.getString("Forfatter");
                String title = resultSet.getString("Title");
                int udgivelseÅr = resultSet.getInt("UdgivelseÅr");


                Bog bog = new Bog(forfatter, title, udgivelseÅr);
                bogList.add(bog);
            }

        }

        return bogList;


    }

    public static String sletBog(int bogId) throws SQLException
    {
        String sql = "delete from bogtabel where BogId = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

        ) {
            ps.setInt(1, bogId);

            int res = ps.executeUpdate();

            if (res > 0) {

                return "Boget med  id " + "\"" + bogId + "\"" + " er nu blevet slettet";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en kunde med navnet " + "\"" + bogId + "\"" + " fandtes ikke i listen";


    }

}
