import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
public static void main(String args[])
{
    System.out.println("Welcome to the Chat framework");
    System.out.println("What would you like to do :- 1.Start the server 2.Connect to a server");
    int choice=scanner.nextInt();

    switch (choice)
    {
        case 1: Server serv = new Server();
                serv.serverfunc();
                break;

        case 2: Client client = new Client();
                client.clientfunc();
                break;

        default: System.out.println("Wrong choice program exiting");
                 break;




    }
    return;
}
}
