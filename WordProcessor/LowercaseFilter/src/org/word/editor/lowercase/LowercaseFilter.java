package org.word.editor.lowercase;


import org.openide.util.lookup.ServiceProvider;
import org.word.editor.api.WordFilter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bites
 */
@ServiceProvider(service = WordFilter.class)
public class LowercaseFilter implements WordFilter {

    @Override
    public String process(String s) {
        return s.toLowerCase();
    }
    
}
