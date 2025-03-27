// File: TextField.java
package sketchui;

import processing.core.PApplet;
import processing.core.PFont;

public class TextField implements UIComponent {
    private PApplet parent;

    private int fillColor,
            strokeColor,
            bgColor,
            fgColor,
            hoverColor,
            activeColor,
            textColor,
            cursorColor;
    private int paddingLeft;
    private int borderColor;
    private float posX, posY, w, h, tl, tr, br, bl, roundness;
    private String label,
            value,
            placeholder,
            cursor = "",
            input = "",
            visibleInput = "",
            invisibleInput = "";
    private boolean isClicked, isPressed, isHovered, isActive, suggestion;
    private boolean customRadii = false;
    private boolean isVisible = true;
    private PFont font;

    private Runnable action;

    public TextField(PApplet p) {
        this.parent = p;
        defaultSettings();
    }

    public TextField(PApplet p, String label) {
        this.parent = p;
        defaultSettings();
        this.label = label;
    }

    public TextField(String label, String placeholder) {
        defaultSettings();
        this.label = label;
        this.placeholder = placeholder;
    }

    public TextField setLabel(String label) {
        this.label = label;
        return this;
    }

    public TextField setLabelColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextField setTextColor (int textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextField(PApplet p, String label, float x, float y) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
        this.label = label;
    }

    public TextField(PApplet p, String label, float x, float y, float w, float h) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
        this.label = label;
        this.w = w;
        this.h = h;
    }

    public TextField(PApplet p, String label, float x, float y, float w, float h, float r) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
        this.label = label;
        this.w = w;
        this.h = h;
        this.roundness = r;
    }

    public TextField(PApplet p, float x, float y) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
    }

    public TextField(PApplet p, float x, float y, float w, float h) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
        this.w = w;
        this.h = h;
    }

    public TextField(PApplet p, float x, float y, float w, float h, float r) {
        this.parent = p;
        defaultSettings();
        this.posX = x;
        this.posY = y;
        this.w = w;
        this.h = h;
        this.roundness = r;
    }

    public TextField setPosition(float x, float y) {
        this.posX = x;
        this.posY = y;
        return this;
    }

    public TextField setPosX(float x) {
        this.posX = x;
        return this;
    }

    public TextField setPosY(float y) {
        this.posY = y;
        return this;
    }

    public TextField setSize(float w, float h) {
        this.w = w;
        this.h = h;
        return this;
    }

    public TextField setSize(float w, float h, float r) {
        this.w = w;
        this.h = h;
        this.roundness = r;
        return this;
    }

    public TextField setWidth(float w) {
        this.w = w;
        return this;
    }

    public TextField setHeight(float h) {
        this.h = h;
        return this;
    }

    public TextField setSize(float w, float h, float tl, float tr, float br, float bl) {
        this.w = w;
        this.h = h;
        this.tl = tl;
        this.tr = tr;
        this.br = br;
        this.bl = bl;
        this.customRadii = true;
        return this;
    }

    public TextField setFill(int r, int g, int b) {
        fillColor = parent.color(r, g, b);
        return this;
    }

    public TextField setFill(int gray) {
        fillColor = gray;
        return this;
    }

    public TextField setFont(PFont font) {
        this.font = font;
        return this;
    }

    public TextField setBackground(int gray) {
        bgColor = gray;
        return this;
    }

    public TextField setBackground(int hue, int gray) {
        bgColor = parent.color(hue, gray);
        return this;
    }

    public TextField setBackground(int r, int g, int b) {
        bgColor = parent.color(r, g, b);
        return this;
    }

    public TextField setForeground(int gray) {
        fgColor = gray;
        return this;
    }

    public TextField setForeground(int r, int g, int b) {
        fgColor = parent.color(r, g, b);
        return this;
    }

    public TextField setBorderRadius(int radius) {
        this.roundness = radius;
        return this;
    }

    public TextField setBorderRadius(float tl, float tr, float br, float bl) {
        this.tl = tl;
        this.tr = tr;
        this.br = br;
        this.bl = bl;
        this.customRadii = true;
        return this;
    }

    public TextField setBorderColor(int grey) {
        borderColor = parent.color(grey);
        return this;
    }

    public TextField setBorderColor(int r, int g, int b) {
        borderColor = parent.color(r, g, b);
        return this;
    }

    public TextField setColorActive(int gray) {
        activeColor = gray;
        return this;
    }

    public TextField setColorActive(int r, int g, int b) {
        activeColor = parent.color(r, g, b);
        return this;
    }

    public TextField setFocus(boolean active) {
        isClicked = active;
        return this;
    }

    public TextField setValue(String value) {
        this.value = value;
        return this;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getValue() {
        return input;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getWidth() {
        return w;
    }

    public float getHeight() {
        return h;
    }

    public float[] getPos() {
        return new float[] {getPosX(), getPosY()};
    }

    public void defaultSettings() {
        font = parent.createFont("Monospaced.plain", 15);
        w = 200;
        h = 40;
        tl = 0;
        tr = 0;
        br = 0;
        bl = 0;
        roundness = 0;
        paddingLeft = 5;

        fillColor = 200;
        strokeColor = 0;
        bgColor = 200;
        fgColor = 0;
        activeColor = parent.color(0, 0, 255);
        textColor = 0;
        cursorColor = 0;
        borderColor = parent.color(0);

        isActive = false;
        suggestion = false;
        textFieldAction(this::nothing);
    }

    public void textFieldAction(Runnable action) {
        this.action = action;
    }

    @Override
    public void display() {
        parent.stroke(isActive() || isClicked() ? activeColor : borderColor);
        //        parent.stroke(isActive ? activeColor : fgColor);
        // stroke(activeColor);
        parent.fill(bgColor);

        // rect(x, y, w, h, 15, 0, 0, 15);
        if (customRadii) {
            parent.rect(posX, posY, w, h, tl, tr, br, bl);
        } else {
            parent.rect(posX, posY, w, h, roundness);
        }
        parent.fill(textColor);
        parent.textFont(font);
        cursor = isActive ? parent.frameCount % 60 <= 30 ? "|" : "" : "";
        parent.textAlign(PApplet.BASELINE);
        parent.text(visibleInput + cursor, posX + paddingLeft, posY + h / 2 + 5);
        checkActive();

        parent.textAlign(PApplet.BASELINE);
        parent.stroke(0);
    }

    public void checkActive() {
        if (parent.mousePressed) {
            isActive =
                    parent.mouseX > posX
                            && parent.mouseX < posX + w
                            && parent.mouseY > posY
                            && parent.mouseY < posY + h;
        }
        if (parent.mouseX > posX
                && parent.mouseX < posX + w
                && parent.mouseY > posY
                && parent.mouseY < posY + h) {
            parent.cursor(PApplet.TEXT);

        } else {
            parent.cursor(PApplet.ARROW);
        }
    }

    public boolean isActive() {
        return isActive && isVisible();
    }

    public void keyEvent() {
        if (isActive()) {
        if (parent.key == PApplet.ENTER) {
            try {
                action.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //            PApplet.println(input);,
        } else if (Character.isLetterOrDigit(parent.key) || isSymbol(parent.key) || parent.key == ' ') {
            input += parent.key;
            visibleInput += parent.key;

            if ((parent.textWidth(input)) >= (w - paddingLeft - 5)) {
                invisibleInput += visibleInput.charAt(0);
                visibleInput = visibleInput.substring(1, visibleInput.length());
//                visibleInput = visibleInput.trim();
            }
        }
        if (parent.key == PApplet.BACKSPACE && !visibleInput.isEmpty()) {
            //            PApplet.println(input.length());
            visibleInput = visibleInput.substring(0, visibleInput.length() - 1);
            input = input.substring(0, input.length() - 1);
            if (!invisibleInput.isEmpty()) {
                visibleInput = invisibleInput.charAt(invisibleInput.length() - 1) + visibleInput;
                invisibleInput = invisibleInput.substring(0, invisibleInput.length() - 1);
            }
        }
        }
//        visibleInput = visibleInput.trim();
//        invisibleInput = invisibleInput.trim();
//        input = input.trim();
    }

    public boolean isMouseOver() {
        return parent.mouseX > posX
                && parent.mouseX < posX + w
                && parent.mouseY > posY
                && parent.mouseY < posY + h
                && isVisible();
    }

    public boolean isClicked() {
        return isMouseOver() && parent.mousePressed && isVisible();
    }

    @Override
    public void setVisible(boolean visibility) {
        this.isVisible = visibility;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c)
                && !Character.isWhitespace(c)
                && !Character.isISOControl(c);
    }

    public void runAction() {
        if (isVisible() && parent.key == PApplet.ENTER) {
            action.run();
        }
    }

    public void nothing() {}

    public void clear() {
        label = "";
    }
}
