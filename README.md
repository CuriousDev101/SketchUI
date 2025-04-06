# SketchUI

SketchUI is a comprehensive library designed to enhance the user interface (UI) capabilities in Processing PDE (Processing Development Environment). This library aims to provide a collection of customizable UI elements to help developers create intuitive and interactive graphical user interfaces for their Processing sketches.

## Current Version
**Version:** 0.2.0

## UI Elements
The library includes a variety of UI elements such as:
- Currnet Version:
  - Buttons
  - Text Inputs
- Planned Features (Not Yet Implemented):
  - Sliders
  - Checkboxes
  - Dropdown Menus
  - Radio Buttons
  - Progress Bars

Each element is designed to be highly customizable, allowing developers to tailor the appearance and behavior to fit their specific needs.

## Installation Guide

### Prerequisites
- Processing IDE (version 3.5.4 or later)

## Installation

1. **Download the Library**  
   Download the latest version of the SketchUI [SketchUI GitHub repository](https://github.com/CuriousDev101/SketchUI) library from the repository (or clone it).

2. **Install the Library in Processing**  
   Simply copy the entire `SketchUI` folder into the Processing libraries folder:
   - On **Windows**: `Documents/Processing/libraries/`
   - On **macOS**: `Documents/Processing/libraries/`
   - On **Linux**: `~/sketchbook/libraries/`

## Usage Example
Here's a basic example of how to use SketchUI in your Processing sketch:

```java
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
  });

  theme.applyTheme(WHITE_THEME.class);
}

void draw() {
  background(200);
  fill(0);
  textSize(23);
  textAlign(CENTER, CENTER);
  text(message, width/2, height/2);
}

void inputAction() {
  message = "You Entered: " + input.getInput();
}
```

This example demonstrates creating a simple button and text field, and handling input actions.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for new features, please open an issue or submit a pull request on the [GitHub repository](https://github.com/CuriousDev101/SketchUI).

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
