package top.soft.class03response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lenovo
 * @description: TODO
 * @date 2024/9/28 14:55
 */
@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String type = req.getParameter("type");
        System.out.println(type);
       switch (type) {
           case "image":
               getImage(req, resp);
               break;
               default:
                   break;
       }
    }

    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("image/png");
        String realpath = req.getServletContext().getRealPath("/images/fgy.png");
        File file = new File(realpath);
        InputStream inputStream = new FileInputStream(file);
        int read=0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while((read=inputStream.read())!=-1){
            outputStream.write(read);
        }
    }
}
