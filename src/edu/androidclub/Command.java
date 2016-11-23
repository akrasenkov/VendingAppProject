package edu.androidclub;

/**
 * Created by Владислав on 23.11.2016.
 */
public class Command {
    public static final String TYPE_GET = "get";

    private final String type;
    private final String data;

    public Command(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString(){
        return "Command: { type = " + type + " , data = " + data + " }";
    }



}
