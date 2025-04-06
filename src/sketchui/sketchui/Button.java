package sketchui;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class Button extends UIElement<Button> implements Clickable {
  Runnable onClickAction;

  public Button(String text) {
    this.text = text;
  }

  public Button(String text, float x, float y) {
    this.text = text;
    this.posX = x;
    this.posY = y;
  }

  public Button(PApplet parent, String text, float x, float y, float w, float h) {
    super();
    applet = parent;
    defaultSettings();
    this.text = text;
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
  }

  public Button(PApplet parent, String text, int bgColor, float x, float y, float w, float h) {
    applet = parent;
    defaultSettings();
    this.text = text;
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
    applet = parent;
  }

  public Button setColor(int bgColor) {
    this.bgColor = bgColor;
    hoverColor = applet.color(bgColor, 210);
    fgColor = applet.color(bgColor, 180);
    activeColor = applet.color(bgColor);
    return this;
  }

  @Override
  public void draw() {
    if (visibility) {
      applet.push();
      applet.strokeWeight(borderWidth);
      applet.stroke(isMouseOver() || isClicked() ? activeColor : borderColor);

      applet.fill(isMouseOver() ? (isClicked() ? fgColor : hoverColor) : bgColor);

      applet.rectMode(PApplet.CORNER);
      if (isRound) {
        applet.rect(posX, posY, w, h, tl, tr, br, bl);
      } else {
        applet.rect(posX, posY, w, h, roundness);
      }
      applet.fill(textColor);
      applet.textFont(applet.createFont("Monospaced.plain", 15));
      applet.textAlign(PApplet.CENTER, PApplet.CENTER);
      applet.text(text, posX + w / 2, posY + h / 2);

      applet.textAlign(PApplet.BASELINE);
      applet.stroke(0);
      applet.rectMode(PApplet.CORNER);

      applet.pop();
    }
  }

  @Override
  public void onClick(Runnable action) {
    this.onClickAction = action;
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

  @Override
  public boolean isMousePressedOver() {
    return isMouseOver() && applet.mousePressed && isVisible();
  }

  @Override
  public void mouseEvent(MouseEvent theEvent) {
    if (isVisible() && isClicked() && theEvent.getAction() == MouseEvent.PRESS) {
      runAction();
    }
  }

  // @Override
  public void runAction() {
    try {
      onClickAction.run();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Object: action is not setted");
    }
  }

  private void noAction() {}

  private void defaultSettings() {
    font = applet.createFont("Monospaced.plain", 15);
    posX = 10;
    posY = 30;
    w = 100;
    h = 30;
    roundness = 0;

    value = text;

    bgColor = applet.color(249, 249, 249);
    hoverColor = applet.color(206, 206, 206);
    fgColor = applet.color(206, 206, 206, 200);
    activeColor = applet.color(103, 103, 103);
    textColor = applet.color(0);
    borderColor = applet.color(0);

    isClicked = false;
    onClick(this::noAction);
  }
}
