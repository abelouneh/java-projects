package week01;

import java.util.Scanner;

public class PetClinic {
    public static void main(String[] args) {
        Pet[] pets = new Pet[10];
        pets[0]= new Pet("jason","snake") ;
        pets[1]= new Pet("chicken","Chicken") ;
        pets[2]= new Pet("doggy","cat") ;
        pets[3]= new Pet("cupcake","dog") ;
        pets[4]= new Pet("habibi","snake") ;
        pets[5]= new Pet("sally","rat") ;
        pets[6]= new Pet("swimmy","fish") ;
        pets[7]= new Pet("flyi","bird") ;
        pets[8]= new Pet("jumpy","rabbit") ;
        pets[9]= new Pet("speedy","turtle")  ;

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the type of the pet: ");
        String speciekind = sc.nextLine();


        int counter = 0;
        String petname = "" ;
        for(int i=0 ; i<pets.length ; i++) {
            if(pets[i].specie.equalsIgnoreCase(speciekind)) {
                counter++;
                petname += pets[i].name + "\n" ;

            }


        }

        if(counter > 0) {
            System.out.println("nomber of certain species found is " + counter );
            System.out.println("the names of the searched species are :\n" + petname );
        }

        else {
            System.out.println("no species found");
        }
    }
}
