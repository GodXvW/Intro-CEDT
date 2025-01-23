package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {

	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}

	@Override
	public int attackUnit(UnitCard unitcard) {
		int damage = this.getPower();
		if (this.getPower() > unitcard.getHealth())
			damage = unitcard.getHealth();
		unitcard.setHealth(unitcard.getHealth() - this.getPower());
		return damage;
	}

}
