package sketchui;

public class Button extends UIElement {
  private String label;
  private float posX, posY;
  private float w, h;
  private int bgColor, fgColor, activeColor, hoverColor, borderColor;

  public Button(String label) {
    this.label = label;
  }

  public Button(String label, float x, float y) {
    this.label = label;
    this.posX = x;
    this.posY = y;
  }

  public Button(String label, float x, float y, float w, float h) {
    this.label = label;
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
  }

  public Button(String label, int bgColor, float x, float y, float w, float h) {
    this.label = label;
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
    this.bgColor = bgColor;
  }

  @Override
  public void draw() {
    applet.rect(posX, posY, w, h);

  }

  private void defaultSettings() {}
}
