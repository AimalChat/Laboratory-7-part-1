import java.util.ArrayList;

/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader("weblog(Day1).txt");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    public String quietestHour()
    {
        ArrayList<Integer> quietestHours = new ArrayList<Integer>();
        int quietest = hourCounts[0];
        int quietestHour = 0;
        String listOfHours = "";
        for(int hour = 1; hour < hourCounts.length; hour++)
        {
            if(hourCounts[hour] < quietest)
            {
                quietest = hourCounts[hour];
                quietestHour = hour;
                quietestHours.add(hour);
            }else
            {
                if(quietestHours.get(0) == quietest)
                {
                    quietestHours.add(hour);
                }else
                {
                    quietestHours.clear();
                    quietestHours.add(hour);
                }
            }
            StringBuilder string = new StringBuilder();
            for(int heure : quietestHours)
                    {
                        string.append(heure +", ");
                        listOfHours = string.toString();
                    }
        }
        return "Quietest hours of traffic is: " + listOfHours + " with "+ quietest + " visits.";
    }
    
        public String busiestHour()
    {
        int busiest = hourCounts[0];
        int busiestHour = 0;
        for(int hour = 1; hour < hourCounts.length; hour++)
        {
            if(hourCounts[hour] > busiest)
            {
                busiest = hourCounts[hour];
                busiestHour = hour;
            }
        }
        return "Busiest hour of traffic is: " + busiestHour + " with "+ busiest + " visits.";
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
