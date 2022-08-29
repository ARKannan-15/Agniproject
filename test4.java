import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class SFrame 
{
    public class Employee
    {
        public String Designation,Department,Name;
        public double Salary;
        public ArrayList<Employee>Employee_list = new ArrayList<Employee>();

        public void getdata(Employee e)
        {
            //salary calcualtion has been performed when button is clicked 
            Employee_list.add(e);
        }
    }
    
    SFrame()
    {
        JFrame f=new JFrame("ABC SUGAR FACTORY");
        JLabel desig,dept,emp_details,salary;
        JTextField tf,tf1,tf2,tf3,tf4;
        JTextArea ta1=new JTextArea();
        JButton submit=new JButton("Submit ");
        JButton details=new JButton("Details");

        JLabel title=new JLabel("Salary Management Form by Keerthi Yaghash");
        title.setBounds(250,5,350,30);
        f.add(title);

        desig=new JLabel("Designation");
        desig.setBounds(10,40,150,40);
        f.add(desig);
        tf =new JTextField();
        tf.setBounds(150,50,120,20); 
        f.add(tf);

        dept=new JLabel("Department");
        dept.setBounds(10,90,150,40);
        f.add(dept);
        tf1 =new JTextField();
        tf1.setBounds(150,100,120,20);
        f.add(tf1);

        salary=new JLabel("Salary");
        salary.setBounds(10,140,150,40);
        f.add(salary);
        tf2 =new JTextField();
        tf2.setBounds(150,150,120,20);
        f.add(tf2);

        emp_details=new JLabel("Employee Details");
        emp_details.setBounds(350,210,150,40);
        f.add(emp_details);

        ta1.setBounds(150,250,500,200);
        f.add(ta1);

        submit.setBounds(460,50,150,20);
        f.add(submit);
        submit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {   
                
                String desig_temp = tf.getText();
                String dept_temp = tf1.getText();
                double salary_temp = Integer.parseInt(tf2.getText());

                String m = "Manager";
                String a = "Accountant";
                String c = "Clerk";

                if(desig_temp == m)
                {
                    salary_temp = 0.2*salary_temp + 0.25*salary_temp + salary_temp;
                }
                else if(desig_temp == a)
                {
                    salary_temp = 0.1*salary_temp + 0.15*salary_temp + salary_temp;
                }
                else
                {
                    salary_temp = 0.1*salary_temp + 0.1*salary_temp + salary_temp;
                }

                Employee f = new Employee();
                f.Designation  = desig_temp;
                f.Department = dept_temp;
                f.Salary = salary_temp;
                f.getdata(f);
                ta1.append("\nDetails have been stored");
                ta1.append("\nGross Salary for this employee : " +salary_temp); 
            }
        });

        details.setBounds(460,100,150,20);
        f.add(details);
        details.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {   
                ta1.append("\nDetails of all employees");
                Employee f = new Employee();
                for (int i = 0; i < f.Employee_list.size(); i++)
                    System.out.print(f.Employee_list.get(i) + " ");

            }
        });

        f.setSize(800,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        new SFrame();
    }
}