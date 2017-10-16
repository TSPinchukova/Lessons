import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcConnection.init();
        Suppliers supp = new Suppliers();
        supp.name = "Senya Dub";
        supp.email = "sndf@yandex.ru";
        supp.phone = "375291222222";
        supp.adress = "Gomel";
        supp.date_reg = "1999-02-03";

        SuppliersRep sRep = new SuppliersRep();
        supp.id = 10;
        //sRep.add(supp);
        //sRep.update(supp);
        sRep.remove(supp);
        ArrayList<Object>suppliers = sRep.getAll();
        System.out.println(suppliers);
    }
}
