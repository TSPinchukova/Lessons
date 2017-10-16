import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersRep implements Repository {


    @Override
    public ArrayList<Object> getAll() throws SQLException {
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("SELECT *FROM suppliers"); // аргумент-sqlзапрос
        ResultSet result = ps.executeQuery();
        ArrayList<Object>list = new ArrayList<Object>();
        while (result.next()){
            Suppliers supp = new Suppliers();
            supp.id = result.getInt("id");
            supp.name = result.getString("name");
            supp.email = result.getString("email");
            supp.phone = result.getString("phone");
            supp.adress = result.getString("adress");
            supp.date_reg = result.getString("date_reg");
            list.add(supp);
        }

        return list;
    }

    @Override
    public void add(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("INSERT INTO suppliers(name, email, phone, adress, date_reg) VALUES (?,?,?,?,?)");
        ps.setString(1, supp.name);
        ps.setString(2, supp.email);
        ps.setString(3, supp.phone);
        ps.setString(4, supp.adress);
        ps.setString(5, supp.date_reg);
        ps.executeUpdate();
    }

    @Override
    public void remove(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("DELETE FROM suppliers WHERE id=?");
        ps.setInt(1, supp.id);
        ps.executeUpdate();
    }

    @Override
    public void update(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("UPDATE suppliers SET name=?, email=?, phone=?, adress=?, date_reg=? WHERE id=?");
        ps.setString(1, supp.name);
        ps.setString(2, supp.email);
        ps.setString(3, supp.phone);
        ps.setString(4, supp.adress);
        ps.setString(5, supp.date_reg);
        ps.setInt(6, supp.id);
        ps.executeUpdate();
    }
}
