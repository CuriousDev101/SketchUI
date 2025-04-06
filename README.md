# SketchUI

SketchUI is a comprehensive library designed to enhance the user interface (UI) capabilities in Processing PDE (Processing Development Environment). This library aims to provide a collection of customizable UI elements to help developers create intuitive and interactive graphical user interfaces for their Processing sketches.

## Current Version
**Version:** 0.2.0

## UI Elements
The library includes a variety of UI elements such as:
- Buttons
- Sliders
- Checkboxes
- Text Inputs
- Dropdown Menus
- Radio Buttons
- Progress Bars

Each element is designed to be highly customizable, allowing developers to tailor the appearance and behavior to fit their specific needs.

## Installation Guide

### Prerequisites
- Processing IDE (version 3.5.4 or later)

### Steps to Install

#### Windows
1. **Download the Library:**
   - Clone the repository or download the ZIP file from the [GitHub repository](https://github.com/CuriousDev101/SketchUI).

2. **Extract Files:**
   - If you downloaded the ZIP file, extract it to a desired location on your computer.

3. **Add to Processing Libraries:**
   - Copy the extracted `SketchUI` folder to the `libraries` folder of your Processing sketchbook. You can find or create the `libraries` folder in your Processing sketchbook location (usually located in `Documents/Processing`).

4. **Import the Library:**
   - Open Processing IDE and start a new sketch. Import the library at the beginning of your sketch:
     ```java
     import sketchui.*;
     import sketchui.Themes.*;
     ```

#### Linux
1. **Download the Library:**
   - Clone the repository or download the ZIP file from the [GitHub repository](https://github.com/CuriousDev101/SketchUI).

2. **Extract Files:**
   - If you downloaded the ZIP file, extract it to a desired location on your computer.

3. **Add to Processing Libraries:**
   - Copy the extracted `SketchUI` folder to the `libraries` folder of your Processing sketchbook. You can find or create the `libraries` folder in your Processing sketchbook location (usually located in `~/Documents/Processing`).

4. **Import the Library:**
   - Open Processing IDE and start a new sketch. Import the library at the beginning of your sketch:
     ```java
     import sketchui.*;
     import sketchui.Themes.*;
     ```

#### macOS
1. **Download the Library:**
   - Clone the repository or download the ZIP file from the [GitHub repository](https://github.com/CuriousDev101/SketchUI).

2. **Extract Files:**
   - If you downloaded the ZIP file, extract it to a desired location on your computer.

3. **Add to Processing Libraries:**
   - Copy the extracted `SketchUI` folder to the `libraries` folder of your Processing sketchbook. You can find or create the `libraries` folder in your Processing sketchbook location (usually located in `Documents/Processing`).

4. **Import the Library:**
   - Open Processing IDE and start a new sketch. Import the library at the beginning of your sketch:
     ```java
     import sketchui.*;
     import sketchui.Themes.*;
     ```

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
  fill(255);
  text(message, width/2, 200);
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
