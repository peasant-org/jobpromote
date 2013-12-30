/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobimprove.jfxdata.builder;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Administrator
 */
public class TableViewDataBuilder<D> {
    static public void build(TableView tv){
        ObservableList items = tv.getItems();
        constructTableColumns(items);
        
    }
   static public TableColumn[] constructTableColumns(Iterable is){
       for(Object bean:is){
           
       }
        return null;
    }
   static public <B> List<TableColumn> constructTableColumns(B bean,String... properties){
       List<TableColumn> tcs = new java.util.ArrayList();
       TableColumn tc;
       for(String p : properties){
           tc = new TableColumn(p);
          /* tc.setCellFactory(new Callback<TableColumn,TableCell>(){

               @Override
               public TableCell call(TableColumn param) {
                   return null;
               }
           });*/
           
           tc.setCellValueFactory(new PropertyValueFactory(p));
           tcs.add(tc);
       }
       return tcs;
    }
}
