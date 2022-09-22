package DB;

import Entitet.Låner;

import java.sql.SQLException;

public class Facade
{
    public static Låner opretLåner(Låner låner) throws SQLException {

        return LånerMapper.opretLåner(låner);
    }
}
