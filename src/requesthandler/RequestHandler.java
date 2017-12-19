/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandler;

import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author myhome
 */
public abstract class RequestHandler {
    protected PrintWriter pw;
    public RequestHandler(PrintWriter pw){
        this.pw = pw;
    }
    public void sendHeader(){
        Date today = new Date();
        pw.println("HTTP/1.0 200 OK");
        pw.println(today.toString());
        pw.println("Content-Type: text/html");
        pw.println();
    }
    public abstract String getContent();
    public abstract void execute();
}
