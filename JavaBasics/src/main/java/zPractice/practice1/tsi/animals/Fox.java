package zPractice.practice1.tsi.animals;

public class Fox implements Animal, Wild {
    @Override
    public void sound() {
        System.out.println("Wa-pow");
    }

    @Override
    public void secretSkill() {
        System.out.println("My secret skill is flying, of course!");
    }
}
