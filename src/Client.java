
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public Scanner scan = new Scanner(System.in);
    public void clientfunc()
    {
        System.out.println("Client intializing ....");
        System.out.println("Enter the server I.P address");
        String serip = scan.nextLine();

        System.out.println("Connecting..");

        String message="";
        String response="";

        try(Socket clientsock= new Socket(InetAddress.getByName(serip), 80))
        {
          //  BufferedReader inp = new BufferedReader( new InputStreamReader(clientsock.getInputStream()));
            PrintWriter outp = new PrintWriter(clientsock.getOutputStream(), true);
            System.out.println("Connected to server. Enter your chat message");
            Readthread clientread = new Readthread(clientsock);
            while(!message.equalsIgnoreCase("exit")&&!response.equalsIgnoreCase("exit"))
            {

             message=scan.nextLine();
             outp.println(message);


            }
            System.out.println("Exiting");
        }
        catch (IOException c)
        {
            System.out.println("Error" +c);
        }




    }
}
