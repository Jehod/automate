/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entity.Formulaire;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author nik
 */
public class ListModelFormulaire extends AbstractListModel
{
    protected ArrayList<String> list;

    public ListModelFormulaire()
    {
        this.list = Formulaire.getInstance().getListFormulaire();
    }
    
    

    @Override
    public int getSize()
    {
       return list.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return list.get(index);
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
    
}
