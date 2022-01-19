package com.datetimewithnscala

import com.github.nscala_time.time.Imports._
import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}

class DateTimeClass() {
  // 1
  def getCurrentDateTime(): String = {
    /**
     * input = None
     * output = return current date
     */
    DateTime.now.toString("dd/MM/yyyy hh:mm:ss")
  }

  // 2
  def getDateAfterTenDays(date: String, format: String): String = {
    /**
     * input = date as String, format as String
     * output = return date after 10 days from the current date
     */
    try {
      if (checkFormatOfDate(format)) {
        val dt = date.toDateTime(format) + 10.days // adding 10 days
        dt.toString("dd/MM/yyyy")
      }
      else "Input Format should be dd/MM/yyyy"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 3
  def getDateBeforeTenDays(date: String, format: String): String = {
    /**
     * input = date as String, format as String
     * output = return date before 10 days from the current date
     */
    try {
      if (checkFormatOfDate(format)) {
        val dt = date.toDateTime(format) - 10.days
        dt.toString("dd/MM/yyyy")
      }
      else "Input Format should be dd/MM/yyyy"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 4
  def dateFormatChanger(date: String, format: String): String = {
    /**
     * formattingDates function changes the format of the given Date
     * input = date as String, format(dd/MM/yyyy) as String
     * output = return date with format of MM/dd/yyyy
     */
    try {
      if (checkFormatOfDate(format)) {
        date.toDateTime(format).toString("MM/dd/yyyy")
      }
      else "Input Format should be dd/MM/yyyy"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 5
  def durationBetweenTwoTimeStamps(startTimeStamp: Long, endTimeStamp: Long): String = {
    /**
     * input = startTimeStamp as Long, endTimeStamp as Long
     * output = returns the duration between two time stamps
     */
    try {
      if (endTimeStamp > startTimeStamp) {
        val ms = endTimeStamp - startTimeStamp
        val days = (ms / 60 / 60 / 24)
        val hours = (ms / 60 / 60) - (days * 24)
        val minutes = (ms / 60) - (days * 24 * 60) - (hours * 60)
        val seconds = (ms % 60)
        days + " days, " + hours + " hours, " + minutes + " minutes," + " and " + seconds + " seconds"
      }
      else "Timestamps are invalid endTimeStamp must be greater than startTimeStamp"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 6
  def customDateTimeFormatChanger(inputformat: String, date: String, outputformat: String): String = {
    val formatsList = List("dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd", "yyyy/dd/MM", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd", "yyyy-dd-MM",
      "dd.MM.yyyy", "MM.dd.yyyy", "yyyy.MM.dd", "yyyy.dd.MM"
    )
    try {
      if (formatsList.contains(inputformat)) {
        date.toDateTime(inputformat).toString(outputformat)
      }
      else "Format is wrong"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 7
  def timezoneChanger(date: Date, timeZone: String) = {
    /**
     * input = date as Date, timeZone as String
     * output = return date in PST
     */
    try {
      if (timeZone == "Asia/Kolkata") {
        val formatterUTC = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        formatterUTC.setTimeZone(TimeZone.getTimeZone("PST"))
        formatterUTC.format(date)
      }
      else "Not a IST Zone"
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }

  // 8
  def timer(seconds: Int): Any = {
    /**
     * input = seconds as Int
     * output = returns time taken for execution
     */
    try {
      val presentTime = LocalTime.now().getSecondOfMinute
      Thread.sleep(seconds * 1000)
      val endTime = LocalTime.now().getSecondOfMinute
      val totalTime = endTime - presentTime
      totalTime
    }
    catch {
      case e: Exception => "Exception occured : " + e
    }
  }


  def checkFormatOfDate(format: String): Boolean = {
    /**
     * This function used to check the format of the date
     */
    if (!format.toLowerCase().equals("dd/mm/yyyy")) {
      false
    }
    else true
  }

}

