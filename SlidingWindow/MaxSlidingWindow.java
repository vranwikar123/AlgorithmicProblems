package educative.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {

	public static void main(String[] args)
	{
		int[] inp = {-4, 5, 4, -4, 4, 6, 7, 20};
		int k = 3;
		
		List<Integer> opList = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<k;i++)
		{
			if(max < inp[i])
				max = inp[i];
		}
		opList.add(max);
		
		for(int i=k;i<inp.length;i++)
		{
			if(inp[k] > max)
			{
				opList.add(inp[k]);
				max = inp[k];
			}
			else
			{
				//find out max in last K elements
				 max = Integer.MIN_VALUE;
				for(int j=k;j>i-k;j--)
				{
					if(max < inp[j])
						max = inp[j];
				}
				opList.add(max);
			}
		}
		
		for(int i:opList)
		{
			System.out.print(i+" ");
		}
	}
	
	
}
