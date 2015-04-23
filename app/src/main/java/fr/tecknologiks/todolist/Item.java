package fr.tecknologiks.todolist;

/**
 * Created by robinpauquet on 23/04/15.
 */
public class Item {

    public Item()
    {

    }
    public Item(boolean _selected, String _text)
    {
        selected = _selected;
        text = _text;
    }
    private boolean selected = false;
    private String text = "";

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
