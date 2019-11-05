package u001Usefull;

public class TrueFalseChanger {

    static boolean gender = true;



    public static void main(String[] args) {
        System.out.println(getboolean());
    }

    static Boolean getboolean(){
        return !getGender();
    }

    static Boolean getGender(){
        return gender;
    }
}
