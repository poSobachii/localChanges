package JsonExample.Controller;

import java.util.List;

public class Keys {

    private List<Key> keys;


    public Keys(List keys){
        this.keys = keys;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }
}
