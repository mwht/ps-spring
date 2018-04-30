package pl.madejspace.postudencku.dao;

import pl.madejspace.postudencku.MenuEntry;

import java.awt.*;

public interface MenuEntryDAO {
    public void insert(MenuEntry menuEntry);
    public MenuEntry findById(int id);
}
