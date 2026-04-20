import java.util.ArrayList;

/**
 * Write a description of class DNumber here.
 * class that represents a number by storing the bits equivalent to that number
 * converts between hex, decimals, and binary
 * @author (Sterling D. Fields)
 * @version (4/10/2026)
 */
public class DNumber
{
    private ArrayList<Bit> bits;
    private static final int SIZE = 8;
    
    /**
     * Constructor w/no parameters that sets everything to 0
     * makes an ArrayList and fill it in with 8 bits
     */
    public DNumber() {
        bits = new ArrayList<Bit>(); //array w/ empty spaces
        for (int i = 0; i < SIZE; i++) {  //0-7
            bits.add(new Bit(0));  //gives the bits 0 in the spaces
        }
    }
    
    /**
     * Constructor converting int to binary bits going by powers of 2 to see if bit is 0 or 1
     * @param val integer to convert
     */
    public DNumber(int val) {
        bits = new ArrayList<Bit>();
        int leftover = val;
        
        int currentP2 = 128; //start with leftmost bit (2^7)
        //will loop through each array slot
        for (int i = 0; i < SIZE; i++) { 
            if (leftover >= currentP2) { //check if fits into leftover
                bits.add(new Bit(1)); //set to 1 if fits
                leftover = leftover - currentP2; // - value from leftover
            } else {
                bits.add(new Bit(0));
            }
            currentP2 = currentP2 / 2; //cut p2 in half for next slot
        }
    }
    
    /**
     * @return String of 1s and 0s
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < SIZE; i++) {
            result += bits.get(i).toString(); //change to .get since its an ArrayList
        }
        return result;
    }
    
    /**
     * adds another object doing the binary add
     * @param d The other object we're adding to this one
     */
    public void add(DNumber d) {
        Bit carry = new Bit (0); //starts @ zero
        
        for (int i = SIZE - 1; i >= 0; i--) { //go from 7-0 again (right to left)
            carry = bits.get(i).add(d.bits.get(i), carry); //.get() for both objects
        }
        
        if (carry.getValue() == 1) {
            System.out.println("Error: overflow"); //after adding and its still has a carry
        }
    }
    
    /**
     * Converts current binary to a decimal number
     * each bit is multiplied by whatever power of two corresponds
     * @return Decimal int of the binary number
     */
    public int toDecimal() {
        int total = 0;
        int currentP2 = 128; //start @ 2^7
        
        for (int i = 0; i < SIZE; i++) {
            if (bits.get(i).getValue() == 1) {
                total = total + currentP2; //makes sure computer saves answer from currentP2 and old total
            }
            currentP2 = currentP2 / 2; //goes to next power of 2
        }
        return total;
    }
    
    /**
     * turns numbers into hex letters
     * @param value Number that will turn into a letter
     * @return Strinf with hex characters
     */
    private String hexLett(int value) {
        if (value <= 9) {
            return "" + value; //numbers 0-9 just strings
        } else if (value == 10) {return "A";}
        else if (value == 11) {return "B";}
        else if (value == 12) {return "C";}
        else if (value == 13) {return "D";}
        else if (value == 14) {return "E";}
        else {return "F";} 
    }
    
    /**
     * changes from binary to a two digit hexadecimal string
     * @return Hex string 
     */
    public String toHex() { 
        int decimal = toDecimal(); //gets my decimal first
        int fDigit = decimal / 16; //then divide by 16 to get first number
        int sDigit = decimal % 16; //then find the leftovers for the second digit
        
        return hexLett(fDigit) + hexLett(sDigit); //puts the two charcters together (ex. C5 or D9)
    }
}
