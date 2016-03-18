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

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    
    get("/calculateSize", (req, res) -> {
        
        String[] FILE_NAMES = {"List1.txt", "List2.txt"};
        List<SizeInfo> data;
        SizeController controller = new SizeController();
        SizeRange result = new SizeRange();
        String dataString = "<p><br>";
        int count = 1;
        for(String fileName : FILE_NAMES) {
            data = controller.loadClassInfo(fileName);
            dataString += String.format("Caso de prueba %d<br><table border=\"1\">", count);
            for(SizeInfo classInfo : data) {
                dataString += String.format("<tr><td>%s</td><td>%f</td><td>%f</td></tr>", classInfo.getClassName(), classInfo.getLoc(), classInfo.getNumberOfMethods());
            }
            dataString += "</table><br>";
            result = controller.calculateSizeRange(data);
            if(count == 1) {
                dataString += String.format("<p>VS = %.5g%n LOC/Method<br>S =  %.5g%n LOC/Method<br>M = %.4g%n LOC/Method<br>L = %.4g%n LOC/Method<br>VL = %.4g%n LOC/Method<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());

            }else {
                dataString += String.format("<p>VS = %.5g%n pages/Chapter<br>S =  %.5g%n pages/Chapter<br>M = %.4g%n pages/Chapter<br>L = %.4g%n pages/Chapter<br>VL = %.4g%n pages/Chapter<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());
 
            }
            count++;
        }
        return dataString;
    });

  }

}
