package com.rakuten.PenguinSoldiers.util;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Util {
  
  public static Timestamp getNow(){
    GregorianCalendar gc=new GregorianCalendar();
    return new Timestamp(gc.getTimeInMillis()); 
  }
}
