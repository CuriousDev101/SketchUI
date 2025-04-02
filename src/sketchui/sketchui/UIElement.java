package sketchui;

import processing.core.PApplet;

public abstract class UIElement {
  PApplet applet;
  boolean isRegistered = false;

  void draw() {}
  ;
}
