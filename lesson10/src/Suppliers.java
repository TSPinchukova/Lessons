public class Suppliers {
    @Override
    public String toString(){
        String s = String.format("id:%d name:%s email:%s phone:%s adress:%s date_reg:%s\n", id,name,email,phone,adress,date_reg);
        return s;
    }

    public int id;
    public String name;
    public String email;
    public String phone;
    public String adress;
    public String date_reg;

}
