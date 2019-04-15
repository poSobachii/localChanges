package x026.BuilderPattern;

/**
 * Demo class. Everything comes together here.
 */

public class ClientDemoCode {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        director.constructCityCar(builder);
        director.constructSUV(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        director.constructCityCar(manualBuilder);
        Manual carManual2 = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual2.print());

        director.constructSUV(manualBuilder);
        Manual carManual3 = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual3.print());



    }

}