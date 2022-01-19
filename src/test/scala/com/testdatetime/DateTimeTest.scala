package com.testdatetime

import com.datetimewithnscala._
import com.github.nscala_time.time.Imports._
import org.scalatest.funsuite.AnyFunSuite

import java.text.SimpleDateFormat
import java.util.TimeZone

class DateTimeTest extends AnyFunSuite {
  val dtObject = new DateTimeClass
//  test1
  test("Current time test") {
    assert(DateTime.now() .toString("dd/MM/yyyy hh:mm:ss") == dtObject.getCurrentDateTime())
  }

  //test2
  test("Date before ten days test"){
    assert(dtObject.getDateBeforeTenDays("12/01/2000", "dd/MM/yyyy") == "02/01/2000")
    assert(dtObject.dateFormatChanger("01/12/2000","MM/dd/yyyy") == "Input Format should be dd/MM/yyyy")
  }

  //test3
  test("Date after ten days test"){
    assert(dtObject.getDateAfterTenDays("12/06/2001", "dd/MM/yyyy") == "22/06/2001")
    assert(dtObject.dateFormatChanger("01/12/2000","MM/dd/yyyy") == "Input Format should be dd/MM/yyyy")
  }

  //test4
  test("Test for correct format"){
    assert(dtObject.dateFormatChanger("22/06/2001","dd/MM/yyyy") == "06/22/2001")
    assert(dtObject.dateFormatChanger("01/12/2000","MM/dd/yyyy") == "Input Format should be dd/MM/yyyy")
  }

  //test 5
  test("durationBetweenTwoDays test"){
    assert(dtObject.durationBetweenTwoTimeStamps(1642057212,1642389870) == "3 days, 20 hours, 24 minutes, and 18 seconds")
    assert(dtObject.durationBetweenTwoTimeStamps(1642389870,1642057212) == "Timestamps are invalid endTimeStamp must be greater than startTimeStamp")
  }

  //test6
  test("Custom formatter"){
    assert(dtObject.customDateTimeFormatChanger("dd/MM/yyyy","22/06/2001","MM/dd/yyyy") == "06/22/2001")
    assert(dtObject.customDateTimeFormatChanger("M/dd/yyy","06/22/2001","dd/MM/yyyy") == "Format is wrong")
  }

  // test7
      test("zone conversion"){
      val zone= "Asia/Kolkata"
      val zone1 ="PST"
      val tz = TimeZone.getTimeZone(zone)
      val formatterIST = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
      formatterIST.setTimeZone(tz)
      val date = formatterIST.parse("18-01-2022 5:30:00")
      val date2= "17-01-2022 16:00:00"
      assert(dtObject.timezoneChanger(date,zone)==date2)
      assert(dtObject.timezoneChanger(date,zone1)=="Not a IST Zone")
    }

    //test8
  test("Timer test"){
    val sec = 5
    assert(dtObject.timer(sec) == sec)
  }



}
