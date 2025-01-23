package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList;

	public Deck(String name, Card[] deckList) {
		setName(name);
		setDeckSize(deckList.length);
		setDeckList(deckList);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeckSize() {
		return this.deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public Card[] getDeckList() {
		return this.deckList;
	}

	public void setDeckList(Card[] deckList) {
		this.deckList = deckList;
	}

	// You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		for (Card repeat : this.getDeckList()) {
			if (repeat.equals(card))
				count++;
		}
		if (count >= 4) {
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		}
		Card[] temp = Arrays.copyOf(this.getDeckList(), this.getDeckSize() + 1);
		temp[this.getDeckSize()] = card;
		this.setDeckSize(temp.length);
		this.setDeckList(temp);
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Must return new deckSize
		
		return this.getDeckSize();
	}

	// You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		Card removed = this.deckList[slotNumber];
		for (int i = slotNumber; i < this.getDeckSize() - 1; i++) {
			this.deckList[i] = this.deckList[i + 1];
		}
		Card[] temp = Arrays.copyOf(this.getDeckList(), this.getDeckSize() - 1);
		this.setDeckList(temp);
		this.setDeckSize(temp.length);
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size (Added slot is empty)
		// Once card is removed, other card down the list must rearrange to the empty
		// slot
		// Must return card that was removed
		return removed;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append("}").append("(").append(this.getDeckSize())
				.append(" deck size)").toString();
	}

	/* GETTERS & SETTERS */

}
