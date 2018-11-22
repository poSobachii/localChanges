package act6;

public class SimpleCalc {
    static int rslt;
    public static int add(int a, int b) throws SimpleCalcException {
        validateInput(a, b);
        rslt = a + b;
        validateOutput(a,b,rslt, "+");
        return rslt;
    }
    public static int subtract(int a, int b) throws SimpleCalcException {
        validateInput(a, b);
        rslt = a - b;
        validateOutput(a,b,rslt, "-");
        return rslt;
    }
    public static int multiply(int a, int b) throws SimpleCalcException {
        validateInput(a, b);
        rslt = a * b;
        validateOutput(a,b,rslt, "*");
        return rslt;
    }
    public static int divide(int a, int b) throws SimpleCalcException {
        validateInput(a, b);
        try {
            rslt = a/b;
        } catch (ArithmeticException e) {
            throw new SimpleCalcException("division by zero", e);
        }
        validateOutput(a,b,rslt, "/");
        return rslt;
    }

    // TODO Validate that inputs are in range of -10..+10 using assertions
    // Use following messages for assertion description if values are not in
    // range:
    // "input value a: A is below -10"
    // "input value a: A is above 10"
    // "input value b: B is below -10"
    // "input value b: B is above 10"
    // "input value a: A is below -10 and b: B is below -10"
    // "input value a: A is above 10 and b: B is below -10"
    // "input value a: a is below -10 and b: B is above 10"
    // "input value a: a is above 10 and b: B is above 10"
    //
    // where: A and B are actual values of a and b.
    //
    // hint: only on false
    // note that assert allows only simple boolean expression
    // (i.e. without &, |, () and similar constructs).
    // therefore for more complicated checks use following approach:
    // if (long && complicated || statement)
    // assert false: "message if statement not fulfilled";
    //
    public static int validateInput(int a, int b) throws SimpleCalcException {

        if (a <= 10 && b >= -10 && b <=10){
            try {
                assert (a <= 10 & a>= -10) : "input value a: " + a + " is below -10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        } else if (a >= -10 && b >= -10 && b <=10){
            try {
                assert (a <= 10 & a>= -10) : "input value a: " + a + " is above 10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        }
        if (a >= -10 && a <=10 && b <= 10){
            try {
                assert (b <= 10 & b>= -10) : "input value b: " + b + " is below -10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        } else if (a >= -10 && a <=10 && b >= 10){
            try {
                assert (b <= 10 & b>= -10) : "input value b: " + b + " is above 10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        }
        if (a <= 10 && b <= 10){
            try {
                assert (a >= -10 && a <= 10 && b >= -10 && b<= 10) : "input value a: " + a + " is below -10 and b: " + b + " is below -10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        } else if (a >= -10 && b >= -10){
            try {
                assert (a >= -10 && a <= 10 && b >= -10 && b<= 10) : "input value a: " + a + " is above 10 and b: " + b + " is above 10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        }
        if (a >= -10 && b <= 10){
            try {
                assert (a >= -10 && a <= 10 && b >= -10 && b<= 10) : "input value a: " + a + " is above 10 and b: " + b + " is below -10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        } else if (a <= 10 && b >= -10){
            try {
                assert (a >= -10 && a <= 10 && b >= -10 && b<= 10) : "input value a: " + a + " is below -10 and b: " + b + " is above 10";
            } catch (Exception e) {
                throw new SimpleCalcException("errorus", e);
            }
        }
        return 0;
    }


    // TODO use this method to check that result of operation is also in
    // range of -10..+10.
    // If result is not in range:
    //     throw SimpleCalcException with message:
    //     "output value a oper b = result is above 10"
    //     "output value a oper b = result is below -10"
    //     where oper is +, -, *, /
    // Else:
    //     return result
    // Hint:
    // If division by zero is performed, catch original exception and create
    // new SimpleCalcException with message "division by zero" and add
    // original division exception as a cause for it.

    private static int validateOutput(int a, int b, int rslt, String operation) throws SimpleCalcException{
        if (rslt >= -10){
            try {
                assert (rslt >= -10 && rslt <= 10) : "output value " + a + " "+ operation + " " + b + " = " + rslt + " is above 10";
            } catch (Exception | AssertionError e) {
                throw new SimpleCalcException("output value " + a + " "+ operation + " " + b + " = " + rslt + " is above 10", e);
            }
        } else if (rslt <= 10){
            try {
                assert (rslt >= -10 && rslt <= 10) : "output value " + a + " " + operation + " "+ b + " = " + rslt + " is below -10";
            } catch (Exception | AssertionError e) {
                throw new SimpleCalcException("output value " + a + " " + operation + " "+ b + " = " + rslt + " is below -10", e);
            }
        }
        return 0;
    }
}
