package ThreadSafety;

public class Stateless {

    private final String constant= "constant";

    public void printConstant(){
        System.out.println(constant);
    }

    public String getConstant() {
        return constant;
    }

    //they dont have postconditions
}
