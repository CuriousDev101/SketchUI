package sketchui;

import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class TextField extends UIElement<TextField> implements Editable, Clickable {

  Runnable onSubmitAction = null;

  public String value, placeholder;
  private String cursor = "", visibleInput = "", invisibleInput = "";
  private boolean customRadii = false;
  private boolean isVisible = true;
  private PFont font;
  int paddingLeft = 0;
  int paddingRight = 0;
  int paddingTop = 0;
  int paddingBottom = 0;

  public boolean isSubmitted = false;

  boolean isActive = false;
  boolean isFocused = false;
  boolean isHovered = false;
  boolean isClicked = false;

  boolean suggestion = false;
  boolean isEditable = false;
  boolean isPassword = false;
  boolean isMultiline = false;

  boolean isNumeric = false;
  boolean isEmail = false;
  boolean isDate = false;
  boolean isTime = false;
  boolean isPhone = false;
  boolean isAlpha = false;
  boolean isAlphaNumeric = false;
  boolean isAlphaNumericSpace = false;
  boolean isAlphaNumericSpecial = false;
  boolean isAlphaNumericSpecialSpace = false;
  boolean isAlphaSpace = false;
  boolean isAlphaSpecial = false;
  boolean isAlphaSpecialSpace = false;

  public TextField(PApplet p) {
    this.applet = p;
    defaultSettings();
  }

  public TextField(PApplet p, String text) {
    this.applet = p;
    defaultSettings();
    this.text = text;
  }

  public TextField(String text, String placeholder) {
    defaultSettings();
    this.text = text;
    this.placeholder = placeholder;
  }

  public TextField(PApplet p, String text, float x, float y) {
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
    this.text = text;
  }

  public TextField(PApplet p, String text, float x, float y, float w, float h) {
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
    this.text = text;
    this.w = w;
    this.h = h;
  }

  public TextField(PApplet p, String text, float x, float y, float w, float h, float r) {
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
    this.text = text;
    this.w = w;
    this.h = h;
    this.roundness = r;
  }

  public TextField(PApplet p, float x, float y) {
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
  }

  public TextField(PApplet p, float x, float y, float w, float h) {
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
  }

  public TextField(PApplet p, float x, float y, float w, float h, float r) {
    super();
    this.applet = p;
    defaultSettings();
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
    this.roundness = r;
  }

  public void defaultSettings() {
    font = this.applet.createFont("Monospaced.plain", 15);
    w = 200;
    h = 40;
    tl = 0;
    tr = 0;
    br = 0;
    bl = 0;
    roundness = 0;
    paddingLeft = 5;

    bgColor = 200;
    fgColor = 0;
    activeColor = this.applet.color(0, 0, 255);
    textColor = 0;
    cursorColor = 0;
    borderColor = this.applet.color(0);

    isActive = false;
    suggestion = false;
    onSubmit(this::noAction);
  }

  @Override
  public void onSubmit(Runnable action) {
    this.onSubmitAction = action;
  }

  @Override
  public void onClick(Runnable action) {}

  @Override
  public void noAction() {}

  @Override
  public boolean isSubmitted() {
    return isSubmitted;
  }

  @Override
  public boolean isMouseOver() {
    return applet.mouseX > posX
        && applet.mouseX < posX + w
        && applet.mouseY > posY
        && applet.mouseY < posY + h;
  }

  @Override
  public boolean isClicked() {
    return isMouseOver() && applet.mousePressed;
  }

  public boolean isActive() {
    return isActive;
  }

  @Override
  public boolean isMousePressedOver() {
    return isMouseOver() && applet.mousePressed && isVisible();
  }

  @Override
  public void mouseEvent(MouseEvent theEvent) {
    if (isVisible() && isClicked() && theEvent.getAction() == MouseEvent.PRESS) {
      // runAction();
    }
  }

  @Override
  public void keyEvent(KeyEvent theEvent) {
    this.applet.push();
    this.applet.textFont(font);
    if (isActive() && theEvent.getAction() == KeyEvent.PRESS) {
      if (this.applet.key == PApplet.ENTER) {
        try {
          onSubmitAction.run();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      } else if (Character.isLetterOrDigit(this.applet.key)
          || isSymbol(this.applet.key)
          || this.applet.key == ' ') {
        input += this.applet.key;
        visibleInput += this.applet.key;
        if ((this.applet.textWidth(input)) >= (w - paddingLeft - 5)) {
          invisibleInput += visibleInput.charAt(0);
          visibleInput = visibleInput.substring(1, visibleInput.length());
        }
      }
      if (this.applet.key == PApplet.BACKSPACE && !visibleInput.isEmpty()) {
        visibleInput = visibleInput.substring(0, visibleInput.length() - 1);
        input = input.substring(0, input.length() - 1);
        if (!invisibleInput.isEmpty()) {
          visibleInput = invisibleInput.charAt(invisibleInput.length() - 1) + visibleInput;
          invisibleInput = invisibleInput.substring(0, invisibleInput.length() - 1);
        }
      }
    }
    this.applet.pop();
  }

  public boolean isSymbol(char c) {
    return !Character.isLetterOrDigit(c)
        && !Character.isWhitespace(c)
        && !Character.isISOControl(c);
  }

  // @Override
  public void runAction() {
    try {
      onSubmitAction.run();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Object: action is not setted");
    }
  }

  public void checkActive() {
    if (this.applet.mousePressed) {
      isActive =
          this.applet.mouseX > posX
              && this.applet.mouseX < posX + w
              && this.applet.mouseY > posY
              && this.applet.mouseY < posY + h;
    }
    if (this.applet.mouseX > posX
        && this.applet.mouseX < posX + w
        && this.applet.mouseY > posY
        && this.applet.mouseY < posY + h) {
      this.applet.cursor(PApplet.TEXT);

    } else {
      this.applet.cursor(PApplet.ARROW);
    }
  }

  @Override
  public void draw() {
    if (visibility) {
      this.applet.push();
      this.applet.stroke(isActive() || isClicked() ? activeColor : borderColor);
      this.applet.strokeWeight(borderWidth);
      this.applet.fill(bgColor);

      if (customRadii) {
        this.applet.rect(posX, posY, w, h, tl, tr, br, bl);
      } else {
        this.applet.rect(posX, posY, w, h, roundness);
      }
      this.applet.fill(textColor);
      this.applet.textFont(font);
      cursor = isActive ? this.applet.frameCount % 60 <= 30 ? "|" : "" : "";
      this.applet.textAlign(PApplet.BASELINE);
      this.applet.text(visibleInput + cursor, posX + paddingLeft, posY + h / 2 + 5);
      checkActive();

      this.applet.textAlign(PApplet.BASELINE);
      this.applet.stroke(0);
      this.applet.pop();
    }
  }
}
