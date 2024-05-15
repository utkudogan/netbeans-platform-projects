/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.myorg.myeditor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.myorg.myapi.Event;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.actions.Presenter;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bites
 */
public class EventNode extends AbstractNode {

    public EventNode(Event obj) {
        super(Children.create(new EventChildFactory(), true), Lookups.singleton(obj));
        setDisplayName("Event " + obj.getIndex());
    }

    public EventNode() {
        super(Children.create(new EventChildFactory(), true));
        setDisplayName("Root");
    }

    @Override
    public String getHtmlDisplayName() {
        /*
        Event obj = getLookup().lookup(Event.class);
        if ((obj != null) && (obj.getIndex() % 2 != 0)) {
            return "<font color='0000FF'>Event " + obj.getIndex() + "</font>";
        } else {
            return null;
        }
         */

 /*
        Event obj = getLookup().lookup(Event.class);
        if (obj != null) {
            return "<font color='#0000FF'>Event " + obj.getIndex() + "</font>"
                    + " <font color='AAAAAA'><i>" + obj.getDate() + "</i></font>";
        } else {
            return null;
        }
         */
        Event obj = getLookup().lookup(Event.class);
        if (obj != null) {
            return "<font color='!textText'>Event " + obj.getIndex() + "</font>"
                    + " <font color='!controlShadow'><i>" + obj.getDate() + "</i></font>";
        } else {
            return null;
        }
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/myorg/myeditor/nodesapi2_icon.png");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    @Override
    public Action[] getActions(boolean popup) {
        return new Action[]{new MyAction(), new MyAction2()};
    }

    private class MyAction extends AbstractAction {

        public MyAction() {
            putValue(NAME, "Do Something");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Event obj = getLookup().lookup(Event.class);
            JOptionPane.showMessageDialog(null, "Hello from " + obj);
        }
    }

    private class MyAction2 extends AbstractAction implements Presenter.Popup {

        public MyAction2() {
            putValue(NAME, "Do Something");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Event obj = getLookup().lookup(Event.class);
            JOptionPane.showMessageDialog(null, "Hello from " + obj);
        }

        @Override
        public JMenuItem getPopupPresenter() {
            JMenu result = new JMenu("Submenu");  //remember JMenu is a subclass of JMenuItem
            result.add(new JMenuItem(this));
            result.add(new JMenuItem(this));
            return result;
        }
    }
}
