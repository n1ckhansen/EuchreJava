package com.blackfez.apps.euchre;

import java.util.List;

import com.blackfez.apps.euchre.Player.POSITION;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private List<Player> players = new ArrayList<Player>( 2 );
	public enum TeamType {
		NS, /*North-South*/
		EW /*East-West*/
	}
	private TeamType team;
	
	public Team ( TeamType type ) {
		this.setTeam( type );
		if( type == TeamType.NS ) {
			this.addMember( new Player( "North", POSITION.NORTH ) );
			this.addMember( new Player( "South", POSITION.SOUTH ) );
		}
		else {
			this.addMember( new Player( "East", POSITION.EAST ) );
			this.addMember( new Player( "West", POSITION.WEST ) );
		}
	}
	
	public void addMember( Player p ) {
		this.players.add( p );
	}
	
	
	public Player getPlayerByPosition( POSITION p ) {
		for( Player player : this.players ) {
			if( player.getPosition() == p ) 
				return player;
		}
		return null;
	}
	
	public TeamType getTeam() {
		return this.team;
	}
		
	private void setTeam( TeamType t ) {
		this.team = t;
	}
	

}
