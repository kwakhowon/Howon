
public class SelectionSort {
	public static void main(String[] args) {
		int[] data = {22 , 5, 99, 55, 76};
		int size = data.length;
		for(int i =0; i<size-1; i++) {
			int min = i;
			for(int j= i+1; j<size; j++) {
				
				if(data[min] >data[j]) {
					min = j;
				}
			}
			int temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
		for(int i = 0 ; i <data.length; i++) {
			System.out.print(data[i]+"\t");
		}
	}
}
