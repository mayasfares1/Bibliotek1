package DB;

import Entitet.Udlåns;

import java.sql.*;

public class UdlånsMapper
{
    public static Udlåns opretUdlåner(Udlåns udlåns) throws SQLException {

        String sql = "INSERT INTO udlånstabel (bogId, lånerId) VALUES (?,?)";

        try (Connection con = ConnectionConfiguration.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)

        {

            try {

                ps.setInt(1,udlåns.getBogId());
                ps.setInt(2,udlåns.getLånerId());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                udlåns.setUdlånsId(resultSet.getInt(1));
                System.out.println(udlåns.toString());

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return udlåns;

        }
    }

}
