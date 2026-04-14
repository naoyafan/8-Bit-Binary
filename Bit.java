
/**
 * Write a description of class Bit here.
 * Only 0 or 1 is stored
 * @author (Sterling D. Fields)
 * @version (4/4/2026)
 */
public class Bit
{
    private int value;

    /**
     * Constructor for objects of class Bit
     * If the input isn't 0 or 1, automaticaly is 0
     * @param val Starting value for the bit
     */
    public Bit(int val)
    {
        if (val == 0 || val == 1) {
            value = val;
        } else {
            value = 0;
        }
    }

    /**
     * @return bit value as an int
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * If parameter isn't 0 or 1, bit keeps old value
     * @param val New value for bit
     */
    public void setValue(int val) {
        if (val == 0 || val == 1) {
            value = val;
        }
    }
    /**
     * @return 0 or 1 as a String ("")
     */
    public String toString() {
        return "" + value;
    }
    
    /**
     * Adding another bit to previous bit using binary
     * returns the carry bit(dValue)
     * @param b Bit to add
     * @return New Bit that contains the carry
     */
    public Bit add(Bit b) {
        int dValue = b.getValue(); //sees if bit is 0 or 1
        int sum = value + dValue;
        int carryVal = 0;
        
        if (sum == 2) { //if it equals 2 sets current to 0 and carries 1 over
            value = 0;
            carryVal = 1;
        } else if (sum == 1) { //stpres these without a carry
            value = 1;
            carryVal = 0;
        } else{
            value = 0;
            carryVal = 0;
        }
        
        return new Bit(carryVal);
    }
}
