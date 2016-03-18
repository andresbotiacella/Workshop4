import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import static spark.Spark.*;
import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import com.heroku.sdk.jdbc.DatabaseUrl;
import java.util.List;

import workshop4.Controller.SizeController;
import workshop4.Model.SizeInfo;
import workshop4.Model.SizeRange;
import static spark.Spark.get;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    
    /**
     *Calculates and Displays Size
     */
    get("/calculateSize", (req, res) -> {
        
        SizeController controller = new SizeController();
        
        //Test Case 1
        List<SizeInfo> data1;
        SizeRange result1 = new SizeRange();
        data1 = controller.loadClassInfo("List1.txt");
        String htmlData = "Test Case # 1<br>"; //Header
        htmlData += "<table>"; //Open Table
        for(SizeInfo classData : data1) 
        {
            htmlData += String.format("<tr><td style=\"border: 1px solid black\">%s</td><td>%d</td><td>%d</td></tr>", classData.getClassName(), classData.getLoc(), classData.getNumberOfMethods());
        }
        htmlData += "</table><br>"; //Close Table
        result1 = controller.calculateSizeRange(data1);
        htmlData += String.format("<p>VS = %.5g%n LOC/Method<br>S =  %.5g%n LOC/Method<br>M = %.4g%n LOC/Method<br>L = %.4g%n LOC/Method<br>VL = %.4g%n LOC/Method<br></p>", result1.getVerySmall(), result1.getSmall(), result1.getMedium(), result1.getLarge(), result1.getVeryLarge());

        
        
        //Test Case 2
        List<SizeInfo> data2;
        SizeRange result2 = new SizeRange();
        data2 = controller.loadClassInfo("List2.txt");
        htmlData += "Test Case # 2<br>"; //Header
        htmlData += "<table border=\"1px solid\">"; //Open Table
        for(SizeInfo chapterData : data2) 
        {
            htmlData += String.format("<tr><td>%s</td><td>%f</td><td>%f</td></tr>", chapterData.getClassName(), chapterData.getLoc(), chapterData.getNumberOfMethods());
        }
        htmlData += "</table><br>"; //Close Table
        result2 = controller.calculateSizeRange(data2);
        htmlData += String.format("<p>VS = %.5g%n pages/Chapter<br>S =  %.5g%n pages/Chapter<br>M = %.4g%n pages/Chapter<br>L = %.4g%n pages/Chapter<br>VL = %.4g%n pages/Chapter<br></p>", result2.getVerySmall(), result2.getSmall(), result2.getMedium(), result2.getLarge(), result2.getVeryLarge());

 
        return htmlData;
    });
    
    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

  }

}
