/**
 * Created by sam on 11/5/16.
 */
import java.net.*;
import java.io.*;

public class NewClient
{
    //Write Your Code Here!
    static Socket client1 = null;
    static Socket client2 = null;

    //new ports and localhost
    static final int PORT = 9999;
    static final String IP = "localhost";

    //new data inout streams
    static DataInputStream reader1;
    static DataInputStream reader2;

    public static void main(String[] args) throws IOException {

        int id1;
        int id2;

        try{
            //sockets for clients
            client1 = new Socket(IP,PORT);
            client2 = new Socket(IP,PORT);
            System.out.println("Connection to Server successful!");


            //readers and dta input streams
            reader1 = new DataInputStream(client1.getInputStream());
            reader2 = new DataInputStream(client2.getInputStream());

            //these wil hold values passed form server
            id1 = reader1.readInt();
            id2 = reader2.readInt();

            System.out.println("The id of Client 1 is " + id1);
            System.out.println("The id of Client 2 is " + id2);

            //Closing Clients
            client1.close();
            client2.close();

            //close readers
            reader1.close();
            reader2.close();

        }catch(IOException error) {
            System.err.println("Server error.");
        }
    }


}