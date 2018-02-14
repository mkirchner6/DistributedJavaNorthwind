/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mjk.week4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mattkirchner
 */
public class NameService {
    
    private List<Name> nameList = Arrays.asList(
            new Name("1", "Matt", "Kirchner", new Address("123 Main", "Milwaukee", "WI", "12345")),
            new Name("2", "Bob", "Smith", new Address("145 Main", "Milwaukee", "WI", "17845"))
    );
    
    public Name getName(String id){
        Name answer = null;
        
        for (Name name: nameList){
            if (name.getId().equals(id)){
                answer = name;
            }
        }
        return answer;
    }
    
    public List<Name> getAllNames(){
        return nameList;
    }
    
    public List<Name> findNames(String search){
        search = search.toLowerCase();
        
        List<Name> answer = new ArrayList<>();        
        for (Name name: answer){
            if (name.getFirst().toLowerCase().startsWith(search) || 
                    name.getLast().toLowerCase().startsWith(search)){
                answer.add(name);
            }
        }
        return answer;
    }
}
