
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
     * adds b and c to this bit and returns the carry 
     * @param b First bit added
     * @param c Second bit added
     * @return New bit that represents the carry(0 or 1)
     */
    public Bit add(Bit b, Bit c) {
        int sum = value + b.getValue() + c.getValue();
        int carryVal = 0;
        if (sum == 3) {
            value = 1; //11
            carryVal = 1;
        } else if (sum == 2) {
            value = 0; //10
            carryVal = 1;
        } else if (sum == 1) {
            value = 1; //01
            carryVal = 0;
        } else {
            value = 0; //00
            carryVal = 0;
        }
        return new Bit(carryVal);
        }
    }

