package com.vladbel.usermanagment.gui;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.vladbel.usermanagment.User;
import com.vladbel.usermanagment.util.Messages;

public class UserTableModel extends AbstractTableModel {

	private static final String[] COLUMN_NAMES = {Messages.getString("UserTableModel.ID"), Messages.getString("UserTableModel.First_name"),Messages.getString("UserTableModel.Last_name"), Messages.getString("UserTableModel.DateofBirth"),Messages.getString("UserTableModel.Age")};  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	private static final Class[] COLUMN_CLASSES = {Long.class,String.class,String.class,Date.class,Long.class};
	private List users = null;

    
    public UserTableModel(Collection users) {
        this.users = new ArrayList(users);
    }
	
    public int getRowCount() {
        return users.size();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public Class getColumnClass(int columnIndex) {
        return COLUMN_CLASSES[columnIndex];
    }

    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    public User getUser(int index) {
        return (User) users.get(index);
    }
    
    public void addUsers(Collection users) {
        this.users.addAll(users);
    }
    
    public void clearUsers() {
        this.users = new ArrayList();
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = (User) users.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return user.getId();
        case 1:
            return user.getFirstName();
        case 2:
            return user.getLastname();
        }
        return null;
    }

}

