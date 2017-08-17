package com.blackfez.apps.euchre;

import java.util.HashSet;
import java.util.Set;

import com.blackfez.cards.Card;

public class Player {
	
	private String name;
	public enum POSITION {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	private POSITION position;
	private Set<Card> hand = new HashSet<Card>();
	
	public Player( String name, POSITION position ) {
		this.setName( name );
		this.setPosition( position );
	}
	
	public String getName() {
		return this.name;
	}
	
	public POSITION getPosition() {
		return this.position;
	}
	
	public void receiveCard( Card card ) {
		this.hand.add( card );
	}
	
	private void setName( String name ) {
		this.name = name;
	}
	
	private void setPosition( POSITION p ) {
		this.position = p;
	}
	
	public Set<Card> showCards() {
		return this.hand;
	}
	

}
