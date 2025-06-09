import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String userName="root";
    private static final String password="8932988508@Aa";
    public static void main(String[] args) {
        try {
//            Lode driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

        try {
//            DB Connection
            Connection connection=DriverManager.getConnection(url,userName,password);

//            Create statement
            String query="insert into students (name,age,marks) values (?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);


//             Execute query

            preparedStatement.setString(1,"Shashi");
            preparedStatement.setInt(2,21);
            preparedStatement.setDouble(3,78.3);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("Insertion done");
            }else {
                System.out.println("Database entries are not done");
            }


        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
