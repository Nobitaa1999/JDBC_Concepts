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
            Statement statement= connection.createStatement();
            Scanner input=new Scanner(System.in);
            while(true){
                System.out.print("Enter name : ");
                String name=input.next();
                System.out.print("Enter age : ");
                int age=input.nextInt();
                System.out.print("Enter marks : ");
                Double marks=input.nextDouble();
                System.out.print("Enter more entries press(Y/N) : ");
                String chiose=input.next();
                String query=String.format("insert into students (name,age,marks) values ('%s',%d,%f)",name,age,marks);
                statement.addBatch(query);
                if(chiose.toUpperCase().equals("N")){
                    break;
                }
            }
            int [] arr=statement.executeBatch();

            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    System.out.println((i+1) +"th query not added");
                }
            }




        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
