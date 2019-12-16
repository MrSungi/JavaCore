public class Triangle {

    int height;
    int start, end;

    public void makeTriangle(){

        start = end = height;
        int endLoop = (height*2) - 1;

        for(int j=1; j<=height; j++) {
            for (int i = 1; i <= endLoop; i++) {

                if ((i >= start) && (i <= end)) {
                    System.out.print("* ");
                    i++;
                }
                else{
                    System.out.print(" ");
                }
            }//====i loop
            start--;
            end++;
            System.out.println();
        }//====j loop
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle();
        obj.height = 16;
        obj.makeTriangle();
    }



}
