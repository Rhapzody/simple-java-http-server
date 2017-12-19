package httpserver;

import java.io.*;
import java.net.*;
/**
 *
 * @author peeratat.m.p
 */
public class MultithreadHttpServer extends Thread {

    private final Socket clientConnection;
    private final String host;
    private final String port;

    public MultithreadHttpServer(Socket clientConnection, InetAddress serverHost, ServerSocket socket) {
        this.host = serverHost.getHostAddress();
        this.port = socket.getLocalPort() + "";
        this.clientConnection = clientConnection;
    }

    @Override
    public void run() {
        try {
            //get input-output stream
            InputStreamReader isr = new InputStreamReader(clientConnection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            BufferedOutputStream bos = new BufferedOutputStream(clientConnection.getOutputStream());
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(bos));
            
            //Read first line input (Request)
            String line = reader.readLine();
            if (line != null) {//Check for NullPointerException :(
                
                //http method & url from request
                String requestPart[] = line.split(" ");
                String url = requestPart[2].substring(0, 4).toLowerCase()
                        + "://" + this.host
                        + ":" + this.port
                        + requestPart[1].substring(0, requestPart[1].length());
                String httpMethod = requestPart[0];
                
                //Show request imformation on the console
                System.out.println("\nURL : " + url + "\nHttp Method : " + httpMethod);
                System.out.println(">>>>>>>>Request<<<<<<<<");
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                
                //Rout to request handler for a thread
                RouterService ts;
                ts = new RouterService(pw, url, httpMethod);
                ts.process();
            }
            
            //shutdown streaming & disconnect
            pw.flush();
            bos.flush();
            clientConnection.close();
            System.out.println("Disconnected");
        }catch(IOException iox){
            iox.printStackTrace();
        }catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    //Program start here
    public static void main(String[] args) {
        
        //Create tcp server
        ServerSocket socket;
        InetAddress serverHost;
        int port = 6789;
        try {
            socket = new ServerSocket(port);
            serverHost = InetAddress.getLocalHost();
            System.out.println("Server Address: " + serverHost.getHostAddress()
                    + ", Port: " + socket.getLocalPort());
            
            /* Repeatedly handle requests for processing. */
            while (true) {
                Socket clientCon = socket.accept();
                Thread t = new MultithreadHttpServer(clientCon, serverHost, socket);
                t.start();
            }
        }catch(IOException iox){
            iox.printStackTrace();
        }catch (Exception x) {
            x.printStackTrace();
        }
    }

}
