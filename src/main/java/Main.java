import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final int maxNumber = 10;
        BufferedReader bf = new BufferedReader(new FileReader("file.txt"));
        ArrayList<Thread> listOfThreads = new ArrayList<Thread>(maxNumber);
        boolean flag = true;
        String line = bf.readLine();
        int currID = 0;

        for (int i = 0;i<maxNumber;i++){
            listOfThreads.add(null);
        }

        while (flag){

            for (int i = 0;i<maxNumber;i++){
                if(listOfThreads.get(i) ==null){
                    listOfThreads.add(i, new Thread(new MyThread(line, currID++)));
                    listOfThreads.get(i).start();
                    flag = false;
                    break;
                }
                if (!listOfThreads.get(i).isAlive()){
                    listOfThreads.add(i, new Thread(new MyThread(line, currID++)));
                    listOfThreads.get(i).start();
                    flag = false;
                    break;
                }
            }

            if (flag == false)
            {
                if ((line = bf.readLine()) != null)
                    flag = true;
            }
        }
    }
}
