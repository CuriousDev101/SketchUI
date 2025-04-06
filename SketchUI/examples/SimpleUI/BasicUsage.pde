import sketchui.*;
import sketchui.Themes.*;

Sketchui app;
Button btn;
LazyTheme theme;
TextField input;

String message = "";

void setup() {
  size(600, 600);

  Sketchui app = new Sketchui(this);
  theme = new LazyTheme();

  btn = app.createButton("󰳽 Click", width/2 + 50, 100, 100, 30);
  input = app.createTextField("password", width/2 - 200, 100, 200, 30);

  input.onSubmit(this::inputAction);

  btn.onClick(() -> {
    if (!input.getInput().equals("")) {
      println("You Entered: " + input.getInput());
    } else {
      println("Input value is Null: Please Entered String");
    }
  }
  );

  theme.applyTheme(WHITE_THEME.class);
}

void draw() {
  fill(255);
  text(message, width/2, 200);
}

void inputAction() {
  message = "You Entered: " + input.getInput();
}
