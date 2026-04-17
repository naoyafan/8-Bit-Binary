
/**
 * Write a description of class DNumber here.
 * class that represents a number by storing the bits equivalent to that number
 * @author (Sterling D. Fields)
 * @version (4/10/2026)
 */
public class DNumber
{
    private Bit[] bits;
    private static final int SIZE = 8;
    
    /**
     * Constructor w/no parameters that sets everything to 0
     */
    public DNumber() {
        bits = new Bit[SIZE]; //array w/ empty spaces
        for (int i = 0; i < SIZE; i++) {  //0-7
            bits[i] = new Bit(0);  //gives the bits 0 in the spaces
        }
    }
    
    /**
     * Constructor converting int to binary bits going by powers of 2 to see if bit is 0 or 1
     * @param val integer to convert
     */
    public DNumber(int val) {
        bits = new Bit[SIZE];
        int leftover = val;
        
        int currentP2 = 128; //start with leftmost bit (2^7)
        //will loop through each array slot
        for (int i = 0; i < SIZE; i++) { 
            if (leftover >= currentP2) { //check if fits into leftover
                bits[i] = new Bit(1); //set to 1 if fits
                leftover = leftover - currentP2; // - value from leftover
            } else {
                bits[i] = new Bit(0);
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
            result += bits[i].toString();
        }
        return result;
    }
    
    public void add(DNumber d) {
        Bit carry = new Bit (0); //starts @ zero
        
        for (int i = SIZE - 1; i >= 0; i--) { //go from 7-0 again (right to left)
            carry = bits[i].add(d.bits[i], carry); //add current, Dnumber, and carry bits together
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
            if (bits[i].getValue() == 1) {
                total = total + currentP2; //makes sure computer saves answer from currentP2 and old total
            }
            currentP2 = currentP2 / 2; //goes to next power of 2
        }
        return total;
    }
        
}
