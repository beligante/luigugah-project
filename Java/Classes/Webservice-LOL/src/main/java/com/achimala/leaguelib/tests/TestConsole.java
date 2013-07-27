/*
 *  This file is part of LeagueLib.
 *  LeagueLib is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  LeagueLib is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with LeagueLib.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.achimala.leaguelib.tests;

// import com.achimala.leaguelib.connection.*;
// import com.achimala.leaguelib.models.*;
import com.gvaneyck.rtmp.*;
import java.io.*;
import java.util.*;

import com.google.gson.*;

public class TestConsole {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Personagem p = new Personagem();
        
        p.setIdade(10);
        p.setNome("Luis");
        p.setSobrenome("Beligante");
        
        List lista = new ArrayList<Personagem>();
        
        lista.add(p);
        
        p.setIdade(10);
        p.setNome("Gustavo");
        p.setSobrenome("Beligante");
        
        lista.add(p);
        
        String json = gson.toJson(lista);
        
        System.out.println(json);
    }
}