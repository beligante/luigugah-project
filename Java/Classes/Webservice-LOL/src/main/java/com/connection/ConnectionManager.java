package com.connection;

import java.util.Map;

import com.achimala.leaguelib.connection.LeagueAccount;
import com.achimala.leaguelib.connection.LeagueConnection;
import com.achimala.leaguelib.connection.LeagueServer;
import com.achimala.leaguelib.errors.LeagueException;

public class ConnectionManager {

	public LeagueConnection getLeagueConnection(LeagueServer server, String user, String password, String gameVersion)
	{
		final LeagueConnection c = new LeagueConnection(server);
        try {
			c.getAccountQueue().addAccount(new LeagueAccount(server, gameVersion, user, password));
		} catch (LeagueException e) {
			e.printStackTrace();
			return null;
		}
        
        Map<LeagueAccount, LeagueException> exceptions = c.getAccountQueue().connectAll();
        if(exceptions != null) {
            for(LeagueAccount account : exceptions.keySet())
                System.out.println(account + " error: " + exceptions.get(account));
            return null;
        }
        return c;
	}
	
}
