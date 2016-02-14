import java.util.*;

public class FullCountingSort implements Comparable<FullCountingSort>{
	Integer num;
	String str;

	public FullCountingSort(Integer num, String str){
		this.num = num;
		this.str = str;		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();

		FullCountingSort firstHalf[] = parse((int)Math.ceil((double)len/2), in);
		FullCountingSort secondHalf[] = parse((int)Math.ceil((double)len/2), in);		

		Arrays.sort(firstHalf);
		Arrays.sort(secondHalf);
		
		System.out.print(merge(firstHalf, secondHalf));
	}
	
	public static FullCountingSort[] parse(int len, Scanner in){
		FullCountingSort firstHalf[] = new FullCountingSort[len];
		
		for(int index=0;index<len;index++){
			{
				String vals = in.next();
				int num = Integer.parseInt(vals);	
				
				String str = in.next();
				
				firstHalf[index] = new FullCountingSort(num,str);
			}
		}		
		return firstHalf;
	}
	
	
	public static StringBuilder merge(FullCountingSort[] fc1, FullCountingSort[] fc2){
		int i=0, j=0;
		StringBuilder sb = new StringBuilder();
		
		while(i < fc1.length && j < fc2.length){
			if(fc1[i].compareTo(fc2[j]) <= 0){
				sb.append("- ");
				i++;
			}else{
				sb.append(fc2[j].str+" ");
				j++;
			}			
		}		
		
		while(i < fc1.length){
			sb.append("- ");
			i++;
		}
		
		while(j<fc2.length){
			sb.append(fc2[j].str+" ");
			j++;
		}
		
		return sb;		
	}

	@Override
	public int compareTo(FullCountingSort arg1) {
		if(this.num == arg1.num){
			return 0;
		}else if(this.num < arg1.num){
			return -1;
		}else{
			return 1;
		}		
	}
}
