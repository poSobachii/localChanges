package x019.PreBoocampTasks;

public class Hellow {

    public static void main(String... args) {
//        System.out.println("Hello World");


        Car bmw = new Car("Black", "Turbo", 160, "Sedan");
        System.out.println(bmw);
        System.out.println("Car ----- " + bmw.getInformation());
        bmw.setColor("Pink");
        System.out.println(bmw);
        System.out.println("Car ----- " + bmw.getInformation());
        bmw.driveFW();
        bmw.stop();

        Car[] garage = {bmw};
        System.out.println("Cars in garage: " + garage.length);

        Car newGarage[] = new Car[10];
        System.out.println("Cars in garage: " + newGarage.length);
        for (int i = 0; i < 10; i++) {
            Car newBmw = new Car("White", "v6", 200, "sedan");
            newGarage[i] = newBmw;

        }

        System.out.println("Cars in garage: " + newGarage.length);

        Newcar audi = new Newcar("Red", "v10", 500, "sport truck");
        audi.getInformation();
        audi.driveBW();
        audi.setColor("blue");
        audi.getInformation();
        System.out.println(audi);
        audi.driveFW();
        audi.driveFW(120);

        System.out.println("Audi has " + audi.getCountOfTimes() + " tires");

        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.sit();

    }
}
