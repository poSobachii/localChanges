package RestApplication;

public class BookNFexception extends RuntimeException {

    BookNFexception(Long id) {
        super("Could not find book with ID:  " + id);
    }

}
