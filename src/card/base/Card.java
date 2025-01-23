package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {
	private String name;
	private String flavorText;
	private int bloodCost;

	/// You can modify code below ///
	public Card(String name, String flavorText, int bloodCost) {
		this.setBloodCost(bloodCost);
		this.setFlavorText(flavorText);
		this.setName(name);
	}

	public abstract String toString();

	public String getName() {
		return this.name;
	}

	public int getBloodCost() {
		return this.bloodCost;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flovorText) {
		this.flavorText = flovorText;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBloodCost(int bloodCost) {
		if (bloodCost < 0) {
			this.bloodCost = 0;
		} else
			this.bloodCost = bloodCost;
	}

	/// You can modify code above ///

	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}