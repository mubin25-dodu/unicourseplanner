import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class adminpanel extends JFrame implements ActionListener, MouseListener {
    JButton adminpanel, planner, curriculum;
    JLabel aiub, coursePlanner, admin, name, code, creditL, pre1, pre2, sec, day1, day2, ct1, ct2, saved;
    JTextField cname, ccode, credit, prereq1, prereq2, sname, sday1, sday2, ctime1, ctime2;
    JButton home, add, addsec, resetsec, reset, cdelete, alldelete,delete;
    JComboBox<String> combo;
    JPanel panel, panel2;
    Color color1, color2;
    ImageIcon img;
    Font font1, font2,font5;
    JTable table;
    depdatas de;
    depdata dp;
    adminlogin al;
    users us;
    login lg;
    user u;

    DefaultTableModel model;
    String path  = "Files/coursedata.txt";
    File  file = new File(path);

// depdatas de, adminlogin al
    public adminpanel(adminlogin al ,depdatas de) {
        super("Admin Panel");
        this.setSize(1920, 1080);
        img = new ImageIcon("aiubpnglogo.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.de = de;
		this.al = al;


        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white
        font1 = new Font(null, Font.BOLD, 13); // button
        font2 = new Font(null, Font.BOLD, 18); // label
        font5 = new Font(null, Font.BOLD, 16); // TextButtons after


        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color1);
        panel.setBounds(0, 0, 1920, 70);



        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.PLAIN, 60));
        aiub.setForeground(Color.WHITE);
        aiub.setBounds(10, 0, 200, 65);
        panel.add(aiub);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.PLAIN, 26));
        coursePlanner.setForeground(Color.WHITE);
        coursePlanner.setBounds(150, 30, 200, 30);
         panel.add(coursePlanner);

         curriculum = new JButton("Curriculum");
         curriculum.setBorderPainted(false);
         curriculum.setFocusPainted(false);
         // curriculum.setContentAreaFilled(false);
         curriculum.setFont(font1);
         curriculum.setForeground(color2);
         curriculum.setBackground(null);
         curriculum.setBounds(450, 35, 130, 30);
         curriculum.addMouseListener(this);
         curriculum.addMouseListener(this);
          // curriculum.setOpaque(true);
  // curriculum.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // CourseData.main(null); // Call the main method of CourseData to display
        // course data
        // }
        // });
        panel.add(curriculum);

        home = new JButton("Home");
        home.setBackground(null);
        home.setForeground(color2);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setFont(font1);
        home.setBounds(900, 35, 130, 30);
        home.addMouseListener(this);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home h = new home(u,us,lg);
                h.setVisible(true);
                h.setLocationRelativeTo(null);
                dispose();
            }
        });
        panel.add(home);

      
        adminpanel = new JButton("Log out");
        adminpanel.setBorderPainted(false);
        adminpanel.setFocusPainted(false);
        // curriculum.setContentAreaFilled(false);
        adminpanel.setFont(font1);
        adminpanel.setForeground(color2);
        adminpanel.setBackground(color1);
        adminpanel.setBounds(1420, 35, 110, 30);
        adminpanel.addMouseListener(this);
        adminpanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminlogin a = new adminlogin();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                dispose();
            }
        });
        panel.add(adminpanel);

        planner = new JButton("Planner");
        planner.setFont(font1);
        planner.setBackground(null);
        planner.setForeground(color2);
        planner.setBounds(700, 35, 110, 30);
        planner.setBorderPainted(false);
        planner.setFocusPainted(false);
        planner.addMouseListener(this);
        panel.add(planner);

        this.add(panel);

       

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(color2);
        panel2.setBounds(0, 70, 1920, 1010);

        admin = new JLabel("Admin Panel");
        admin.setBackground(color2);
        admin.setForeground(color1);
        admin.setBounds(660, 50, 200, 70);
        admin.setFont(new Font(null, Font.BOLD, 20));
        panel2.add(admin);

        name = new JLabel("Course Name");
        name.setBackground(color2);
        name.setForeground(color1);
        name.setBounds(100, 110, 150, 100);
        name.setFont(font2);
        panel2.add(name);

        creditL = new JLabel("Credit");
        creditL.setBackground(color2);
        creditL.setForeground(color1);
        creditL.setBounds(400, 110, 150, 100);
        creditL.setFont(font2);
        panel2.add(creditL);

        code = new JLabel("Course Code");
        code.setBackground(color2);
        code.setForeground(color1);
        code.setBounds(500, 110, 150, 100);
        code.setFont(font2);
        panel2.add(code);

        pre1 = new JLabel("Course prerequsite 1");
        pre1.setBackground(color2);
        pre1.setForeground(color1);
        pre1.setBounds(650, 110, 250, 100);
        pre1.setFont(font2);
        panel2.add(pre1);

        pre2 = new JLabel("Course prerequsite 2");
        pre2.setBackground(color2);
        pre2.setForeground(color1);
        pre2.setBounds(860, 110, 250, 100);
        pre2.setFont(font2);
        panel2.add(pre2);

        // JTextField
        // cname,ccode,credit,prereq1,prereq2,sname,sday1,sday2,ctime1,ctime2;
        cname = new JTextField();
        cname.setBounds(100, 180, 250, 20);
        cname.setFont(font2);
        panel2.add(cname);

        credit = new JTextField();
        credit.setBounds(400, 180, 57, 20);
        credit.setFont(font2);
        panel2.add(credit);

        ccode = new JTextField();
        ccode.setBounds(500, 180, 120, 20);
        ccode.setFont(font2);
        panel2.add(ccode);

        // JTextField
        // cname,ccode,credit,prereq1,prereq2,sname,sday1,sday2,ctime1,ctime2;

        prereq1 = new JTextField();
        prereq1.setBounds(650, 180, 190, 20);
        prereq1.setFont(font2);
        panel2.add(prereq1);

        prereq2 = new JTextField();
        prereq2.setBounds(860, 180, 190, 20);
        prereq2.setFont(font2);
        panel2.add(prereq2);

        // JButton add,reset,cdelete,sdelete;

        // add = new JButton();
        // add = new JButton("Add Course");
        // add.setFont(font1);
        // add.setBackground(color1);
        // add.setForeground(color2);
        // add.setBounds(1100,179,110,25);
        // add.setBorderPainted(false);
        // add.setFocusPainted(false);
        // panel2.add(add);

        reset = new JButton();
        reset = new JButton("Reset");
        reset.setFont(font1);
        reset.setBackground(color1);
        reset.setForeground(color2);
        reset.setBounds(1100, 178, 110, 25);;
     reset.addMouseListener(this);  
      reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            cname.setText("");
            ccode.setText("");
            credit.setText("");
            prereq1.setText("");
            prereq2.setText("");
            }
        });
        panel2.add(reset);

       
        sec = new JLabel("Section");
        sec.setBackground(color2);
        sec.setForeground(color1);
        sec.setBounds(100, 200, 150, 100);
        sec.setFont(font2);
        panel2.add(sec);

        day1 = new JLabel("Day 1");
        day1.setBackground(color2);
        day1.setForeground(color1);
        day1.setBounds(350, 200, 150, 100);
        day1.setFont(font2);
        panel2.add(day1);

        day2 = new JLabel("Day 2");
        day2.setBackground(color2);
        day2.setForeground(color1);
        day2.setBounds(500, 200, 150, 100);
        day2.setFont(font2);
        panel2.add(day2);

        ct1 = new JLabel("class Time 1");
        ct1.setBackground(color2);
        ct1.setForeground(color1);
        ct1.setBounds(650, 200, 250, 100);
        ct1.setFont(font2);
        panel2.add(ct1);

        ct2 = new JLabel("Class Time 2");
        ct2.setBackground(color2);
        ct2.setForeground(color1);
        ct2.setBounds(860, 200, 250, 100);
        ct2.setFont(font2);
        panel2.add(ct2);

        // JTextField
        // cname,ccode,credit,prereq1,prereq2,sname,sday1,sday2,ctime1,ctime2;

        sname = new JTextField();
        sname.setBounds(100, 270, 150, 20);
        sname.setFont(font2);
        panel2.add(sname);

        sday1 = new JTextField();
        sday1.setBounds(350, 270, 77, 20);
        sday1.setFont(font2);
        panel2.add(sday1);

        sday2 = new JTextField();
        sday2.setBounds(500, 270, 80, 20);
        sday2.setFont(font2);
        panel2.add(sday2);

        // JTextField
        // cname,ccode,credit,prereq1,prereq2,sname,sday1,sday2,ctime1,ctime2;

        ctime1 = new JTextField();
        ctime1.setBounds(650, 270, 190, 20);
        ctime1.setFont(font2);
        panel2.add(ctime1);

        ctime2 = new JTextField();
        ctime2.setBounds(860, 270, 190, 20);
        ctime2.setFont(font2);
        panel2.add(ctime2);

        // JButton add,reset,cdelete,sdelete;
        add = new JButton();
        add = new JButton("Add ");
        add.setFont(font1);
        add.setBackground(color1);
        add.setForeground(color2);
        add.setBounds(550, 340, 70, 25);
        add.addMouseListener(this);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cn = cname.getText();
                String cc = ccode.getText();
                String c = credit.getText();
                String p1 = prereq1.getText();
                String p2 = prereq2.getText();
                String sn = sname.getText();
                String d1 = sday1.getText();
                String d2 = sday2.getText();
                String t1 = ctime1.getText();
                String t2 = ctime2.getText();
                String d = combo.getSelectedItem().toString();
                depdata de = new depdata(cn, cc, c, p1, p2, sn, d1, d2, t1, t2, d);
        
                if (!cn.isEmpty() && !cc.isEmpty() && !c.isEmpty() && !d.isEmpty() && !p1.isEmpty() && !p2.isEmpty()
                        && !sn.isEmpty() && !d1.isEmpty() && !d2.isEmpty() && !t1.isEmpty() && !t2.isEmpty()) {
                    depdatas dep = new depdatas(de);
                    if (dep != null) {
                        //refresh the table
                       DefaultTableModel model = (DefaultTableModel) table.getModel();
                tableadminpanel.refreshTable(model, "Files/coursedata.txt");
  
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "Information Missing");
                    cname.setText("");
                }
            }
        });
        
        
        panel2.add(add);

        cdelete = new JButton("Add user");
        cdelete.setFont(font1);
        cdelete.setBackground(color1);
        cdelete.setForeground(color2);
        cdelete.setBounds(630, 340, 150, 25);
        cdelete.setBorderPainted(false);
        cdelete.addMouseListener(this);
        cdelete.setFocusPainted(false);
        cdelete.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                adminsignup l = new adminsignup(us,lg);
                 l.setVisible(true);
                l.setLocationRelativeTo(null);
             }
         
        }); 
                
        panel2.add(cdelete);


        delete = new JButton("delete");
        delete.setFont(font1);
        delete.setBackground(color1);
        delete.setForeground(color2);
        delete.setBounds(750, 340, 150, 25);
        delete.setBorderPainted(false);
        delete.addMouseListener(this);
        delete.setFocusPainted(false);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                tableadminpanel.deleteSelectedRow(model, selectedRow);
                tableadminpanel.saveDataToFile(model, "Files/coursedata.txt");
                JOptionPane.showMessageDialog(null, "Selected row deleted.");
            }
        });

                
        panel2.add(delete);


        // alldelete = new JButton("Refresh");
        // alldelete.setFont(font1);
        // alldelete.setBackground(color1);
        // alldelete.setForeground(color2);
        // alldelete.setBounds(1100,200,110,25);
        // alldelete.addMouseListener(this);
        // alldelete.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
               
        //     }
        // });
        
        // panel2.add(alldelete);

        // JButton add,reset,cdelete,sdelete;
        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 350, 150, 30);
        backButton.setFocusable(false);
        backButton.setBackground(color1);
        backButton.setForeground(color2);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                users us = new users();
                user u = new user();
                login lg = new login(us);
                home h = new home(u, us, lg);
                h.setVisible(true);
            }
        });
        
        panel.add(backButton);
        resetsec = new JButton();
        resetsec = new JButton("Reset");
        resetsec.setFont(font1);
        resetsec.setBackground(color1);
        resetsec.setForeground(color2);
        resetsec.setBounds(1100, 265, 110, 25);
        resetsec.addMouseListener(this);
        resetsec.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            sname.setText("");
            sday1.setText("");
            sday2.setText("");
            ctime1.setText("");
            ctime2.setText("");
             }
         
        });
        panel2.add(resetsec);

        String items[] = { "CSE" };
        combo = new JComboBox<>(items);
        combo.setBounds(450, 340, 60, 20);
        panel2.add(combo);

        saved = new JLabel("Saved Courses");
        saved.setFont(font2);
        saved.setBackground(color2);
        saved.setForeground(color1);
        saved.setBounds(100, 400, 200, 100);
        
        panel2.add(saved);


       
        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        
        table.setBounds(35,500,1280,300);
        table.setBackground(color2);
        table.setGridColor(color1);
        table.setRowHeight(40);
        table.setAutoCreateRowSorter(true);


        String[] columnNames = {"Course Name", "Code", "Credit", "Prerequisite 1", "Prerequisite 2", "Day 1", "Day 2", "Time 1", "Time 2","Department"};
        tableModel.setColumnIdentifiers(columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        table.editCellAt(selectedRow, 0);
                    }
                }
            }
        });

       
   
    
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] rowData = line.split(",");
                    if (rowData.length == 11) {
                        tableModel.addRow(rowData);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
          
    


            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 500, 1300, 300);
            scrollPane.setBackground(color2);
            scrollPane.setAutoscrolls(true);
            panel2.add(scrollPane);
            // panel2.add(table);
        //  JLabel aiub, coursePlanner, admin, name, code, creditL, pre1, pre2, sec, day1, day2, ct1, ct2, saved;


        this.add(panel2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {      
    }
     
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
   }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == add) {
            add.setForeground(color1);
            add.setBackground(color2);

        } else if (e.getSource() == planner) {
            planner.setFont(font5);
        } else if (e.getSource() == curriculum) {
            curriculum.setFont(font5);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font5);
        } else if (e.getSource() == home) {
            home.setFont(font5);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font5);
        } 
        else if (e.getSource() == resetsec) {
             resetsec.setForeground(color1);
             resetsec.setBackground(color2);
            }else if (e.getSource() == reset) {
             reset.setForeground(color1);
             reset.setBackground(color2);
            }else if (e.getSource() == cdelete) {
             cdelete.setForeground(color1);
             cdelete.setBackground(color2);
            }else if (e.getSource() == alldelete) {
             alldelete.setForeground(color1);
             alldelete.setBackground(color2);
            }
    }
        //  JButton home, add, addsec, resetsec, reset, cdelete, alldelete;

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == add) {
            add.setBackground(color1);
            add.setForeground(color2);
        } else if (e.getSource() == planner) {
            planner.setFont(font1);
        } else if (e.getSource() == curriculum) {
            curriculum.setFont(font1);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font1);
        } else if (e.getSource() == home) {
            home.setFont(font1);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font1);
        }
    
     else if (e.getSource() == resetsec) {
             resetsec.setForeground(color2);
             resetsec.setBackground(color1);
            }else if (e.getSource() == reset) {
             reset.setForeground(color2);
             reset.setBackground(color1);
            }else if (e.getSource() == cdelete) {
             cdelete.setForeground(color2);
             cdelete.setBackground(color1);
            }else if (e.getSource() == alldelete) {
             alldelete.setForeground(color2);
             alldelete.setBackground(color1);
            }
        }
      
        }
        
        
   
