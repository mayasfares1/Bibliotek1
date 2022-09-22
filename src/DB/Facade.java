package DB;

import Entitet.Bog;
import Entitet.Låner;

import java.sql.SQLException;

public class Facade
{
    public static Låner opretLåner(Låner låner) throws SQLException {

        return LånerMapper.opretLåner(låner);
    }
    public static Bog opretBog(Bog bog) throws SQLException {

        return BogMapper.opretBog(bog);
    }
}
