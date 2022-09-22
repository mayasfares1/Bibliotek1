package DB;

import Entitet.Postnr;

import java.sql.*;

public class PostnrMappe
{
    public static Postnr opretPostnr(Postnr postnr) throws SQLException {

    String sql = "INSERT INTO postnr (PostNr, By) VALUES (?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();

    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)

    {

        try {

            ps.setInt(1,postnr.getPostNr());
            ps.setString(2,postnr.getBy());
            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();

            postnr.setPostNrId(resultSet.getInt(1));
            System.out.println(postnr.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return postnr;

    }
}

}
