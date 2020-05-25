package u001Usefull;

import java.util.ArrayList;
import java.util.List;

public class SomethingExtendsKnown {

    public static void main(String[] args) {
        Flat flat = new Flat("1 floor", "riga", 40);
        PrivateHouse privateHouse = new PrivateHouse("2 floors", "jurmala", 10, "garage");
        List< ? extends Housing> flatList = new ArrayList<>();
//        flatList.add(flat);
//        flatList.add(privateHouse)
    }
}


// =====================================================================================================================================

class Housing{
    String name;
    String location;

    public Housing(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

// =====================================================================================================================================

class Flat extends Housing{
    int square;

    public Flat(String name, String location, int square) {
        super(name, location);
        this.square = square;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}

// =====================================================================================================================================

class PrivateHouse extends Housing{
    int treeCount;
    String extraSpace;

    public PrivateHouse(String name, String location, int treeCount, String extraSpace) {
        super(name, location);
        this.treeCount = treeCount;
        this.extraSpace = extraSpace;
    }

    public int getTreeCount() {
        return treeCount;
    }

    public void setTreeCount(int treeCount) {
        this.treeCount = treeCount;
    }

    public String getExtraSpace() {
        return extraSpace;
    }

    public void setExtraSpace(String extraSpace) {
        this.extraSpace = extraSpace;
    }
}