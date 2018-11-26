/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entity.Methode;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author nrochas
 */
public class ListModelFDEF extends AbstractListModel {

    protected ArrayList<String> list;

    public ListModelFDEF()
        {
        list = Methode.getInstance().getListFDEF();
       
        }

    public void add(String pa)
        {
        if (!list.contains(pa)) {
            this.list.add(pa);
            fireIntervalAdded(this.list, this.list.size() - 1, this.list.size() - 1);
        }
        }

    public void remove(String pa)
        {
        int i = 0;
        while (!this.list.get(i).equals(pa) || i>list.size())
        {
            i++;
        }
        this.list.remove(i);
        fireIntervalRemoved(this.list, i, i);
        }

    @Override
    public String getElementAt(int i)
        {
        return this.list.get(i);
        }

    @Override
    public int getSize()
        {
        int z = 0;
        if (this.list != null) {
            z = this.list.size();
        }
        return z;
        }

}
