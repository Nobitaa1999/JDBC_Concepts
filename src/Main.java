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

            Scanner input=new Scanner(System.in);
            while(true){
                System.out.print("Enter name : ");
                String name=input.next();
                System.out.print("Enter age : ");
                int age=input.nextInt();
                System.out.print("Enter marks : ");
                Double marks=input.nextDouble();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);
                System.out.print("Enter more entries press(Y/N) : ");
                String chiose=input.next();
                preparedStatement.addBatch();
                if(chiose.toUpperCase().equals("N")){
                    break;
                }
            }

            int []arr=preparedStatement.executeBatch();
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    System.out.println((i+1) +"th query not added");
                    break;
                }else{
                    System.out.println((i+1) +"th query added");
                }
            }





        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
