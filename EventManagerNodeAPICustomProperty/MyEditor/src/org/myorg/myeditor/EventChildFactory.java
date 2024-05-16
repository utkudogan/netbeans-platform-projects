/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.myorg.myeditor;

import java.util.Arrays;
import java.util.List;
import org.myorg.myapi.Event;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bites
 */
public class EventChildFactory extends ChildFactory<Event> {

    @Override
    protected boolean createKeys(List<Event> list) {
        Event[] objs = new Event[5];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Event();
        }
        list.addAll(Arrays.asList(objs));
        return true;
    }

    @Override
    protected Node createNodeForKey(Event key) {
        return new EventNode(key);
    }

}
