package JsonReader;

import java.util.ArrayList;
import java.util.List;

public class KeyClass {

    private ArrayList<KeyValues> keys;

    public KeyClass(){}

    public KeyClass(ArrayList keys){
        this.keys = keys;
    }

    public List<KeyValues> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<KeyValues> keys) {
        this.keys = keys;
    }
}
