/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandler;

import java.io.PrintWriter;

/**
 *
 * @author peeratat
 */
public class PanupongRequestHandler extends RequestHandler{
    private String content = "<!DOCTYPE html>\n" +
"<html>\n" +
"<title>MR.Panupong</title>\n" +
"<meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
"<style>\n" +
"    .center {margin: auto;}\n" +
"    .text-center{text-align: center;}\n" +
"    .block{display: block;}\n" +
"</style>\n" +
"<body>\n" +
"\n" +
"<div class=\"w3-container w3-border w3-border-black w3-margin w3-round\" >\n" +
"    <div class=\"w3-container w3-black w3-margin w3-round\">\n" +
"        <h1 class=\"center text-center\">ประวัติส่วนตัวของ</h1>\n" +
"    </div>\n" +
"    <div class=\"w3-card-4 center w3-round w3-margin-bottom\" style=\"width:70%;\">\n" +
"            <header class=\"w3-container w3-black\">\n" +
"              <h2 class=\"text-center\">นายภาณุพงศ์ เต่าแก้ว</h2>\n" +
"            </header>\n" +
"        \n" +
"            <div class=\"w3-container\">\n" +
"                <pre>\n" +
"                    <strong>ชื่อ</strong> ภาณุพงศ์ <strong>นามสกุล</strong> เต่าแก้ว\n" +
"                    <strong>รหัสนิสิต</strong> 5821602823\n" +
"                    <strong>เชื้อชาติ</strong> ไทย <strong>สัญชาติ</strong> ไทย <strong>ศาสนา</strong> พุทธ\n" +
"                    <strong>วันเกิด</strong> 1 พฤศจิกายน พ.ศ.2539 <strong>อายุ</strong> 20 ปี\n" +
"                    <strong>e-mail</strong> supha.chai@hotmail.com\n" +
"                    <strong>การศึกษา</strong>\n" +
"                        <strong>ที่ผ่านมา</strong>\n" +
"                            อนุบาล-โรงเรียนจารุวัฒนานุกูล จ.กรุงเทพมหานคร,\n" +
"                            ประถม-โรงเรียนวิชัยวิทยา จ.กรุงเทพมหานคร,\n" +
"                            มัธยม- โรงเรียนกรพิทักษ์ศึกษา จ.กรุงเทพมหานคร\n" +
"                        <strong>ปัจจุบัน</strong>\n" +
"                            มหาวิทยาลัยเกษตรศาสตร์ วิทยาเขตกําแพงแสน จังหวัดนครปฐม สาขาวิทยาการคอมพิวเตอร์ ภาคปกติ\n" +
"                    <strong>ความชื่อชอบ</strong>\n" +
"                        เปียโน,ฟุตบอล,เกมส์,ถ่ายรูป\n" +
"                    <strong>เป้าหมายอนาคต</strong>\n" +
"                       นักเปียโน,คนรวย,ช่างภาพ,นักแต่งเพลง\n" +
"                </pre>\n" +
"            </div>\n" +
"        \n" +
"          </div>\n" +
"    \n" +
"</div>\n" +
"\n" +
"</body>\n" +
"</html>";
    public PanupongRequestHandler(PrintWriter pw){
        super(pw);
    }
    
    @Override
    public String getContent(){
        return this.content;
    }
    
    @Override
    public void execute(){
        sendHeader();
        pw.println(getContent());
    }
}
