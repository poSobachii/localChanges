package a22_class_objects;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.createObject();
    }

    void createObject() {
        Bmw newBmw = new Bmw();                                 // object create
        System.out.println(newBmw.name);

        Bmw newBmw2 = new Bmw("e50", "blue", 25000);                    // using constructor
        System.out.println(newBmw2.name);
        System.out.println(newBmw2.getType());
        newBmw2.setType("universal");                                       // setter getter
        System.out.println(newBmw2.getType());
        System.out.println(newBmw2.engineOn());

        Audi newAudi1 = new Audi();                                             // object with interface
        System.out.println(newAudi1.engineOn());
        System.out.println(newAudi1.name);

        Volvo volvo = new Volvo();                                                  // object with abstract
        System.out.println(volvo.doesitwork());
        System.out.println(volvo.turnoff());

        Ford.printsmthelse();
        Ford ford1 = new Ford();
        ford1.printsmth();

        BmwSUV x5 = new BmwSUV();
        System.out.println(x5.name + " " + x5.getType());
        BmwSUV x6 = new BmwSUV("new model x6", "green", 40000, 5);
        System.out.println(x6.age);
        System.out.println(x6.color);

        System.out.println(x6.toString());

        Car newBasiccar = new Audi();
        System.out.println(((Audi) newBasiccar).name);

        Garage bmwGarageList = new Garage();
        Bmw bmw1 = new Bmw("e60", "red", 37000);
        Bmw bmw2 = new Bmw("e70", "green", 35000);
        Bmw bmw3 = new Bmw("e80", "yellow", 20000);
        Audi audi1 = new Audi();
        bmwGarageList.garageOfbmws.add(bmw1);
        bmwGarageList.garageOfbmws.add(bmw2);
        bmwGarageList.garageOfbmws.add(bmw3);
        bmwGarageList.garageOfbmws.add(bmw1);

        Car basicCar2 = new Audi();
        Car basicCar3 = new Audi();
        Car basicCar4 = new Bmw();
        Car basicCar5 = new BmwSUV();
        bmwGarageList.listOfCars.add(basicCar2);
        bmwGarageList.listOfCars.add(basicCar4);
        bmwGarageList.listOfCars.add(basicCar5);
    }
}
