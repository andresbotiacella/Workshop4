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
import static spark.Spark.get;
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
        data1 = controller.loadSizeInfo("List1.txt");
        String htmlData = "Test Case # 1<br><br>"; //Title
        htmlData += "<div style=\"display: inline-flex\">";
        htmlData += "<table style=\"border: 1px solid; border-collapse: collapse; text-align: center\">"; //Open Table
        htmlData += "<tr><th style=\"border: 1px solid; width: 150px;\">Class Name</th><th style=\"border: 1px solid; width: 60px;\">LOC</th><th style=\"border: 1px solid; width: 60px;\">Items</th></tr>"; //Header
        for(SizeInfo classData : data1) 
        {
            htmlData += String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", classData.getClassName(), classData.getLoc(), classData.getNumberOfMethods());
        }
        htmlData += "</table><br>"; //Close Table
        result1 = controller.calculateSizeRange(data1);
        htmlData += String.format("<p style=\"float:left; margin-left: 20px\">Very Small = %.5g%n LOCs/Method<br>Small =  %.5g%n LOCs/Method<br>Medium = %.4g%n LOCs/Method<br>Large = %.4g%n LOCs/Method<br>Very Large = %.4g%n LOCs/Method<br></p>", result1.getVerySmall(), result1.getSmall(), result1.getMedium(), result1.getLarge(), result1.getVeryLarge());
        htmlData += "</div><br><br><br>";
        
        
        //Test Case 2
        List<SizeInfo> data2;
        SizeRange result2 = new SizeRange();
        data2 = controller.loadSizeInfo("List2.txt");
        htmlData += "Test Case # 2<br><br>"; //Title
        htmlData += "<div style=\"display: inline-flex\">";
        htmlData += "<table style=\"border: 1px solid; border-collapse: collapse; text-align: center\">"; //Open Table
        htmlData += "<tr><th style=\"border: 1px solid; width: 150px;\">Chapter</th><th style=\"border: 1px solid; width: 60px;\">Pages</th><th style=\"border: 1px solid; width: 60px;\">Items</th></tr>"; //Header
        for(SizeInfo chapterData : data2) 
        {
            htmlData += String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", chapterData.getClassName(), chapterData.getLoc(), chapterData.getNumberOfMethods());
        }
        htmlData += "</table><br>"; //Close Table
        result2 = controller.calculateSizeRange(data2);
        htmlData += String.format("<p style=\"float:left; margin-left: 20px\">Very Small = %.5g%n Pages/Chapter<br>Small =  %.5g%n Pages/Chapter<br>Medium = %.4g%n Pages/Chapter<br>Large = %.4g%n Pages/Chapter<br>Very Large = %.4g%n Pages/Chapter<br></p>", result2.getVerySmall(), result2.getSmall(), result2.getMedium(), result2.getLarge(), result2.getVeryLarge());
        htmlData += "</div><br><br>";
 
        return htmlData;
    });
    
    /**
     *Display Index
     */
    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

  }

}
