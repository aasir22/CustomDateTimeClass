package com.mainclass

import com.datetimewithnscala.DateTimeClass
import java.text.SimpleDateFormat
import java.util.TimeZone

object mainObject extends App {
  val dtObject = new DateTimeClass
//  println(dtObject.getCurrentDateTime())
  println(dtObject.getDateAfterTenDays("Aasi", "dd/MM/yyyy"))
  println(dtObject.getDateAfterTenDays("01/02/2000", "MM/dd/yyyy"))
//  println(dtObject.getDateBeforeTenDays("12/06/2001", "dd/MM/yyyy"))//
//  println(dtObject.dateFormatChanger("12/01/2000", "dd/MM/yyyy"))
//  println(dtObject.dateFormatChanger("12/01/2000", "MM/dd/yyyy"))
//
//  println(dtObject.durationBetweenTwoTimeStamps(1642057212,1642389870))   // 01/13/2022, 12:30:12 pm - 1/17/2022, 8:54:30 am => 3 days, 20 hours, 24 minutes and 18 seconds
//  println(dtObject.customDateTimeFormatChanger("dd/MM/yyyy","12/01/2000","MM-dd-yyyy"))
//  println(dtObject.customDateTimeFormatChanger("dd/M/yyyy","12/01/2000","yy/M/dd"))
//  println(dtObject.customDateTimeFormatChanger("dd/MM/yyyy","12/01/2000","MM-dd-yyyy"))
//  println(dtObject.timer(5))
//  val formatterIST = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
//  formatterIST.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"))
//  val date = formatterIST.parse("18-01-2022 5:30:00")
//  println( dtObject.timezoneChanger(date,"Asia/Kolkata"))
}
