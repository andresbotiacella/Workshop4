/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class SizeModel {
    
    /**
     *Load data from file into a List of objects
     * 
     * @param fileName File to read the data
     * @return List with the information read from the file
     */
    public static List<SizeInfo> loadDataFromFile(String fileName) {
        List<SizeInfo> dataList = new ArrayList<>();
        File archive = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                StringTokenizer stringTokenized = new StringTokenizer(line, "\n");
                if(stringTokenized.hasMoreTokens()) {
                    SizeInfo classInfo = new SizeInfo();
                    String[] stringsInLine = stringTokenized.nextToken().split("-");
                    classInfo.setClassName(stringsInLine[0]);
                    classInfo.setLoc(Double.parseDouble(stringsInLine[1]));
                    classInfo.setNumberOfMethods(Double.parseDouble(stringsInLine[2]));
                    dataList.add(classInfo);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SizeModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SizeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataList;
    }
}
