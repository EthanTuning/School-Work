public class MinHeap{
	private int[] heap;
	private int max;
	private int size;
	
	public MinHeap(int max){
		this.max = max;
		this.size = 0;
		this.heap = new int[max + 1];
		this.heap[0] = Integer.MIN_VALUE;
	}
	
	public void minHeapify(int index){
		if(!isLeaf(index)){
			if(this.heap[index] > this.heap[getLeftChild(index)] || this.heap[index] > this.heap[getRightChild(index)]){
				if(this.heap[index] > this.heap[getLeftChild(index)]){
					swap(index, getLeftChild(index));
					minHeapify(getLeftChild(index));
				}
				if(this.heap[index] > this.heap[getRightChild(index)]){
					swap(index, getRightChild(index));
					minHeapify(getRightChild(index));
				}
			}
		}
	}
	
	public void maxHeapify(int index){
		if(!isLeaf(index)){
			if(this.heap[index] < this.heap[getLeftChild(index)] || this.heap[index] < this.heap[getRightChild(index)]){
				if(this.heap[index] < this.heap[getLeftChild(index)]){
					swap(index, getLeftChild(index));
					maxHeapify(getLeftChild(index));
				}
				if(this.heap[index] < this.heap[getRightChild(index)]){
					swap(index, getRightChild(index));
					maxHeapify(getRightChild(index));
				}
			}
		}
	}
	
	public void heapSort(){
		for(int i = this.size; i >= 2; i--){
			swap(1, i);
			maxHeapify(1);
			this.size--;
		}
	}
	
	public void buildMaxHeap(){
		for(int curr = (this.size/2); curr >= 1; curr--)
			maxHeapify(curr);
	}
	
	public void add(int data){
		this.size++;
		this.heap[size] = data;
		int curr = this.size;
		
		if(this.size > 1){
			while(this.heap[curr] < this.heap[getParent(curr)]){
				swap(curr, getParent(curr));
				curr = getParent(curr);
			}
		}
	}
	
	public void remove(int index){
		this.heap[index] = this.heap[this.size];
		this.size--;
		minHeapify(index);
	}
	
	public void swap(int first, int second){
		int temp = this.heap[first];
		this.heap[first] = this.heap[second];
		this.heap[second] = temp;
	}
	
	public boolean isLeaf(int index){
		if(index <= this.size && index >= (this.size/2))
			return true;
		return false;
	}
	
	public int getParent(int index){
		return index/2;
	}
	
	public int getRightChild(int index){
		return (index*2) + 1;
	}
	
	public int getLeftChild(int index){
		return (index*2);
	}
	
	public int getSize(){
		return this.size;
	}
	
	public int getMax(){
		return this.max;
	}
	
	public int getHeapIndex(int index){
		return this.heap[index];
	}
}