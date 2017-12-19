/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandler;

import java.io.PrintWriter;

/**
 *
 * @author myhome
 */
public class IndexRequestHandler extends RequestHandler{
    private String url;
    private String content;
    public IndexRequestHandler(PrintWriter pw, String url){
        super(pw);
        this.url = url;
        this.content = "<!DOCTYPE html>\n" +
"<html>\n" +
"<title>index</title>\n" +
"<meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
"<style>\n" +
"    .center {margin: auto;}\n" +
"    .text-center{text-align: center;}\n" +
"    .block{display: block;}\n" +
"</style>\n" +
"<body>\n" +
"<img src=\"https://dars.io/wp-content/uploads/2015/06/1435934506-50d83ee90498b3e4f9578a58ff8b5880.png\"\n" +
"width=\"1080\" height=\"600\" alt=\"hello world กรุณาเชื่อมต่ออินเตอร์เน็ต\" class=\"w3-margin-top center block w3-round\">\n" +
"\n" +
"<div class=\"w3-container w3-border w3-border-black w3-margin w3-round\" >\n" +
"    <div class=\"w3-container w3-black w3-margin w3-round\">\n" +
"        <h1 class=\"center text-center\">ยินดีต้อนรับเข้าสู่หน้าแรก</h1>\n" +
"    </div>\n" +
"    <div class=\"w3-container w3-border w3-border-black w3-margin w3-round\">\n" +
"        <h1 class=\"w3-container w3-black w3-margin center text-center w3-round\">ประวัติส่วนตัว</h1>\n" +
"        <div class=\"w3-container center text-center\">\n" +
"            <a href=\""+this.url+"page1\" class=\"w3-btn w3-black w3-margin w3-round\">นาย ปฏิภาน สมดุลยกนก</a>\n" +
"            <a href=\""+this.url+"page2\" class=\"w3-btn w3-black w3-margin w3-round\">นาย พีรทัต มันทะกะ</a>\n" +
"            <a href=\""+this.url+"page3\" class=\"w3-btn w3-black w3-margin w3-round\">นาย ภาณุพงศ์ เต่าแก้ว</a>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>\n" +
"\n" +
"</body>\n" +
"</html>";
    }
    @Override
    public String getContent() {
        return this.content;
    }
    
    @Override
    public void execute(){
        sendHeader();
        pw.println(getContent());
    }
}
