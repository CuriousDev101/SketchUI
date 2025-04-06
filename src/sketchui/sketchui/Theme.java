package sketchui;

public class Theme {
  public int bgColor;
  public int fgColor;
  public int activeColor;
  public int hoverColor;
  public int borderColor;
  public int textColor;
  public int cursorColor;
  public float borderRadius;
  public float borderWidth;

  public Theme(
      int bgColor,
      int fgColor,
      int activeColor,
      int hoverColor,
      int borderColor,
      int textColor,
      int cursorColor,
      float borderRadius,
      float borderWidth) {
    this.bgColor = bgColor;
    this.fgColor = fgColor;
    this.activeColor = activeColor;
    this.hoverColor = hoverColor;
    this.borderColor = borderColor;
    this.textColor = textColor;
    this.cursorColor = cursorColor;
    this.borderRadius = borderRadius;
    this.borderWidth = borderWidth;
  }
}
