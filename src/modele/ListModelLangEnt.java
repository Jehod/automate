/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entity.Pays;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author nrochas
 */
public class ListModelLangEnt extends AbstractListModel {

    protected  List list;//ArrayList<String> list;

    public ListModelLangEnt()
        {
        this.list = Pays.getInstance().getList();
           
        
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
        while (!this.list.get(i).equals(pa)) {
            i++;
        }
        this.list.remove(i);
        fireIntervalRemoved(this.list, i, i);
        }

    @Override
    public String getElementAt(int i)
        {
        return (String) this.list.get(i);
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

    @Override
    protected void fireIntervalRemoved(Object source, int index0, int index1)
    {
        super.fireIntervalRemoved(source, index0, index1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void fireIntervalAdded(Object source, int index0, int index1)
    {
        super.fireIntervalAdded(source, index0, index1); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
