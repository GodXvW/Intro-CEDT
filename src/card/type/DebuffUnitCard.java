package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {

	private int debuffpower;

	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name, flavorText, bloodCost, power, health);
		setDebuffPower(debuffPower);
	}

	public int getDebuffPower() {
		return debuffpower;
	}

	public void setDebuffPower(int debuffpower) {
		if (debuffpower < 0) {
			this.debuffpower = 0;
		} else
			this.debuffpower = debuffpower;
	}

	@Override
	public int attackUnit(UnitCard unitcard) {
		int damage = this.getPower();
		if (this.getPower() > unitcard.getHealth())
			damage = unitcard.getHealth();
		unitcard.setPower(unitcard.getPower() - this.getDebuffPower());
		unitcard.setHealth(unitcard.getHealth() - this.getPower());
		return damage;
	}
}
