package sketchui;

import processing.core.PApplet;
import processing.core.PFont;

@SuppressWarnings("unchecked")
public abstract class UIElement<T extends UIElement<T>> {
  PApplet applet;
  boolean isRegistered = false;

  protected String text, value, input = "", placeholder, tooltip;
  protected float posX, posY;
  protected float currX, currY;
  protected float w, h, tl, tr, br, bl, roundness;
  protected float borderWidth = 1.5f;
  protected int alignment;
  protected int bgColor, fgColor, activeColor, hoverColor, borderColor, textColor, cursorColor;

  protected boolean isRound = false;
  protected boolean isClicked = false;
  protected boolean visibility = true;

  protected PFont font;

  public T setPosition(float x, float y) {
    this.currX = x;
    this.currY = y;
    return (T) this;
  }

  public T setPosition(int alignment, float x, float y) {
    this.currX = x;
    this.currY = y;
    this.alignment = alignment;
    return (T) this;
  }

  public T setAlignment(int alignment) {
    this.alignment = alignment;
    return (T) this;
  }

  public T setAlignment(int alignment, float x, float y) {
    this.currX = x;
    this.currY = y;
    this.alignment = alignment;
    return (T) this;
  }

  public T setAlignment(int alignment, float x, float y, float w, float h) {
    this.currX = x;
    this.currY = y;
    this.alignment = alignment;
    this.w = w;
    this.h = h;
    return (T) this;
  }

  public T setAlignment(
      int alignment, float x, float y, float w, float h, float tl, float tr, float br, float bl) {
    this.currX = x;
    this.currY = y;
    this.alignment = alignment;
    this.w = w;
    this.h = h;
    this.tl = tl;
    this.tr = tr;
    this.br = br;
    this.bl = bl;
    return (T) this;
  }

  public T setSize(float w, float h) {
    this.w = w;
    this.h = h;
    return (T) this;
  }

  public T setSize(float w, float h, float r) {
    this.w = w;
    this.h = h;
    this.roundness = r;
    return (T) this;
  }

  public T setSize(float w, float h, float tl, float tr, float br, float bl) {
    this.w = w;
    this.h = h;
    this.tl = tl;
    this.tr = tr;
    this.br = br;
    this.bl = bl;
    this.isRound = true;
    return (T) this;
  }

  public T setBackground(int gray) {
    bgColor = gray;
    return (T) this;
  }

  public T setBackground(int hue, int gray) {
    bgColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setBackground(int r, int g, int b) {
    bgColor = createColor(r, g, b);
    return (T) this;
  }

  public T setForeground(int gray) {
    fgColor = gray;
    return (T) this;
  }

  public T setForeground(int hue, int gray) {
    fgColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setForeground(int r, int g, int b) {
    fgColor = createColor(r, g, b);
    return (T) this;
  }

  public T setBorderColor(int grey) {
    borderColor = grey;
    return (T) this;
  }

  public T setBorderColor(int hue, int gray) {
    borderColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setBorderColor(int r, int g, int b) {
    borderColor = createColor(r, g, b);
    return (T) this;
  }

  public T setActiveColor(int gray) {
    activeColor = gray;
    return (T) this;
  }

  public T setActiveColor(int hue, int gray) {
    activeColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setActiveColor(int r, int g, int b) {
    activeColor = createColor(r, g, b);
    return (T) this;
  }

  public T setHoverColor(int hoverColor) {
    this.hoverColor = hoverColor;
    return (T) this;
  }

  public T setHoverColor(int hue, int gray) {
    this.hoverColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setHoverColor(int r, int g, int b) {
    this.hoverColor = createColor(r, g, b);
    return (T) this;
  }

  public T setBorderRadius(float radius) {
    this.roundness = radius;
    return (T) this;
  }

  public T setBorderRadius(float tl, float tr, float br, float bl) {
    this.tl = tl;
    this.tr = tr;
    this.br = br;
    this.bl = bl;
    return (T) this;
  }

  public T setBorderWidth(float width) {
    this.borderWidth = width;
    return (T) this;
  }

  public T setText(String text) {
    this.text = text;
    return (T) this;
  }

  public T setText(String text, String placeholder) {
    this.text = text;
    this.placeholder = placeholder;
    return (T) this;
  }

  public T setTooltip(String tooltip) {
    this.tooltip = tooltip;
    return (T) this;
  }

  public T setTextColor(int gray) {
    textColor = gray;
    return (T) this;
  }

  public T setTextColor(int hue, int gray) {
    textColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setTextColor(int r, int g, int b) {
    textColor = createColor(r, g, b);
    return (T) this;
  }

  public T seBorderColor(int r, int g, int b) {
    borderColor = createColor(r, g, b);
    return (T) this;
  }

  public T setCursorColor(int gray) {
    cursorColor = gray;
    return (T) this;
  }

  public T setCursorColor(int hue, int gray) {
    cursorColor = this.applet.color(hue, gray);
    return (T) this;
  }

  public T setCursorColor(int r, int g, int b) {
    cursorColor = createColor(r, g, b);
    return (T) this;
  }

  private int createColor(int r, int g, int b) {
    return applet.color(r, g, b);
  }

  public T setFocus(boolean active) {
    isClicked = active;
    return (T) this;
  }

  public T setValue(String value) {
    this.value = value;
    return (T) this;
  }

  public String getValue() {
    return this.value;
  }

  public String getInput() {
    return this.input;
  }

  public float getPosX() {
    return this.posX;
  }

  public float getPosY() {
    return this.posY;
  }

  public float getWidth() {
    return this.w;
  }

  public float getHeight() {
    return this.h;
  }

  public float[] getPos() {
    return new float[] {getPosX(), getPosY()};
  }

  public T setFont(PFont font) {
    if (font == null) {
      throw new IllegalArgumentException("Font cannot be null");
    }
    this.font = font;
    return (T) this;
  }

  public T setVisibility(boolean state) {
    this.visibility = state;
    applet.registerMethod("draw", this);
    return (T) this;
  }

  void draw() {}

  boolean isClicked() {
    return false;
  }

  public boolean isVisible() {
    return this.visibility;
  }
}
