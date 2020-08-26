package mianshi;

public class BinarySearch1<T extends Comparable<T>> {
	private T[] data;

	public BinarySearch1(T[] data){
		this.data = data;
	}
	//·ÇµÝ¹é
	public int search(T key){
		int low = 0;
		int high = data.length - 1;
		int mid;
		if(data == null) return -1;
		while(low <= high){
			mid = (low + high) / 2;
			if(key.compareTo(data[mid]) < 0){
				high = mid - 1;
			}else if(key.compareTo(data[mid]) > 0){
				low = mid + 1;
			}else if(key.compareTo(data[mid]) == 0){
				return mid;
			}
		}
		return -1;
	}
	
	//µÝ¹é
	public int searchDG(T key){
		if(data == null) return -1;
		return doSearchDG(0 , data.length - 1, key);
	}
	
	private int doSearchDG(int low, int high, T key){
		int mid = (low + high) / 2 ;
		int result = key.compareTo(data[mid]);
		if(result < 0) {
			return doSearchDG(low, mid - 1 , key);
		}else if(result > 0){
			return doSearchDG(mid + 1 , high ,key);
		}else if(result == 0){
			return mid;
		}
		return -1;
	}
	
	public static void main(String arg[]){
		Integer [] data = {1 , 3,5,7,9,31,45,46};
		BinarySearch1<Integer> binary = new BinarySearch1<Integer>(data);
		System.out.println(binary.search(46));
		System.out.println(binary.searchDG(31));
	}
}
