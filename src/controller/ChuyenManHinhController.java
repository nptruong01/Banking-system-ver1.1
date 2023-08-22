/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import danhmuc.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ChucNang.Customer;
import system.ChucNangJPanel1;
import system.CustomerJPanel;
import system.LichSuJPanel;
import system.QuanLyJPanel;
import ChucNang.account;

/**
 *
 * @author MSI-VN
 */
public class ChuyenManHinhController {
    
    private JPanel root;
    private String kindSelected ="";
    private List<DanhMucBean> listDanhMuc;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem,JLabel jlbItem){
        kindSelected ="Customer";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new CustomerJPanel());
        root.validate();
        root.repaint();
    } 
    public void setEvent(List<DanhMucBean> listDanhMuc) {
     this.listDanhMuc = listDanhMuc;
     for (DanhMucBean item : listDanhMuc) {
           item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
     }
}


class LabelEvent implements MouseListener {

      private JPanel node;
      private String kind;

      private JPanel jpnItem;
      private JLabel jlbItem;

      public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
           this.kind = kind;
           this.jpnItem = jpnItem;
           this.jlbItem = jlbItem;
      }

      @Override
      public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Customer":
                    node = new CustomerJPanel();
                    break;
                case "ChucNang":
                    node = new ChucNangJPanel1();
                    break;
                case "LichSu":
                    node = new LichSuJPanel();
                    break;
                case "QuanLy":
                    node = new QuanLyJPanel();
                    break;
//                 more
                default:
                    break;
           }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackgroud(kind);
      }

      @Override
      public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(96, 100, 191));
           jlbItem.setBackground(new Color(96, 100, 191));
      }

      @Override
      public void mouseReleased(MouseEvent e) {
//          if (!kindSelected.equalsIgnoreCase(kind)) {
//                jpnItem.setBackground(new Color(255,204,204));
//                jlbItem.setBackground(new Color(255,204,204));
//          }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
          jpnItem.setBackground(new Color(76, 175 ,80));
          jlbItem.setBackground(new Color(76, 175 ,80));
      }

      @Override
      public void mouseExited(MouseEvent e) {
          if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255,204,204));
                jlbItem.setBackground(new Color(255,204,204));
          }
      }

//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }

}
      private void setChangeBackgroud(String kind){
          for(DanhMucBean item : listDanhMuc){
              if(item.getKind().equalsIgnoreCase(kind)){
                  item.getJpn().setBackground(new Color(76, 175 ,80));
                  item.getJlb().setBackground(new Color(76, 175 ,80));
              }else{
                  item.getJpn().setBackground(new Color(255,204,204));
                  item.getJlb().setBackground(new Color(255,204,204));
              }
          }
      }
}

