package algos.greedy.knapsack.fractional;

public class ItemValue {

	private double value;
	private double weight;
	private Double cost;
	
	public ItemValue(double value, double weight, Double cost) {
		this.value = value;
		this.weight = weight;
		this.cost = cost;
	}

	public double getValue() {
		return value;
	}

	public double getWeight() {
		return weight;
	}

	public Double getCost() {
		return cost;
	}
}
