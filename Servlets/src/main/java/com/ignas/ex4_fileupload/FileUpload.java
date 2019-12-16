package com.ignas.ex4_fileupload;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(
        fileSizeThreshold = 1024*1024*2, //2MB
        maxFileSize = 1024*1024*100, //10 MB
        maxRequestSize = 1024*1024*50 //50 MB
)
public class FileUpload extends HttpServlet {

    private static final String SAVE_DIR = "FileUploadDestination";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Sorry!... GET method cant handle this request");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if( !fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }

        String fileName = "";
        for(Part part : request.getParts()){
            if(!extractFileName(part).equals("") && fileName == "")
                fileName = extractFileName(part);
            else
                break;
            System.out.println("Path to write:" + savePath + File.separator + fileName);
            part.write(savePath + File.separator + fileName);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>File Upload Result </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>File Uploaded Successfully...");
        out.println("</body>");
        out.println("</html>");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("Content Disposition: " + contentDisp);
        String[] items = contentDisp.split("\";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}