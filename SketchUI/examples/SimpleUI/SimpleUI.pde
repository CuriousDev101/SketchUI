import sketchui.*;

SketchUI ui;

void setup() {
    size(400, 400);
    ui = new SketchUI(this);
}

void draw() {
    background(255);
    ui.display();
}

void mousePressed() {
    if (ui.isButtonPressed(mouseX, mouseY)) {
        println("Button Pressed!");
    }
}

void mouseDragged() {
    ui.updateSlider(mouseX);
}

void keyPressed() {
    ui.updateTextField(key + "");
}
