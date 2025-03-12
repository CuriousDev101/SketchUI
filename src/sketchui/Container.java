package sketchui;

import java.util.ArrayList;

public class Container implements UIComponent {

    ArrayList<UIComponent> component = new ArrayList<>();
    boolean isVisible = false;

    public Container(UIComponent comp) {
        component.add(comp);
    }

    public Container() {}

    public void add(UIComponent comp) {
        component.add(comp);
    }

    @Override
    public void display() {
        if (isVisible) {
            for (UIComponent comp : component) {
                comp.display();
                comp.setVisible(true);
            }
        } else {
            for (UIComponent comp : component) {
                comp.setVisible(false);
            }
        }
    }

    public void setVisible(boolean visibility) {
        this.isVisible = visibility;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void clear() {
        component.clear();
    }
}
