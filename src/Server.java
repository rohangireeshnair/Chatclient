import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Scanner scan = new Scanner(System.in);
    public void serverfunc()
    {
        System.out.println("Initializing Server...");




                String message="";
                String response="";
                try(ServerSocket sock1 = new ServerSocket(80))
                {
                System.out.println("Waiting for client ......");
                Socket sock2 = sock1.accept();
                System.out.println("Client connected");
                BufferedReader inp = new BufferedReader(new InputStreamReader(sock2.getInputStream()));
                PrintWriter outp = new PrintWriter(sock2.getOutputStream(), true);
                    Readthread serverread = new Readthread(sock2);
                    while(!message.equalsIgnoreCase("exit")&&!response.equalsIgnoreCase("exit"))
                {

                    message=scan.nextLine();
                    outp.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error encountered " + e);
            }








        }
}
