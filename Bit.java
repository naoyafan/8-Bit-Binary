
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
}
