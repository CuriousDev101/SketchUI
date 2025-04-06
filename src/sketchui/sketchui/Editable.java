package sketchui;

import processing.event.KeyEvent;

public interface Editable {

  // void setActive(boolean active);
  //
  // void setFocused(boolean focused);
  //
  // void setHovered(boolean hovered);

  void onSubmit(Runnable action);

  void noAction();

  void keyEvent(KeyEvent theEvent);

  boolean isSubmitted();
}
