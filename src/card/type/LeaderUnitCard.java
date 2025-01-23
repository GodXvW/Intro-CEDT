package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {

	private int buffPower;
	private int buffHealth;

	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower,
			int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffHealth(buffHealth);
		setBuffPower(buffPower);
	}

	public int getBuffPower() {
		return buffPower;
	}

	public void setBuffPower(int buffPower) {
		if (buffPower < 0) {
			this.buffPower = 0;
		} else
			this.buffPower = buffPower;
	}

	public int getBuffHealth() {
		return buffHealth;
	}

	public void setBuffHealth(int buffHealth) {
		if (buffHealth < 0) {
			this.buffHealth = 0;
		} else
			this.buffHealth = buffHealth;
	}

	public int attackUnit(UnitCard unitcard) {
		int damage = this.getPower();
		if (this.getPower() > unitcard.getHealth())
			damage = unitcard.getHealth();
		unitcard.setHealth(unitcard.getHealth() - this.getPower());
		return damage;
	}

	public void buffUnit(UnitCard[] alliesCard) {
		if (alliesCard.length != 0) {
			for (UnitCard card : alliesCard) {
				if (card != null) {
					card.setPower(card.getPower() + this.getBuffPower());
					card.setHealth(card.getHealth() + this.getBuffHealth());
				}
			}
		}
	}

	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + " | POW Inc: "
				+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

}