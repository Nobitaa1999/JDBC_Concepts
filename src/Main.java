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
            Statement statement=connection.createStatement();


//             Execute query
            String query="select * from students";
            ResultSet resultSet=statement.executeQuery(query);

//            process query
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                double marks=resultSet.getDouble("marks");
                System.out.println("id : "+id);
                System.out.println("name : "+name);
                System.out.println("age : "+age);
                System.out.println("marks : "+marks);
            }





//               For delete
            String query1=String.format("delete from students where id=%d",3);
            int result1 =statement.executeUpdate(query1);
            if(result1>0){
                System.out.println("deletion succesfully done");
            }else {
                System.out.println("no entry is deleted");
            }



//             For update
            String query2=String.format("update students set marks=%f where id=%d ",79.9,3);
            int result2 =statement.executeUpdate(query2);
            if(result2>0){
                System.out.println("Updation succesfully done");
            }else {
                System.out.println("Database entries are not updated");
            }






        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
