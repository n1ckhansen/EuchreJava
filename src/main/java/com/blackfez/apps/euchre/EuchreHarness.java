package com.blackfez.apps.euchre;

import java.util.LinkedList;
import java.util.Random;

import com.blackfez.apps.euchre.Player.POSITION;
import com.blackfez.apps.euchre.Team.TeamType;
import com.blackfez.cards.Card;

public class EuchreHarness {
	
	private EuchreDeck Deck;
	private Team teamNS;
	private Team teamEW;
	private Player dealer;
	private LinkedList<Player> dealOrder;
	
	public EuchreHarness() {
		this.teamEW = new Team( TeamType.EW );
		this.teamNS = new Team( TeamType.NS );
		this.setDealer( new Random().nextInt(Player.POSITION.values().length) );
		System.out.println( "Dealer is " + this.dealer.getName() );
		System.out.println( "Deal order is ");
		for( int i = 0; i < 4; i++ ) {
			Player p = this.dealOrder.pollLast();
			System.out.println( p.getName() );
			this.dealOrder.push( p );
		}
	}
	
	private void deal() {
		this.Deck.shuffleCards();
		for( int i = 0; i < 20; i++ ) {
			Player p = this.dealOrder.pollLast();
			p.receiveCard( this.Deck.dealCard() );
			this.dealOrder.push( p );
		}
	}
	
	private Player getPlayerByPosition( POSITION p ) {
		if( p == POSITION.EAST || p == POSITION.WEST )
			return teamEW.getPlayerByPosition( p );
		else
			return teamNS.getPlayerByPosition( p );
	}
	
	private void setDealer( Integer index ) {
		this.dealer = this.getPlayerByPosition( Player.POSITION.values()[ index ] );
		this.dealOrder = new LinkedList<Player>();
		for( int i = 1; i <=4; i++ ) {
			this.dealOrder.push( this.getPlayerByPosition( Player.POSITION.values()[ ( index + i ) % 4 ] ) );
		}
		
	}
	
	public static void main(String[] args) {
		EuchreHarness app = new EuchreHarness();
		app.Deck = new EuchreDeck();
		app.deal();
		for( POSITION pos : Player.POSITION.values() ) {
			Player p = app.getPlayerByPosition( pos );
			System.out.print( p.getName() );
			for( Card c : p.showCards() ) {
				System.out.print( " " + c.getFace() );
				System.out.print( c.getSuit() );
			}
			System.out.println( " " );
		}
		Card offeredTrump = app.Deck.dealCard();
		System.out.println( "Trump card is " + offeredTrump.getFace() + offeredTrump.getSuit() );
		System.out.print( "Kitty is ");
		while( !app.Deck.getCards().isEmpty() ) {
			Card c = app.Deck.dealCard();
			System.out.print( " " + c.getFace() + c.getSuit() );
		}
		System.out.println( " " );

	}

}
