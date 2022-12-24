public class ExceptionExample {

    public static int compute1(int a, int b) {
        // compute1() does NOT use exception handling
        // compare it with compute2() (below) which is the same, except that
        // compute2() uses exception handling
        int result = -1;
        result = a / b;
        return result;
    }  // compute1
    public static int compute2(int a, int b) {
        // compute2() uses exception handling
        int result = -1;
        try {
            result = a / b;
        }
        catch (NullPointerException e) {  // example only, not likely
            System.out.println("Caught a null pointer issue");
        }
        catch (Exception e) {
            System.out.println("compute2() caught an Exception: " + e.toString());
        }
        finally {
            System.out.println("optional finally in compute2() always executes");
        }
        return result;
    }  // compute2
    public static void main(String[] args) {
        int x = 123;
        int y = 0;
        System.out.println("\nUsing try block in main()...");
        try {
            System.out.println("Calling compute2(x, y) from main(): ");
            System.out.println("  compute2(" + x + ", " + y + "): " + compute2(x,
                    y));
            System.out.println("Calling compute1(x, y) from main(): ");
            System.out.println("  compute1(" + x + ", " + y + "): " + compute1(x,
                    y));
        }
        catch(Exception e) {
            System.out.println("Caught in main()");
        }
        finally {
            System.out.println("finally in main() always executes");
        }

        System.out.println("\nWithout using try block in main()...");
        System.out.println("Calling compute2(x, y) from main(): ");
        System.out.println("  compute2(" + x + ", " + y + "): " + compute2(x, y));
        System.out.println("Calling compute1(x, y) from main(): ");
        System.out.println("  compute1(" + x + ", " + y + "): " + compute1(x, y));
        System.out.println();
    }  // main method
}