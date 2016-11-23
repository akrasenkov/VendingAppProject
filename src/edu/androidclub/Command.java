package edu.androidclub;

public class Command {

    public enum Type {
        REQUEST_ITEM
    }

    private final Type type;
    private final String data;

    public Command(Type type, String data) {
        this.type = type;
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Command{" +
                "type=" + type +
                ", data='" + data + '\'' +
                '}';
    }
}
