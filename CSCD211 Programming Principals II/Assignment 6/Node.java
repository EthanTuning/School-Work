	public class Node implements Comparable<Node>
	{
		Node next;
		Integer value;
      /*
         this is a very straight forward class, simply makes a node
         to store data in
      */
		public Node(Integer value1)
		{
			next = null;
			value = value1;
		}
		
		public Node(Integer value1, Node next1)
		{
			next = next1;
			value = value1;
		}
		
		public Integer getVal()
		{
			return value;
		}
		
		public void setVal(Integer value1)
		{
			value = value1;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node next1)
		{
         next = next1;
      }
      
      @Override
      public int compareTo(Node that)
      {
         return ((Integer)value).compareTo((Integer)that.value);
      }
}
		