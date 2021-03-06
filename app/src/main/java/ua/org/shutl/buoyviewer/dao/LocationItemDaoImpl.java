package ua.org.shutl.buoyviewer.dao;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import ua.org.shutl.buoyviewer.model.LocationItem;
import ua.org.shutl.buoyviewer.model.LocationItem_Table;

/**
 * Created by shutl on 07.01.16.
 */
public class LocationItemDaoImpl extends LocationItemDao {

    @Override
    public List<LocationItem> getLocationItemsRootList() {
        return SQLite.select().from(LocationItem.class)
                .where(LocationItem_Table.parentId.eq(-1)).queryList();
    }

    @Override
    public List<LocationItem> getLocationItemsListByParentId(long parentId) {
        return SQLite.select().from(LocationItem.class)
                .where(LocationItem_Table.parentId.eq(parentId)).queryList();
    }

    @Override
    public void saveLocationItems(LocationItem[] items) {
        if (items != null) {
            for (LocationItem item : items) {
                item.save();
                saveLocationItems(item.getLocationItems());
            }
        }
    }
}
