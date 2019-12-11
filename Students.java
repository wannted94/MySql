package com.cursmysql;

import java.sql.*;

public class Students {
    private String numar_matricol;
    private String nume;
    private String prenume;
    private String cnp;
    private String data_nasterii;
    public Students(String nrMatricol, String nume, String prenume, String cnp, String dataNastere){
        this.numar_matricol = nrMatricol;
        this.nume = nume ;
        this.prenume = prenume ;
        this.cnp =cnp;
        this.data_nasterii = dataNastere;
    }
    public String getNumar_matricol(){ return numar_matricol; }
    public String getNume() { return nume;}
    public String getPrenume() { return  prenume;}
    public String getCnp() {return cnp; }
    public String getData_nasterii () {return data_nasterii;}
    public static void showStudents(){
        String sql = "SELECT * FROM studenti";
        Connection connection = DbConnector.getDbConnection();
        Statement statement;
        ResultSet result;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            int count = 0;
            while (result.next()){
                Integer id =result.getInt(1);
                String nrMatricol = result.getString(2);
                String nume= result.getString(3);
                String prenume = result.getString(4);
                ++count;
                System.out.println("Student : Nr -"+count+" ID: "+id+"Nr. Matricol: "+nrMatricol+" Nume "+nume+" Prenume "+prenume);
            }
        }
        catch (SQLException e){
            System.err.println("Query error.");
        }
        catch (NullPointerException e) {
            System.err.println("Element not found.");
        }
    }
}
