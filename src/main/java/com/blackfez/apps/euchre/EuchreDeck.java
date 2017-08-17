package com.blackfez.apps.euchre;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.blackfez.cards.Faces.Face;
import com.blackfez.cards.Suits.Suit;
import com.blackfez.cards.Deck;
import com.blackfez.cards.Card;

public class EuchreDeck extends Deck {
	
	private Suit trump;

	public EuchreDeck() {
		setSuits( Arrays.asList( Suit.values() ) );
		setRanges( new HashMap<Suit,List<Face>>() );
		Face[] f = { Face.NINE, Face.TEN, Face.JACK, Face.QUEEN, Face.KING, Face.ACE };
		for( Suit suit : getSuits() ) {
			getRanges().put( suit, Arrays.asList( f ) );
		}
		createDeck();
	}
	
	public Integer getCardValue( Card card ) {
		switch( card.getFace() ) {
			case NINE:
				return 9;
			case TEN:
				return 10;
			case JACK:
				if( isTrump( card.getSuit() ) )
					return 16;
				else if( isOffSuit( card.getSuit() ) )
					return 15;
				else
					return 11;
			case QUEEN:
				return 12;
			case KING:
				return 13;
			case ACE:
				return 14;
			default:
				return null;
		
		
		}
		
	}
	
	public Suit getTrump() {
		return this.trump;
	}
	
	public Boolean isOffSuit( Suit suit ) {
		switch( getTrump() ) {
			case CLUB:
				return suit == suit.SPADE;
			case DIAMOND:
				return suit == suit.HEART;
			case HEART:
				return suit == suit.DIAMOND;
			case SPADE:
				return suit == suit.CLUB;
			default:
				return null;
 		}
	}
	
	public Boolean isTrump( Suit suit ) {
		return suit == this.getTrump();
	}
	
	public void setTrump( Suit suit ) {
		this.trump = suit;
	}
}
