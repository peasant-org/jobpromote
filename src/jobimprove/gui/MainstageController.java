/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobimprove.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import jobimprove.model.StationInfoJpaController;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class MainstageController implements Initializable {
    @FXML
    private TreeView stationTree;
    @FXML
    private TableView stationInfoTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stationTree.setRoot(createNode(new File("E:\\")));
        stationTree.setEditable(true);
        stationInfoTable.getColumns().setAll(jobimprove.jfxdata.builder.TableViewDataBuilder.constructTableColumns(null, new String[]{"stationInfoId","所属机房安装点名称"}));
        StationInfoJpaController sijc = new StationInfoJpaController(jobimprove.JobimproveApp.emf);
        stationInfoTable.setItems(FXCollections.observableList(sijc.findStationInfoEntities()));
    }
      private TreeItem<File> createNode(final File f) {
      return new TreeItem<File>(f) {
          // We cache whether the File is a leaf or not. A File is a leaf if
          // it is not a directory and does not have any files contained within
          // it. We cache this as isLeaf() is called often, and doing the 
          // actual check on File is expensive.
          private boolean isLeaf;
 
          // We do the children and leaf testing only once, and then set these
          // booleans to false so that we do not check again during this
          // run. A more complete implementation may need to handle more 
          // dynamic file system situations (such as where a folder has files
          // added after the TreeView is shown). Again, this is left as an
          // exercise for the reader.
          private boolean isFirstTimeChildren = true;
          private boolean isFirstTimeLeaf = true;
           
          @Override public ObservableList<TreeItem<File>> getChildren() {
              if (isFirstTimeChildren) {
                  isFirstTimeChildren = false;
 
                  // First getChildren() call, so we actually go off and 
                  // determine the children of the File contained in this TreeItem.
                  super.getChildren().setAll(buildChildren(this));
              }
              return super.getChildren();
          }

          @Override public boolean isLeaf() {
              if (isFirstTimeLeaf) {
                  isFirstTimeLeaf = false;
                  File f = (File) getValue();
                  isLeaf = f.isFile();
              }

              return isLeaf;
          }
 
          private ObservableList<TreeItem<File>> buildChildren(TreeItem<File> TreeItem) {
              File f = TreeItem.getValue();
              if (f != null && f.isDirectory()) {
                  File[] files = f.listFiles();
                  if (files != null) {
                      ObservableList<TreeItem<File>> children = FXCollections.observableArrayList();

                      for (File childFile : files) {
                          children.add(createNode(childFile));
                      }

                      return children;
                  }
              }

              return FXCollections.emptyObservableList();
          }
      };
}
}
