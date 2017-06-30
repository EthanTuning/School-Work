public class OctalInteger extends LongInteger
{
	public OctalInteger(String strVal)
	{
		super();
      long decVal;
		decVal = Long.parseLong(strVal, 8);
		this.setLong(decVal);
	}
	
   @Override
	public String toString()
	{
		String result;
		result = Long.toOctalString(getLong());
		return result;
	}


}