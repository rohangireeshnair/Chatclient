import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Readthread extends Thread{
    Socket readsocket;
    String message;
    Readthread(Socket readsocket)
    {
        super("Read thread");
        this.readsocket=readsocket;
        start();


    }
    public void run()
    {
        try {
            BufferedReader inp = new BufferedReader( new InputStreamReader(readsocket.getInputStream()));
            while(true)
            {
                message=inp.readLine();
                System.out.println(message);
            }
        }
        catch (Exception c)
        {
            System.out.println(c);
        }
    }
}
