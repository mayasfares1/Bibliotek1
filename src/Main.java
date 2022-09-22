import DB.Facade;
import Entitet.Låner;
import MineUtil.BrugerInput;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

       // Låner låner = new Låner("Mohamed","tomsvej",2400);
        //Facade.opretLåner(låner);

        while (true) {

            switch (BrugerInput.getString("hvad ønsker du")) {

                case "opret Låner":
                    Låner låner = new Låner(BrugerInput.getString("angiv navn"),
                            BrugerInput.getString("angiv adresse"),
                            BrugerInput.getInt("angiv postnr"));
                             Facade.opretLåner(låner);

            }
        }

    }
}