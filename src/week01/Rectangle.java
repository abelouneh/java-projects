package week01;
public class Rectangle {
        public static void main(String[] args) {
            int width = 10;
            int height = 5;

            //top row
            for (int i = 0; i < width; i++) {
                System.out.print("* ");
            }
            System.out.println();

            //middle row
            for (int i = 0; i < height - 2; i++) {
                System.out.print("* ");
                for (int j = 0; j < width - 2; j++) {
                    System.out.print("  ");
                }
                System.out.println("*");
            }


            //bottom rows
            for (int i = 0; i < width; i++) {
                System.out.print("* ");
            }
            System.out.println();


        }
    }