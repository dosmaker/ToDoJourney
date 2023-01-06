import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.io.Serializable;

public class ToDoList implements Serializable{
    private String name = null;
    private List toDoThings = new List();
    private int toDoLenght = 0, monthLenght;
    private Month month;
    private boolean[] array1 = null;
    private boolean[] array2 = null;
    private boolean[] array3 = null;
    private boolean[] array4 = null;
    private boolean[] array5 = null;
    private int[] arrayTot = null;

    public ToDoList(String name){
        this.name = name;

        LocalDate currentDate = LocalDate.now();
        month = currentDate.getMonth();
        switch(month){
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                monthLenght = 31;
            break;
            case FEBRUARY:
                if(currentDate.isLeapYear()){ monthLenght = 29; }else{ monthLenght = 28; }
            break;
            default:
                monthLenght = 30;
            break;
        }
    }

    public void insertToDo(String str){
        toDoThings.Insert(str);
        toDoLenght++;
    }

    public String getThing(int x){
        return toDoThings.ListSearch(x);
    }

    public String getName(){
        return name;
    }

    public int getThingsNumber(){
        return toDoLenght;
    }

    public int[] getArrayTot(){
        return arrayTot;
    }
    
    public void init(){
        LocalDate currentDate = LocalDate.now();
        month = currentDate.getMonth();
        
        switch(month){
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                monthLenght = 31;
            break;
            case FEBRUARY:
                if(currentDate.isLeapYear()){ monthLenght = 29; }else{ monthLenght = 28; }
            break;
            default:
                monthLenght = 30;
            break;
        }

        array1 = new boolean[monthLenght]; array2 = new boolean[monthLenght];
        array3 = new boolean[monthLenght]; array4 = new boolean[monthLenght]; array5 = new boolean[monthLenght];
        initArray(array1); initArray(array2); initArray(array3); initArray(array4); initArray(array5);
        arrayTot = new int[monthLenght]; updateTot();
        
        try{
            FileOutputStream fos = new FileOutputStream(currentDate.getMonth()+""+currentDate.getYear()+".TDGraph");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            
            oos.close();
            fos.close();
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        }
    }

    private void initArray(boolean[] array){
        for(int i = 0; i < monthLenght; i++){
            array[i] = false;
        }
    }

    public void trueBool(int y, int x){
        switch(y){
            case 1:
                array1[x] = true;
            break;

            case 2:
                array2[x] = true;
            break;

            case 3:
                array3[x] = true;
            break;

            case 4:
                array4[x] = true;
            break;

            case 5:
                array5[x] = true;
            break;
        }
        updateTot();
        save();
    }

    public void falseBool(int y, int x){
        switch(y){
            case 1:
                array1[x] = false;
            break;

            case 2:
                array2[x] = false;
            break;

            case 3:
                array3[x] = false;
            break;

            case 4:
                array4[x] = false;
            break;

            case 5:
                array5[x] = false;
            break;
        }
        updateTot();
        save();
    }

    public boolean getBool(int y, int x){
        switch(y){
            case 1:
                return array1[x];
            
            case 2:
                return array2[x];

            case 3:
                return array3[x];

            case 4:
                return array4[x];

            case 5:
                return array5[x];
            default:
                return false;
        }
    }

    private void updateTot(){
        for(int i = 0; i < monthLenght; i++){
            arrayTot[i] = 0;
        }
        
        for(int i = 0; i < monthLenght; i++){
            if(array1[i] == true){ arrayTot[i] += 1; }
            if(array2[i] == true){ arrayTot[i] += 1; }
            if(array3[i] == true){ arrayTot[i] += 1; }
            if(array4[i] == true){ arrayTot[i] += 1; }
            if(array5[i] == true){ arrayTot[i] += 1; }
        }
    }

    public void save(){
        LocalDate currentDate = LocalDate.now();
        updateTot();
        try{
            FileOutputStream fos = new FileOutputStream(currentDate.getMonth()+""+currentDate.getYear()+".TDGraph");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            
            oos.close();
            fos.close();
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        }
    }
}