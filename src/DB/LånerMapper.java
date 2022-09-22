package DB;

import Entitet.Låner;

import java.sql.*;

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
}
