package br.com.fiap.model.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexao(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            //final String USER = "RM556448";
            //final String PASS = "fiap24";
            final String USER = "RM555100";
            final String PASS = "261005";
            con = DriverManager.getConnection(url,USER,PASS);
            System.out.println("Conexão aberta");
        }catch (ClassNotFoundException e){
            System.out.println("A classe de conexão não foi encontrada. " + e.getMessage() );
        }catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage() );
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage() );
        }
        return con;
    }

    public static void fecharConexao(Connection con){
        try{
            con.close();
            System.out.println("Conexão fechada.");
        }catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage() );
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage() );
        }
    }
}
