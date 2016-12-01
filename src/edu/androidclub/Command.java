package edu.androidclub;

public class Command {
    public static final String TYPE_GET = "get";
    public static final String TYPE_STOP = "stop";

    private final String type;
    private final Object data;

    public Command(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Command: { type = " + type
                + ", data = " + data
                + " }";
    }
}
