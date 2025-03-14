# SketchUI Quick Start Guide

## Overview

This library helps you create buttons and text fields easily in your Processing sketch. It provides methods to customize button labels, positions, sizes, and text fields as well.

## Methods

### Button Creation

- **`createButton(PApplet parent)`**  
  Creates a button with default settings.

- **`createButton(PApplet parent, String label)`**  
  Creates a button with a custom label.

- **`createButton(PApplet parent, String label, float x, float y)`**  
  Creates a button with a custom label and position.

- **`createButton(PApplet parent, String label, float x, float y, float w, float h)`**  
  Creates a button with a custom label, position, and size.

- **`whichButton(Button... btn)`**  
  Checks which button was clicked.

### TextField Creation

- **`createTextField(PApplet parent)`**  
  Creates a text field with default settings.

- **`createTextField(PApplet parent, String label)`**  
  Creates a text field with a label.

- **`createTextField(PApplet parent, String label, float x, float y)`**  
  Creates a text field with a label and position.

## Example Code

```java
import sketchui.*;
import static sketchui.main.*;

Button myButton;
TextField myTextField;

void setup() {
  size(400, 400);

  //Create a button
  myButton = createButton(this, "Click Me", 275, 200);

  //Create a text field
  myTextField = createTextField(this, "Enter Text", 50, 200, 200, 30);
  myTextField.textFieldAction(this::printTextFieldValue);
}

void draw() {
  background(255);
  myButton.display();
  myTextField.display();
}

void mousePressed() {
  if (myButton.isClicked()) {
    println("Button was clicked!");
  }
}

void keyTyped() {
  myTextField.keyEvent();
}

void printTextFieldValue() {
  println(myTextField.getValue());
}
```

## Setup

1. Import the static methods at the top of your sketch:

```java
import sketchui.main.*;
import static sketchui.main.*;
```

2. Create buttons and text fields as shown in the example.

