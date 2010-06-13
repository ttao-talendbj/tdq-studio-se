// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.cwm.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.talend.cwm.relational.TdColumn;
import org.talend.cwm.relational.TdTable;
import orgomg.cwm.objectmodel.core.ModelElement;
import orgomg.cwm.objectmodel.core.Namespace;
import orgomg.cwm.objectmodel.core.Package;
import orgomg.cwm.objectmodel.core.StructuralFeature;
import orgomg.cwm.resource.relational.Column;
import orgomg.cwm.resource.relational.ColumnSet;
import orgomg.cwm.resource.relational.ForeignKey;
import orgomg.cwm.resource.relational.PrimaryKey;
import orgomg.cwm.resource.relational.Table;

/**
 * @author scorreia
 * 
 * Helper for Table class.
 */
public final class TableHelper {

    private TableHelper() {
    }

    /**
     * Method "getTables" extracts the tables from the list.
     * 
     * @param elements any elements that could contain TdTables
     * @return the list of TdTables found in the given list (never null, but can be empty).
     */
    public static List<TdTable> getTables(Collection<? extends EObject> elements) {
        List<TdTable> tables = new ArrayList<TdTable>();
        for (EObject elt : elements) {
            TdTable table = SwitchHelpers.TABLE_SWITCH.doSwitch(elt);
            if (table != null) {
                tables.add(table);
            }
        }
        return tables;
    }

    /**
     * Method "getColumns" returns the columns of a table.
     * 
     * @param table a table
     * @return the list of TdColumn contained in the table
     */
    public static List<TdColumn> getColumns(TdTable table) {
        return ColumnHelper.getColumns(table.getFeature());
    }

    /**
     * Method "addColumns".
     * 
     * @param table the table in which to add the columns (must not be null)
     * @param columns the columns to add (must not be null)
     * @return true if the content of the table changed as a result of the call.
     */
    public static boolean addColumns(TdTable table, Collection<TdColumn> columns) {
        return ColumnSetHelper.addColumns(table, columns);
    }

    /**
     * Method "addColumn" adds a column to the given table.
     * 
     * @param table the table in which the column is added (must not be null)
     * @param column the column to add (must not be null)
     * @return true if the content of the table changed as a result of the call.
     */
    public static boolean addColumn(TdTable table, TdColumn column) {
        assert table != null;
        assert column != null;
        return table.getFeature().add(column);
    }

    /**
     * Method "getParentTable".
     * 
     * @param column a column
     * @return the table containing this column or null
     */
    public static Table getParentTable(Column column) {
        TdTable table = SwitchHelpers.TABLE_SWITCH.doSwitch(column.getOwner());
        return table;
    }

    /**
     * Method "addPrimaryKey".
     * 
     * @param table
     * @param pk the primary key of the table
     */
    public static PrimaryKey addPrimaryKey(Table table, PrimaryKey pk) {
        assert table != null;
        assert pk != null;
        List<PrimaryKey> primaryKeyList = getPrimaryKeys(table);
        // MOD zshen for bug 12842
        String newPrimaryKeyName = pk.getName();
        for (PrimaryKey thePrimaryKey : primaryKeyList) {
            if (thePrimaryKey.getName().equals(newPrimaryKeyName)) {
                thePrimaryKey.getFeature().addAll(thePrimaryKey.getFeature());
                StructuralFeature[] structuralFeaturethe = thePrimaryKey.getFeature().toArray(
                        new StructuralFeature[thePrimaryKey.getFeature().size()]);
                for (StructuralFeature primaryKeyColumn : structuralFeaturethe) {
                    TdColumn theColumn = (TdColumn) (primaryKeyColumn);
                    theColumn.getUniqueKey().clear();
                    theColumn.getUniqueKey().add(thePrimaryKey);
                }
                return thePrimaryKey;
            }
        }
        table.getOwnedElement().add(pk);
        return pk;
    }

    /**
     * Method "removePrimaryKey".
     * 
     * @param table
     * @param primaryKey
     * @return true if the PK existed in the table
     */
    public static boolean removePrimaryKey(ColumnSet table, PrimaryKey primaryKey) {
        assert table != null;
        assert primaryKey != null;
        return table.getOwnedElement().remove(primaryKey);
    }

    /**
     * Method "removeForeignKey".
     * 
     * @param table
     * @param foreignKey
     * @return true if the FK existed in the table
     */
    public static boolean removeForeignKey(ColumnSet table, ForeignKey foreignKey) {
        assert table != null;
        assert foreignKey != null;
        return table.getOwnedElement().remove(foreignKey);
    }

    /**
     * Method "addAllPrimaryKeys".
     * 
     * @param table
     * @param primaryKeys the primary keys of the table.
     */
    public static void addPrimaryKeys(ColumnSet table, List<PrimaryKey> primaryKeys) {
        assert table != null;
        assert primaryKeys != null;
        for (PrimaryKey primaryKey : primaryKeys) {
            addPrimaryKey((Table) table, primaryKey);
        }

    }

    /**
     * Method "addForeignKey".
     * 
     * @param table
     * @param foreignKey the foreign key of the given table
     */
    public static ForeignKey addForeignKey(ColumnSet table, ForeignKey foreignKey) {
        assert table != null;
        assert foreignKey != null;
        List<ForeignKey> foreignKeyList = getForeignKeys((Table) table);
        // if (foreignKeyList.size() <= 0) {
        // table.getOwnedElement().add(foreignKey);
        // return foreignKey;
        // } else {
        // if (foreignKey.getFeature().size() > 0) {
        String newForeignKeyName = foreignKey.getName();
        for (ForeignKey theForeignKey : foreignKeyList) {
            if (theForeignKey.getName().equals(newForeignKeyName)) {
                theForeignKey.getFeature().addAll(foreignKey.getFeature());
                StructuralFeature[] structuralFeaturethe = theForeignKey.getFeature().toArray(
                        new StructuralFeature[theForeignKey.getFeature().size()]);
                for (StructuralFeature foreignKeyColumn : structuralFeaturethe) {
                    TdColumn theColumn = (TdColumn) (foreignKeyColumn);
                    theColumn.getKeyRelationship().remove(foreignKey);
                    theColumn.getKeyRelationship().add(theForeignKey);
                }
                return theForeignKey;
            }
        }
        table.getOwnedElement().add(foreignKey);
        // foreignKeyList.get(0).getFeature().add(foreignKey.getFeature().get(foreignKey.getFeature().size() -
        // 1));
        // }
        return foreignKey;
        // }
    }

    /**
     * Method "addForeignKeys".
     * 
     * @param table
     * @param foreignKeys the foreign keys of this table
     */
    public static void addForeignKeys(ColumnSet table, List<ForeignKey> foreignKeys) {
        assert table != null;
        assert foreignKeys != null;
        for (ForeignKey foreignKey : foreignKeys) {
            addForeignKey((Table) table, foreignKey);
        }

    }

    /**
     * Method "getPrimaryKeys".
     * 
     * @param table a table
     * @return a list of all primary keys of the given table
     */
    public static List<PrimaryKey> getPrimaryKeys(Table table) {
        List<PrimaryKey> primarykeys = new ArrayList<PrimaryKey>();
        EList<ModelElement> ownedElements = table.getOwnedElement();
        for (ModelElement modelElement : ownedElements) {
            PrimaryKey pk = SwitchHelpers.PRIMARY_KEY_SWITCH.doSwitch(modelElement);
            if (pk != null) {
                primarykeys.add(pk);
            }
        }
        return primarykeys;
    }

    /**
     * Method "getForeignKeys".
     * 
     * @param table a table
     * @return a list of all foreign keys of the given table
     */
    public static List<ForeignKey> getForeignKeys(Table table) {
        List<ForeignKey> foreignkeys = new ArrayList<ForeignKey>();
        EList<ModelElement> ownedElements = table.getOwnedElement();
        for (ModelElement modelElement : ownedElements) {
            ForeignKey pk = SwitchHelpers.FOREIGN_KEY_SWITCH.doSwitch(modelElement);
            if (pk != null) {
                foreignkeys.add(pk);
            }
        }
        return foreignkeys;
    }

    public static Map<String, Integer> getForeignKeysInformation(Table table) {
        Map<String, Integer> info = new HashMap<String, Integer>();

        for (ForeignKey foreign : getForeignKeys(table)) {
            info.put(foreign.getName(), foreign.getFeature().size());

        }
        return info;
    }

    /**
     * Method "getParentCatalogOrSchema" returns the owner of the element (Catalog or Schema).
     * 
     * @param element (can be null)
     * @return the Catalog or of Schema or null
     */
    public static Package getParentCatalogOrSchema(ModelElement element) {
        if (element == null) {
            return null;
        }
        Namespace namespace = element.getNamespace();
        return PackageHelper.getCatalogOrSchema(namespace);
    }

}
