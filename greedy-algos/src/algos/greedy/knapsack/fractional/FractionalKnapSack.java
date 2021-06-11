package algos.greedy.knapsack.fractional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FractionalKnapSack {
 
	/*
	 * Problem statement:
	 * Given weights and values of n items, we need to put these items in a knapsack of capacity W to 
	 * get the maximum total value in the knapsack.
	 * 
	 * V: 60, 100, 120
	 * W: 10, 20, 30
	 */
	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(60, 40, 100, 120);
		List<Integer> weights = Arrays.asList(10, 40, 20, 30);  
		
		System.out.println("The maximum possible value: " + getMaxValue(values, weights, 50));
	}
	
	public static double getMaxValue(List<Integer> values, List<Integer> weights, int capacity) {
		List<ItemValue> items = getSortedItemCostList(values, weights);
		double maxValue = 0;
		double currWeight = 0;
		for(ItemValue item: items) {
			
			if (currWeight + item.getWeight() <= capacity) {
				currWeight = currWeight + item.getWeight();
				maxValue = maxValue + item.getValue();
			} else {
				double currValue = item.getCost() * (capacity - currWeight);
				maxValue = maxValue + currValue;
				break;
			}
		}
		return maxValue;
	}
	
	public static List<ItemValue> getSortedItemCostList(List<Integer> values, List<Integer> weights){
		List<ItemValue> items = new ArrayList<>();
		for(int i=0; i < values.size(); i++) {
			ItemValue itemValue = new ItemValue((double) values.get(i), (double)weights.get(i), (double)values.get(i)/weights.get(i));
			items.add(itemValue);
		}
		
		Collections.sort(items, (item1, item2) -> item2.getCost().compareTo(item1.getCost()));
		return items;
	}
}
