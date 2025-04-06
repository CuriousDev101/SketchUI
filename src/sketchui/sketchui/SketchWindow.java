package sketchui;

import java.util.List;
import processing.core.PApplet;

public class SketchWindow {
  protected PApplet window;
  float mouseX, mouseY;

  public SketchWindow(PApplet parent) {
    window = parent;
  }

  void render(Boolean autoDraw, UIElement<?> element) {
    if (autoDraw && !element.isRegistered) {
      element.isRegistered = true;
      element.visibility = autoDraw;
      window.registerMethod("draw", element);
      if (element instanceof Clickable) {
        window.registerMethod("mouseEvent", element);
      }
      if (element instanceof Editable) {
        window.registerMethod("keyEvent", element);
      }

    } else if (!autoDraw && element.isRegistered) {
      window.unregisterMethod("draw", element);
      element.isRegistered = false;
    }
  }

  void update(Boolean state, Boolean autoDraw, List<UIElement<?>> elements) {
    for (UIElement<?> e : elements) {
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

  public void isMousePressed(UIElement<?> element) {}

  void mouseReleasedEvent() {}

  void setMouseWheelRotation(int theScoller) {}
}
