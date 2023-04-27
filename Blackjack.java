import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        //Task 3 – Wait for the user to press enter.
        scan.nextLine();
        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>

        int randomK, randomN, randomDN, randomJ, randomL;
        int random1 = drawRandomCard();
        int random2 = drawRandomCard();

        String randomCard1 = cardString(random1);
        String randomCard2 = cardString(random2);

        System.out.println("\n You get a \n" + randomCard1 + "\n and a \n" + randomCard2);
        
        //Task 5 – Print the sum of your hand value.

        // return min value but easier if use Math.min
        if (random1 > 10){
            randomN = 10;
        } else{
            randomN = random1;
        }
        if (random2> 10){
            randomK =10;
        } else {
            randomK = random2;
        }

        int handValue = randomN + randomK;
        System.out.println("your total is: " + handValue);
        System.out.println("Click enter to see dealer cards");
        scan.nextLine();

        
        //Task 6 – Get two random cards for the dealer.

        int randomDealer1 = drawRandomCard();
        int randomDealer2 = drawRandomCard();

        String randomDeal1 = cardString (randomDealer1);
        String randomDeal2 = cardString (randomDealer2);
        String faceDown = faceDown();
        System.out.println("The dealer shows \n" + randomDeal1 + "\nand has a card facing down \n" + faceDown);
        System.out.println("The dealer's total is hidden");


       
        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        String dec = hitOrStay();
        while(dec.equalsIgnoreCase("hit")){
        
            int randomNew = drawRandomCard();

            String randomNewCard = cardString(randomNew);
    
            System.out.println("\n You get a \n" + randomNewCard);
            
            
            if (randomNew > 10 ){
                handValue += 10;
            }
            else {
                handValue += randomNew;
            }
            
            if (handValue>21){
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
            System.out.println("your new total is: " + handValue);

            System.out.println("Do you want to hit or stay?");
            System.out.println("Please write 'hit' or 'stay'");

            dec = scan.nextLine();

    
        }

        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are " + "\n" + randomDeal1 + "\n" +" and a " + "\n" + randomDeal2);

        if (randomDealer1 > 10){
            randomJ = 10;
        } else{
            randomJ = randomDealer1;
        }
        if (randomDealer2> 10){
            randomL =10;
        } else {
            randomL = randomDealer2;
        }
        int dealerValue = randomJ + randomL;
        while (dealerValue <=17){
            int randomDealerNew = drawRandomCard();
            String randomDealerNewCard = cardString(randomDealerNew);
            System.out.println("Dealer gets a" + "\n" + randomDealerNewCard);
            if (randomDealerNew > 10){
                randomDN = 10;
            } else{
                randomDN = randomDealerNew;
            }
            dealerValue += randomDN;
            System.out.println("Dealer's total is: " + dealerValue);
        }

        if (dealerValue > 21){
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        }

        if (handValue > dealerValue){
            System.out.println("Player wins");
        } else {
            System.out.println("Dealer wins");
        }


        //       2. Once the player stays, break the loop. 

        
        //For tasks 9 to 13, see the article: Blackjack Part II. 






         scan.close();
        
        //  
        
         
    

    }

    /** Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */
    public static Integer drawRandomCard(){
        double randomCard = Math.random() * 13;
        randomCard += 1;

        return (int) randomCard;
    }


    /** Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

     public static String cardString(int cardNumber){
        switch (cardNumber){
            case 1: return
             
            "   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n";
   
      case 2: return

             "   _____\n"+              
             "  |2    |\n"+ 
             "  |  o  |\n"+
             "  |     |\n"+
             "  |  o  |\n"+
             "  |____Z|\n";
           
      case 3: return
           "   _____\n" +
           "  |3    |\n"+
           "  | o o |\n"+
           "  |     |\n"+
           "  |  o  |\n"+
           "  |____E|\n";

      case 4: return
            "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";

      case 5: return
             "   _____ \n" +
             "  |5    |\n" +
             "  | o o |\n" +
             "  |  o  |\n" +
             "  | o o |\n" +
             "  |____S|\n";

      case 6: return
             "   _____ \n" +
             "  |6    |\n" +
             "  | o o |\n" +
             "  | o o |\n" +
             "  | o o |\n" +
             "  |____6|\n";

      case 7: return
       
             "   _____ \n" +
             "  |7    |\n" +
             "  | o o |\n" +
             "  |o o o|\n" +
             "  | o o |\n" +
             "  |____7|\n";
   
      case 8: return
     
             "   _____ \n" +
             "  |8    |\n" +
             "  |o o o|\n" +
             "  | o o |\n" +
             "  |o o o|\n" +
             "  |____8|\n";
      
      case 9: return
             "   _____ \n" +
             "  |9    |\n" +
             "  |o o o|\n" +
             "  |o o o|\n" +
             "  |o o o|\n" +
             "  |____9|\n";

      case 10: return
             "   _____ \n" +
             "  |10  o|\n" +
             "  |o o o|\n" +
             "  |o o o|\n" +
             "  |o o o|\n" +
             "  |___10|\n";
     
     case 11: return

             "   _____\n" +
             "  |J  ww|\n"+ 
             "  | o {)|\n"+ 
             "  |o o% |\n"+ 
             "  | | % |\n"+ 
             "  |__%%[|\n";
     
     case 12: return

             "   _____\n" +
             "  |Q  ww|\n"+ 
             "  | o {(|\n"+ 
             "  |o o%%|\n"+ 
             "  | |%%%|\n"+ 
             "  |_%%%O|\n";
       
       case 13: return
             "   _____\n" +
             "  |K  WW|\n"+ 
             "  | o {)|\n"+ 
             "  |o o%%|\n"+ 
             "  | |%%%|\n"+ 
             "  |_%%%>|\n";
        
        default: return "This shouldn't get called";
        }
     }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
    public static String hitOrStay(){
        System.out.println("Please write 'hit' or 'stay'");
        System.out.println("\n");
        String decision = scan.nextLine();
        while(!(decision.equalsIgnoreCase("hit") || decision.equalsIgnoreCase("stay"))){
            System.out.println("Please write 'hit' or 'stay'");
            decision = scan.nextLine();
        }
        
        return decision;
    }
    }

