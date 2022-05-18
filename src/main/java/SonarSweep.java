import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SonarSweep
{
    private static final String FILE_PATH = "/Users/melpomene/Downloads/input.txt";

    public static void main(String[] args)
    {
        List<Integer> measurements = getMeasurements();
        System.out.println(getIncrements(measurements));
    }

    private static List<Integer> getMeasurements()
    {
        List<Integer> measurements = new ArrayList<>();
        try
        {
            File myObj = new File(FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                measurements.add(Integer.parseInt(myReader.nextLine()));
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return measurements;
    }

    private static int getIncrements(List<Integer> measurements)
    {
        int countIncrements = 0;
        int currentMeasurement = measurements.get(0);
        for (int i = 1; i < measurements.size(); i++)
        {
            if (measurements.get(i) > currentMeasurement)
            {
                countIncrements++;
            }
            currentMeasurement = measurements.get(i);
        }
        return countIncrements;
    }
}
