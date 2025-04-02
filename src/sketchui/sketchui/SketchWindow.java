package sketchui;

import java.util.List;
import processing.core.PApplet;

public class SketchWindow {
  PApplet window;

  public SketchWindow(PApplet parent) {
    window = parent;
  }

  void render(Boolean autoDraw, UIElement element) {
    if (autoDraw && !element.isRegistered) {
      element.isRegistered = true;
      window.registerMethod("draw", element);
    } else if (!autoDraw && element.isRegistered) {
      window.unregisterMethod("draw", element);
      element.isRegistered = false;
    }
  }

  void update(Boolean state, Boolean autoDraw, List<UIElement> elements) {
    for (UIElement e : elements) {
      if (state && autoDraw && !e.isRegistered) {
        window.registerMethod("draw", e);
        e.isRegistered = true;
      } else if (!(state && autoDraw) && e.isRegistered) {
        window.unregisterMethod("draw", e);
        e.isRegistered = false;
      }
    }
  }

  public void keyEvent() {}

  public void mouseEvent() {}
}
