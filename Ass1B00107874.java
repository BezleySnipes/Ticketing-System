
// Programmer: David Mulhall
// Student Id: B00107874
// Date Written: 24/10/2017
// Function: Assignment 1



// Import required libraries
import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;

// Declare class
class Ass1B00107874
{

	public static void main(String [] args)throws IOException, InterruptedException{
// Initialise transaction loop counter
		int tickets = 1;
// Begin main loop
		while (true)
		{
// Create and initialise variables
			clearScreen(); // call clear screen method
			Scanner myinput = new Scanner(System.in);
			String name = "";
			String show = "";
			String choice = "";
			String more = "";
			int guests = 0;
			int loop = 0;
			double price = 0.00;
			double total = 0.00;

// Load first screen to user
			clearScreen(); // call clear screen method
			banner(); // call banner method
			System.out.println("                             Welcome to Ticketmaster");
			System.out.println("");
			System.out.println("Please enter your surname: ");
			System.out.println("");
			name = myinput.nextLine(); // Set name variable to next full line input

// Load second screen to user and begin error catching in loop
			while(loop == 0)
			{
			clearScreen(); // call clear screen method
			banner(); // call banner method
			System.out.println("");
			System.out.println("What show would you like to see? ");
			System.out.println("");
			System.out.println("");
			System.out.println(" 1. Star Wars        2. Guardians of the Galaxy");
			System.out.println("");
			System.out.println(" 3. Hackers          4. Legally Blonde");
			System.out.println("");
			choice = myinput.next(); // Set movie choice variable to next input

// Use switch statement to set show varible and set loop exit condition to move to next section
			switch(choice)
					{
					case "1": show = "Star wars";loop = 1;
					break;
					case "2": show = "Guardians of the Galaxy";loop = 1;
					break;
					case "3": show = "Hackers";loop = 1;
					break;
					case "4": show = "Legally Blonde";loop = 1;
					break;
					default: System.out.println("Please enter a number corrisponding to your movie choice ");
					Thread.sleep(1000); // starts timer to wait 1 second before reloading the page
					}
			}

// Load third screen to user and begin error catching in loop
			while (loop == 1)
			{
			clearScreen(); // call clear screen method
			banner(); // call banner method
			System.out.println("");
			System.out.println("How many people in your party? ");
			System.out.println("");

				if(myinput.hasNextInt()) // checks to make sure input is of type Int
					{
						guests = myinput.nextInt(); // Sets guests variable to be the next input
						if(guests != 0) // Check to make sure that amount of tickets needed is more than 0
							{
							loop = 0; // set loop exit condition
							}
					}
				else
					{
						myinput.next(); // looking for user to reinput
						System.out.println("Please enter a valid number of tickets!");
						Thread.sleep(1000); // starts timer to wait 1 second before reloading the page
					}
			}
// Once out of error catching loop set price of ticket based on the number of guests
// Apply discounted price if more than 6 guests
				if(guests>6)
					{
						price=22.50;
					}
				else
					{
						price=25.00;
					}

			total = (guests*price); // Set total variable to be displayed as equals to price multiplied by number of guests
			clearScreen(); // call clear screen method
			printTicket(name,show,guests,total); // call print ticket method and forward variables as method parameters

			more = myinput.next(); // waiting for user input to say wheter they want more tickets
// Error catch loop looks to make sure that the user enters ONLY a Y or N.
// While not Y or N loop is maintained
			while (!"Y".equalsIgnoreCase(more) && !"N".equalsIgnoreCase(more))
				{
				   System.out.println("\nInvalid response. Try again.");
				   more = myinput.next();

				}
// once loop exit condition is met user is prompted with the total number of transactions and system exits
			if ("n".equalsIgnoreCase(more))
				{
					System.out.println("               Total number of transactions this session was "+tickets);
					System.out.println("");
					System.out.println("                             Have a great day!");
					break; // system exit is made.
				}
			tickets++; // increase ticket count by 1
		}


}



	public static void clearScreen()throws IOException, InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}



	public static void banner()
	{
	System.out.println("##################################################################################");
	System.out.println("###   __________________ __ ____________   __  ______   _____________________  ###");
	System.out.println("###  /_  __/  _/ ____/ //_// ____/_  __/  /  |/  /   | / ___/_  __/ ____/ __ ) ###");
	System.out.println("###   / /  / // /   / ,<  / __/   / /    / /|_/ / /| | )__ ) / / / __/ / /_/ / ###");
	System.out.println("###  / / _/ // /___/ /| |/ /___  / /    / /  / / ___ |___/ // / / /___/ _, _/  ###");
	System.out.println("### /_/ /___/)____/_/ |_/_____/ /_/    /_/  /_/_/  |_/____//_/ /_____/_/ |_|   ###");
	System.out.println("###                                                                            ###");
	System.out.println("###                                                                 (c) 1983   ###");
	System.out.println("##################################################################################");
	}



	public static void printTicket(String info1, String info2, int info3, double info4)throws IOException, InterruptedException
	{
		DecimalFormat df = new DecimalFormat("¤¤ 0.00");
		banner();
		System.out.println("                              Proudly presents");
		System.out.println("");
		System.out.println("");
		System.out.println("Show          : "+info2);
		System.out.println("");
		System.out.println("Surname       : "+info1);
		System.out.println("");
		System.out.println("No. in party  : "+info3);
		System.out.println("");
		System.out.println("Price         : "+df.format(info4));
		System.out.println("");
		System.out.println("");
		System.out.println("##############################################################################");
		System.out.println("             TicketMaster retains the right to refuse admission");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("                   Would you like to purchase more tickets?");
		System.out.println("                                    Y/N");
		System.out.println("");

	}

}