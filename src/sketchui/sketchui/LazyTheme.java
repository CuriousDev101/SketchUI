package sketchui;

import java.lang.reflect.Field;

public class LazyTheme extends Sketchui {

  public int bgColor;
  public int fgColor;
  public int activeColor;
  public int hoverColor;
  public int borderColor;
  public int textColor;
  public int cursorColor;
  public float borderRadius;
  public float borderWidth;

  public LazyTheme() {
    super();
  }

  public void applyTheme(UIElement<?> element, Theme theme) {
    element
        .setBackground(theme.bgColor)
        .setForeground(theme.fgColor)
        .setActiveColor(theme.activeColor)
        .setHoverColor(theme.hoverColor)
        .setBorderColor(theme.borderColor)
        .setTextColor(theme.textColor)
        .setCursorColor(theme.cursorColor)
        .setBorderRadius(theme.borderRadius)
        .setBorderWidth(theme.borderWidth);
  }

  public void applyTheme(Class<?> themeClass) {
    try {
      Field[] fields = themeClass.getFields();
      for (Field field : fields) {
        if (field.getName().equals("BG_COLOR")) {
          bgColor = (int) field.get(null);
        } else if (field.getName().equals("FG_COLOR")) {
          fgColor = (int) field.get(null);
        } else if (field.getName().equals("ACTIVE_COLOR")) {
          activeColor = (int) field.get(null);
        } else if (field.getName().equals("HOVER_COLOR")) {
          hoverColor = (int) field.get(null);
        } else if (field.getName().equals("BORDER_COLOR")) {
          borderColor = (int) field.get(null);
        } else if (field.getName().equals("TEXT_COLOR")) {
          textColor = (int) field.get(null);
        } else if (field.getName().equals("CURSOR_COLOR")) {
          cursorColor = (int) field.get(null);
        } else if (field.getName().equals("BORDER_WIDTH")) {
          borderWidth = (float) field.get(null);
        } else if (field.getName().equals("BORDER_RADIUS")) {
          borderRadius = (float) field.get(null);
        }
      }
      for (var e : elements) {
        applyTheme(
            e,
            new Theme(
                bgColor,
                fgColor,
                activeColor,
                hoverColor,
                borderColor,
                textColor,
                cursorColor,
                borderRadius,
                borderWidth));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
