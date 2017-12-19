package httpserver;

import java.io.*;
import java.net.*;
import java.util.Date;

//import content
import requesthandler.*;

/**
 *
 * @author peeratat.m.p
 */
public class RouterService {

    private final PrintWriter pw;
    private final String httpMethod;
    private final String url;

    public RouterService(PrintWriter printWriter, String url, String httpMethod) {
        this.pw = printWriter;
        this.url = url;
        this.httpMethod = httpMethod;
    }

    public void process() throws Exception {

        System.out.println(">>>>>>>Process<<<<<<<<");
        URL myUrl = new URL(this.url);
        if (!myUrl.getProtocol().equalsIgnoreCase("http")) {
            System.err.println("I only understand http.");
            return;
        }
        if (httpMethod.toLowerCase().equals("get")) {
            switch (myUrl.getPath()) {
                case "/":
                    System.out.println("Response... " + myUrl.getPath());
                    IndexRequestHandler index = new IndexRequestHandler(pw, url);
                    index.execute();
                    break;
                case "/page1":
                    System.out.println("Response... " + myUrl.getPath());
                    PatiparnRequestHandler pond = new PatiparnRequestHandler(pw);
                    pond.execute();
                    break;
                case "/page2":
                    System.out.println("Response... " + myUrl.getPath());
                    PeeratatRequestHandler pea = new PeeratatRequestHandler(pw);
                    pea.execute();
                    break;
                case "/page3":
                    System.out.println("Response... " + myUrl.getPath());
                    PanupongRequestHandler prince = new PanupongRequestHandler(pw);
                    prince.execute();
                    break;
                default:
                    System.out.println("Response... " + myUrl.getPath());
                    Date today = new Date();
                    pw.println("HTTP/1.0 404 Not Found");
                    pw.println(today.toString());
                    pw.println("Content-Type: text/html");
                    pw.println();
                    pw.println("<h1>ERROR 404 Not Found!!</h1>");
            }
        } else {
            pw.println("HTTP/1.0 501 Not Implemented");
            pw.println();
        }
    }
}
