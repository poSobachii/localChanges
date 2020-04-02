package a23_OOP.repository;


import a23_OOP.animaLinterface.Animal;
import a23_OOP.animalTypes.Elephant;
import a23_OOP.animalTypes.Tiger;
import a23_OOP.animalTypes.Wolf;
import a23_OOP.animalTypes.Zebra;
import a23_OOP.itarator.Aggregate;
import a23_OOP.itarator.Iterator;

public class AnimalPool implements Aggregate {

    private Animal animals[] = {new Zebra(), new Elephant(), new Tiger(), new Wolf()};

    @Override
    public Iterator getIterator() {
        return new AnimalIterator();
    }


    private class AnimalIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < animals.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return animals[index++];
        }
    }
}