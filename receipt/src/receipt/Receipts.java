// Antonio Fabrizio
// September 11th 2023
// Lab 2. In-lab exercise
// This program prints out a receipt by calling different methods that use parameters to calculate the tax, tip, and total 

package receipt;

public class Receipts {
	public static void main(String[] args) {
	    double subtotal = 100;
	    double TAX_RATE = 0.08;
	    final double TIP_RATE = 0.2;

	    double mytax = getTax(subtotal, TAX_RATE);
	    
	    double mytip = getTip(subtotal, TIP_RATE);

	    double total = getTotal(subtotal, mytip, mytax);
	    
	    String receipt = getReceipt(subtotal, mytax, mytip, total);
	    
	    System.out.println(receipt);
	    
	  }
	
	public static double getTax(double subtotal, double tax_rate) 
	{
		double tax = subtotal * tax_rate;
		return tax;
	}
	public static double getTip(double subtotal, double tip_rate) 
	{
	    double tip = subtotal * tip_rate;
		return tip;
	}
	public static double getTotal(double subtotal, double tip, double tax) 
	{
	    double total = subtotal + tip + tax;
		return total;
	}
	public static String getReceipt(double subtotal, double tax, double tip, double total) 
	{
		String myReceipt = "subtotal: " + subtotal + " " + "tax: " + tax + " " + "tip: " + tip + " " + "total: " + total;
		return myReceipt;
	}
}
