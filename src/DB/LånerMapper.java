package DB;

import Entitet.Låner;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LånerMapper
{
    public static Låner opretLåner(Låner låner) throws SQLException {

        String sql = "INSERT INTO lånertabel (Navn, Adresse, postnr) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)

             {
                 try {

                     ps.setString(1,låner.getNavn());
                     ps.setString(2,låner.getAdresse());
                     ps.setInt(3,låner.getPostNr());
                     ps.executeUpdate();

                     ResultSet resultSet = ps.getGeneratedKeys();
                     resultSet.next();

                     låner.setLånerId(resultSet.getInt(1));
                     System.out.println(låner.toString());



                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }
                 return låner;

        }
    }


    public static List<Låner> hentAlleLåner() throws SQLException {

        List<Låner> LånerList = new LinkedList<>();

        String sql = "select *  from lånertabel ";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int LånerId = resultSet.getInt("LånerId");
                String navn = resultSet.getString("Navn");
                String adresse = resultSet.getString("Adresse");
                int postNr = resultSet.getInt("PostNr");


               Låner låner = new Låner (LånerId, navn, adresse, postNr);
                LånerList.add(låner);
            }

        }

        return LånerList;


    }

    public static String sletLåner(int LånerId) throws SQLException
    {
        String sql = "delete from bogtabel where LånerId = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

        ) {
            ps.setInt(1, LånerId);

            int res = ps.executeUpdate();

            if (res > 0) {

                return "Boget med  id " + "\"" + LånerId + "\"" + " er nu blevet slettet";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en kunde med navnet " + "\"" + LånerId + "\"" + " fandtes ikke i listen";


    }
}
