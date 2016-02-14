import java.util.*;

public class ClosestNumber {

	public static void main(String[] args) {		
		ClosestNumber closestNumber = new ClosestNumber();
		int[] input = closestNumber.parseInput();
		System.out.print(closestNumber.findClosestNumber(input));
	}
	
	private int[] parseInput(){
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();

		int[] input = new int[len];
		for(int i=0;i<len;i++){
			input[i] = Integer.parseInt(in.next());			
		}
		
		in.close();
		Arrays.sort(input);
		
		return input;
	}
	
	private StringBuilder findClosestNumber(int[] input){
		HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		int minDist = Integer.MAX_VALUE;
		int len = input.length;
		
		for(int i=0;i<len-1;i++){
			int myNumber = input[i];
			int next = input[i+1];
			
			int cdistance = Math.abs(next - myNumber);
			if(cdistance <= minDist){
				ArrayList<Integer> list = result.get(cdistance);
				if(list == null){
					list = new ArrayList<Integer>();
					result.put(cdistance, list);
				}
				list.add(myNumber);
				list.add(next);
				minDist = cdistance;
			}	
		}

		ArrayList<Integer> val = result.get(minDist);
		Iterator<Integer> listItr = val.iterator();

		StringBuilder resSb = new StringBuilder();
		while(listItr.hasNext()){
			resSb.append(listItr.next()+" ");			
		}
		
		return resSb;
	}
}
