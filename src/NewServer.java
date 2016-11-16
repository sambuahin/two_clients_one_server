/**
 * Created by sam on 11/5/16.
 */
import java.net.*;
import java.io.*;

public class NewServer
{
    //Create Server Socket and a Client Socket for each Client.
    static ServerSocket server;

    static Socket client1;
    static Socket client2;

    //Create OutputStreams to send information to each Client.
    static DataOutputStream client1writer;
    static DataOutputStream client2writer;

    static final int PORT = 9999;

    //Main Method
    public static void main(String[]args)
    {
        //Try-Catch Block for Socket Errors.
        try
        {
            //Create the Server Socket as a Host.
            server = new ServerSocket(PORT);

            //Connect Client 1 – First run of the Client class.
            client1 = server.accept();
            client1writer = new DataOutputStream(client1.getOutputStream());

            //Connect Client 2 – Second run of the Client class.
            client2 = server.accept();
            client2writer = new DataOutputStream(client2.getOutputStream());

            //Assign each Client an ID number – this is how the Client will know
            //    which individual Client it’s representing in RunTime.
            int ID1 = 8675309;
            int ID2 = 8675308;

            //Tell both Clients which one they are representing.
            client1writer.writeInt(ID1);
            client2writer.writeInt(ID2);

            //Close all Sockets when finished.
            client1.close();
            client2.close();
            server.close();
        }
        catch (IOException IOex)
        {
            System.out.println("Server Error.");
        }
    }
}