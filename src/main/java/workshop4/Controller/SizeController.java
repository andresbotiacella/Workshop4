/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4.Controller;

import workshop4.Model.SizeManager;
import workshop4.Model.SizeInfo;
import workshop4.Model.SizeModel;
import workshop4.Model.SizeRange;
import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class SizeController {
    
    public List<SizeInfo> loadClassInfo(String fileName) {
        return SizeModel.loadDataFromFile(fileName);
    }
    
    public SizeRange calculateSizeRange(List<SizeInfo> classInfoList) {
        SizeRange sizeRange = new SizeRange();
        sizeRange.setAverage(SizeManager.average(classInfoList));
        sizeRange.setVariance(SizeManager.variance(classInfoList));
        return sizeRange;
    }
}
