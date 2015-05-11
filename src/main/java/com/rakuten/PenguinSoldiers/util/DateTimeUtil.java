package com.rakuten.PenguinSoldiers.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class DateTimeUtil {
  
  public static Timestamp getNow(){
    GregorianCalendar gc=new GregorianCalendar();
    return new Timestamp(gc.getTimeInMillis()); 
  }
  
  
  /*   
   * return a Date class given the year, month and date
   * month = 1 - 12
   *         1  = January
   *         12 = December
  */
  public static Date getDate(int year, int month, int date){
    GregorianCalendar gc=new GregorianCalendar();
    gc.set(GregorianCalendar.YEAR, year);
    gc.set(GregorianCalendar.MONTH, month-1);
    gc.set(GregorianCalendar.DATE, date);
    return new Date(gc.getTimeInMillis());
  }

}
