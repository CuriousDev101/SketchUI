package sketchui;

// import processing.core.PApplet;
import processing.event.MouseEvent;

public interface Clickable {
  // float getX();
  //
  // float getY();
  //
  // float getWidth();
  //
  // float getHeight();
  //
  // boolean isVisible();

  void onClick(Runnable action);

  boolean isMouseOver();

  boolean isClicked();

  boolean isMousePressedOver();

  void mouseEvent(MouseEvent theEvent);
}
