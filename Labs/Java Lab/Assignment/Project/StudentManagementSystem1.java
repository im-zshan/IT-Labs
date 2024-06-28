import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Student 
{
    private String name;
    private String rollNumber;
    private String course;
    private int marks;

    public Student(String name, String rollNumber, String course, int marks) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.marks = marks;
    }

    public String toString()
    {
        return name+" "+rollNumber+" "+course+" "+marks;
    }
    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class StudentManagementSystem1 extends JFrame 
{
    private ArrayList<Student> students;
    private DefaultTableModel tableModel;
    private JTextField nameField, rollNumberField, courseField, marksField;
    private JButton addButton, viewButton, searchButton, updateButton, deleteButton, reportButton;

    public StudentManagementSystem1() 
    {
        students = new ArrayList<>();
        fillStudents();
        //initializeComponents();
        createGUI();
        registerListeners();
    }
    private void fillStudents()
    {
        try 
        {
            File myObj = new File("student.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) 
            {
                String data = myReader.nextLine();
                System.out.println(data);
                if(data.length()>0)
                {
                    String[] str = data.split("\\s+");
                    Student st=new Student(str[0], str[1], str[2], Integer.parseInt(str[3]));
                    students.add(st);
                }
                
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void createGUI() 
    {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Roll Number");
        tableModel.addColumn("Course");
        tableModel.addColumn("Total Marks(out of 100)");

        nameField = new JTextField();
        rollNumberField = new JTextField();
        courseField = new JTextField();
        marksField = new JTextField();

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        searchButton = new JButton("Search");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        reportButton = new JButton("Report of Student");

        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Roll Number:"));
        inputPanel.add(rollNumberField);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(reportButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(new JTable(tableModel)), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void registerListeners() 
    {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                report();
            }
        });
    }

    private void add() 
    {    
        // Validate input here
        if (nameField.getText().isEmpty() || rollNumberField.getText().isEmpty() || courseField.getText().isEmpty() || marksField.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //if marks entered are more than 100
        if (Integer.parseInt(marksField.getText())>100) 
        {
            JOptionPane.showMessageDialog(this, "Entered Marks cannot greater than 100", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = nameField.getText();
        String rollNum = rollNumberField.getText();
        String course = courseField.getText();
        int marks = Integer.parseInt(marksField.getText());

        for (int i = 0; i < students.size(); i++) 
        {

            Student student = students.get(i);

            if (student.getRollNumber().equalsIgnoreCase(rollNum) && student.getCourse().equalsIgnoreCase(course)) 
            {
                JOptionPane.showMessageDialog(this, "Ambiguity: Roll number and the entered subject existed in record", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (student.getRollNumber().equalsIgnoreCase(rollNum) && !(student.getName().equalsIgnoreCase(name))) 
            {
                JOptionPane.showMessageDialog(this, "Roll number existed in records but Name isn't correctly entered", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Student student = new Student(name, rollNum, course, marks);
        students.add(student);
        tableModel.addRow(new Object[]{name, rollNum, course, marks});

        try 
        {
            BufferedWriter writer = new BufferedWriter( new FileWriter("student.txt",true));
            writer.write(student.toString()+"\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        clearFields();
    }

    private void view() 
    {
        clearTable();
        for (Student student : students) 
        {
            tableModel.addRow(new Object[]{student.getName(), student.getRollNumber(), student.getCourse(), student.getMarks()});
        }
        
    }


    private void search() 
    {
        String searchTerm = JOptionPane.showInputDialog(this, "Enter roll number or name to search:");
        if (searchTerm == null || searchTerm.isEmpty()) {
            return;
        }


        for (Student student : students) 
        {
            if (student.getRollNumber().equalsIgnoreCase(searchTerm) || student.getName().equalsIgnoreCase(searchTerm)) 
            {
                clearTable();
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{student.getName(), student.getRollNumber(), student.getCourse(), student.getMarks()});
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student Not found", "Error", JOptionPane.ERROR_MESSAGE);
            
    }

    private void update() 
    {
    
        String searchTerm = JOptionPane.showInputDialog(this, "Enter roll number or name to search:");
        if (searchTerm == null || searchTerm.isEmpty()) {
            return;
        }

        boolean found=false;
        String name=JOptionPane.showInputDialog(this, "Enter name to update or (don't write for no changes)");
                    
                    
        String roll=JOptionPane.showInputDialog(this, "Enter Roll Number to update or (don't write for no changes)");
                    

        String course=JOptionPane.showInputDialog(this, "Enter course name to update or (don't write for no changes)");
                    
                    
        String marks=JOptionPane.showInputDialog(this, "Enter marks to update or (don't write for no changes)");
                    
        
            for (int i = 0; i < students.size(); i++) 
            {
                Student student = students.get(i);
                if (student.getRollNumber().equalsIgnoreCase(searchTerm) || student.getName().equalsIgnoreCase(searchTerm)) 
                {
                    found=true;
                    
                    if(!name.isBlank())
                    {
                        student.setName(name);
                    }
                    else if(!roll.isBlank())
                    {
                        student.setRollNumber(roll);
                    }
                    else if(!course.isBlank())
                    {
                        student.setCourse(course);
                    }
                    else if(!marks.isBlank())
                    {
                        student.setMarks(Integer.parseInt(marks));
                    }

                    tableModel.setValueAt(student.getName(), i, 0);
                    tableModel.setValueAt(student.getCourse(), i, 2);
                    tableModel.setValueAt(student.getMarks(), i, 3);
                    clearFields();
                }
            }
            if(!found)
            {
                JOptionPane.showMessageDialog(this, "Student not found!");
                return;
            }
                
            writeBackTofile();
        
            
    }
    
    private void writeBackTofile()
    {
        try 
        {
            BufferedWriter writer = new BufferedWriter( new FileWriter("student.txt"));
            for(Student st:students)
            {
                
                    writer.write(st.toString()+"\n");
                    
                
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void delete() 
    {
        String searchTerm = JOptionPane.showInputDialog(this, "Enter roll number or name to search:");

        if (searchTerm == null || searchTerm.isEmpty()) {
            return;
        }

            for (int i = 0; i < students.size(); i++) 
            {

                Student student = students.get(i);
                if (student.getRollNumber().equalsIgnoreCase(searchTerm) || student.getName().equalsIgnoreCase(searchTerm)) 
                {
                    //Student st=new Student(str[0], str[1], str[2], Integer.parseInt(str[3]));

                    students.remove(i);
                    writeBackTofile();
                    
                    tableModel.removeRow(i);
                    clearFields();
                    return;
                }
            }
            

        JOptionPane.showMessageDialog(this, "Student not found!");
    }

    private void report() 
    {

        String searchTerm = JOptionPane.showInputDialog(this, "Enter roll number:");
        if (searchTerm == null || searchTerm.isEmpty()) {
            return;
        }

        boolean found=false;
        String name="";
        int totalMarks = 0;
        int max = Integer.MIN_VALUE; // highest marks
        int min = Integer.MAX_VALUE; // lowest marks
        ArrayList<String> subjects=new ArrayList<>();
        ArrayList<String> passingSubject=new ArrayList<>();

        for (int i = 0; i < students.size(); i++) 
        {

            Student student = students.get(i);
            
            if (student.getRollNumber().equalsIgnoreCase(searchTerm)) 
            {
                found=true;
                name=student.getName();

                int marks = student.getMarks();
                
                totalMarks += marks;

                max=Math.max(max, marks);

                min=Math.min(min, marks);

                if (marks >= 40) 
                {
                    passingSubject.add(student.getCourse());
                }
                subjects.add(student.getCourse());
            }
        }
            
        if(!found)
        {
            JOptionPane.showMessageDialog(this, "Student not found!");
            return;
        }


        double averageMarks = (double) totalMarks / subjects.size();
        double percentage = (double) totalMarks / (subjects.size()*100);
        percentage*=100;

        String statistics = "Name: " + name + "\n"
                +"Roll Number: " + searchTerm + "\n"
                +"Average Marks in each subject: " + averageMarks + "\n"
                +"Percentage : " + percentage + "\n"
                + "Highest Marks: " + max + "\n"
                + "Lowest Marks: " + min + "\n"
                + "Total Subjects: " + subjects.toString() + "\n"
                + "Passed Subjects: " +  passingSubject.toString();

        JOptionPane.showMessageDialog(this, statistics);
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        courseField.setText("");
        marksField.setText("");
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) 
    {

        new StudentManagementSystem1().setVisible(true);
    }
}

