package edu.usm.cos420.antenatal.view;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by aaron on 3/11/2016.
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
  private String datePattern = "yyyy-MM-dd";
  private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

  @Override
  public Object stringToValue(String text) throws ParseException {
    return dateFormatter.parseObject(text);
  }

  @Override
  public String valueToString(Object value) throws ParseException {
    if (value != null) {
      Calendar cal = (Calendar) value;
      return dateFormatter.format(cal.getTime());
    }
    return "";
  }
}
