public class HexInteger extends LongInteger
{
	public HexInteger(String strVal)
	{
		super();
      long decVal;
		decVal = Long.parseLong(strVal, 16);
		this.setLong(decVal);
	}
	
   @Override
	public String toString()
	{
		String result;
		result = Long.toHexString(getLong());
		return result;
	}


}