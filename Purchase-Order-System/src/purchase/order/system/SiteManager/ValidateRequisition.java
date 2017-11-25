/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ValidateRequisition {
    
    public boolean validateRequiredDate(Date reqDate){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date weekDate;
        Date requiredDate;
        try {
            requiredDate=sdf.parse(sdf.format(reqDate));
            weekDate=sdf.parse(sdf.format(gettWeekDate()));
        } catch (ParseException ex) {
           
            return false;
        }
        
        if(requiredDate.compareTo(weekDate)<0){
            JOptionPane.showMessageDialog(null, "Requisition Should be placed before one week");
            return false;
        }else{
            
            return true;
        }   
    }
    
    private Date gettWeekDate() {

        SimpleDateFormat df = new SimpleDateFormat("EEEE dd/MM/yyyy");
        Date date1 = null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        String week = df.format(c.getTime());
        try {
            date1 = df.parse(week);

        } catch (ParseException ex) {
            
        }
        return date1;
    }
    
    private int getDateDiff(Date dateStart,Date dateEndDate) {

        Calendar startCal = Calendar.getInstance();
        startCal.setTime(dateStart);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(dateEndDate);

        int differenece = 0;
               
        do {
                            
            ++differenece;
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); 

        return differenece;

    }
}
