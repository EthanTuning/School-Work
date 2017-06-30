public class BinaryInteger extends LongInteger
{
   
	public BinaryInteger(String strVal)
	{
		super();
      long decVal;
		decVal = Long.parseLong(strVal, 2);
		this.setLong(decVal);
	}
	
   @Override
	public String toString()
	{
		String result;
		result = Long.toBinaryString(getLong());
		return result;
	}
}