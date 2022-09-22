import DB.Facade;
import Entitet.Bog;
import Entitet.Låner;
import Entitet.Postnr;
import Entitet.Udlåns;
import MineUtil.UI;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

       // Låner låner = new Låner("Mohamed","tomsvej",2400);
        //Facade.opretLåner(låner);

        while (true) {

            switch (UI.getString("hvad ønsker du")) {

                case "opret bog":
                    Bog bog = new Bog(UI.getString("angiv forfatter"),
                            UI.getString("angiv title"), UI.getInt("angiv årstal"));
                    Facade.opretBog(bog);
                    break;
                case "udskriv bøger":
                    List<Bog> bogList = Facade.hnetBøger();
                    UI.udskrivBog(bogList);
                    break;

                case "slet bog":
                    System.out.println(Facade.sletBog(UI.getInt("skriv BogId")));

                    break;



                case "opret postnr":
                    Postnr postnr = new Postnr(UI.getInt("Angiv postnr"),
                            UI.getString("angiv by"));
                    Facade.opretPostnr(postnr);

                    break;

                case "opret udlåns":
                    Udlåns udlåns = new Udlåns(UI.getInt("angiv BogId"),
                            UI.getInt("angiv lånerId"));
                    Facade.opretUdlån(udlåns);

                case "opret Låner":
                    Låner låner = new Låner(UI.getString("angiv navn"),
                            UI.getString("angiv adresse"),
                            UI.getInt("angiv postnr"));
                    Facade.opretLåner(låner);

            }
        }

    }
}