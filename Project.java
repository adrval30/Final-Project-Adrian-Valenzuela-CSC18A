class CONSTANTS {
  //Declare constant static variables
  public static final String mango = "mango";
  public static final String straw = "strawberry";
  public static final String vanil = "vanilla";
  public static final String gummy = "gummy bears";
  public static final String oreo = "oreo bits";
  public static final String none = "NONE";
  public static final double taxRate = .0775;
}

class iceCream extends Toppings {
  
  //Declare member variables
  String flavor;
  private double flavPrice;
  
  //Constructor for class
  iceCream(String flavor, String topping1, String topping2) {
    super(topping1, topping2);
	//Set the flavor
	this.flavor = flavor;
	//Set the price to 0
	this.flavPrice = 0.00;
  }

  //Return the pricing total plus tax
  double flavPrice() {
	//find the cost of the ice cream
	switch(this.flavor) {
	  case CONSTANTS.mango:
		this.flavPrice = 4.50;
	  break;
	  case CONSTANTS.straw:
		this.flavPrice = 4.00;
	  break;
	  case CONSTANTS.vanil:
		this.flavPrice = 5.00;
	  break;
	  default:
		this.flavPrice = 0.00;
	}

	//Return cost of flavor
	return this.flavPrice;
  }
  double taxCalc() {
	return (this.flavPrice() + super.topPrice()) * CONSTANTS.taxRate;
  }
}

//Interface for the Toppings class
interface TopI {
  //To return the price of all the toppings once all summed
  default double topPrice() {
	System.out.println("N/A");
	return 0.00;
  }
}

class Toppings implements TopI {

  String toppings [] = {"", ""};
  double topPrice;

  Toppings (String topping1, String topping2) {
	this.toppings[0] = topping1;
	this.toppings[1] = topping2;
	this.topPrice = 0.00;
  }

  Toppings (String topping1) {
  	this.toppings[0] = topping1;
	this.topPrice = 0.00;
  }

  Toppings () {
	this.topPrice = 0.00;
  }
  
  //Returns the total price of the toppings
  public double topPrice() {
  double total = 0;	//For summing the prices 
  int size;
  if (toppings[0] == "" && toppings[1] == "") size = 0;
  else if(toppings[1] == "") size = 1;
  else size = 2;

  	  //Find cost of the topping
	  for(int i = 0; i < size; i++) {
	    switch(this.toppings[i]) {
	      case CONSTANTS.gummy:
		    this.topPrice = 0.50;
	      break;
	      case CONSTANTS.oreo:
		    this.topPrice = 1.00;
	      break;
	      default:
		    this.topPrice = 0.00;
	    }
	    //Increment total on each iteration to sum total toppings price
	    total += topPrice;
	  }
 	return total;
  }
}

class Project {
  public static void main (String args[]) {
	System.out.println("Hello World");
  }
}