class Main
{
    public static void main(String args[])
    {
        int marks = 95;

        if(marks >= 40){
            if(marks >= 90){
                System.out.println("A+");
            } else {
                System.out.println("Pass");
            }
        } else {
            System.out.println("Fail");
        }
    }
}