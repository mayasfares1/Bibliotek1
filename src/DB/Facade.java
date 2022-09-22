package DB;

import Entitet.Bog;
import Entitet.Låner;
import Entitet.Postnr;
import Entitet.Udlåns;

import java.sql.SQLException;
import java.util.List;

public class Facade
{

    public static Bog opretBog(Bog bog) throws SQLException {

        return BogMapper.opretBog(bog);
    }

    public static List<Bog> hnetBøger() throws SQLException
    {
        return BogMapper.hentAllebøger();
    }

    public static String sletBog(int bogId) throws SQLException
    {
        return BogMapper.sletBog(bogId);

    }


    public static Låner opretLåner(Låner låner) throws SQLException {

        return LånerMapper.opretLåner(låner);

    }

    public static List<Låner> hentLåner() throws SQLException
    {
      return LånerMapper.hentAlleLåner();

    }






    public static Postnr opretPostnr(Postnr postnr) throws SQLException {
        return PostnrMappe.opretPostnr(postnr);
    }

    public static Udlåns opretUdlån(Udlåns udlåns) throws SQLException {

        return UdlånsMapper.opretUdlåner(udlåns);
    }


}
