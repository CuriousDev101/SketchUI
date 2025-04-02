package sketchui;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;

public class Sketchui {
  private SketchWindow window;
  private PApplet applet;
  private List<UIElement> elements;

  private Boolean autoDraw;
  private Boolean isInit = false;

  public Sketchui(PApplet parent) {
    this.applet = parent;
    window = new SketchWindow(parent);
    elements = new ArrayList<>();
    autoDraw = true;
  }

  void init() {
    isInit = true;
  }

  public Button createButton(String label, float x, float y, float w, float h) {
    Button button = new Button(label, x, y, w, h);
    button.applet = applet;
    elements.add(button);
    window.render(autoDraw, button);
    init();
    return button;
  }

  public void addElement(UIElement element) {
    element.applet = applet;
    window.render(autoDraw, element);
  }

  public void setAutoDraw(Boolean state) {
    autoDraw = state;
    window.update(isInit, autoDraw, elements);
  }
}
