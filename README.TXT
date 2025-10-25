Project: weblog-analyzer
Aothors: David J. Barnes and Michael Kölling

This project is part of the material for chapter 7 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling


Purpose of project: To provide an illustration of the use of arrays.
How to start this project: Create a LogAnalyzer object.

The LogfileReader expects to read a file, weblog.txt,
containing lines of data in the format:

    year month day hour minute

month values are in the range 1-12 and day values in the range 1-31.
If the sample file cannot be found, the reader will create some simulated
data. Alternatively, use the LogfileCreator to create some random data.
Use its createFile method to give a file name and the number of entries
to create.

EXTRA, CREATE A METHOD IN WHICH YOU ADD TRUE OR FALSE TO AN ARRAY OF TYPE BOOLEAN CALLED VACANT.

LAB REPORT

1a. Explore the weblog-analyzer project by creating a LogAnalyzer object and calling its analyzeHourlyData
method. Follow that with a call to its printHourlyCounts method, which will print the results of the 
analysis. Which are the busiest times of the day?

1b.2 pm seems to be the busiest time of day.

2a. Write a declaration for an array variable people that could be used to refer to an array of Person objects. 

2b. private Person[] people;

3a. Write a declaration for an array variable vacant that could be used to refer to an array of boolean 
values. 

3b. private boolean[] vacant;
//EXTRA CREDIT(Accessing and changing values in an array)
boolean[] vacant;
for(int hour = 0; hour < hourCounts.length; hour ++)
{
   if(hourCounts[hour] == 0)
   {
      vacant[hour] = true;
   } 
   else 
   {
      vacant[hour] = false;
   }   
}

4a. Read through the LogAnalyzer class and identify all the places where the hourCounts variable is 
used. At this stage, do not worry about what all the uses mean, as they will be explained in the 
following sections. Note how often a pair of square brackets is used with the variable. 

4b. The hourCounts variable is used 5 times throughout the logAnalyzer class, with only 2 including square brackets.

5a. What is wrong with the following array declarations? Correct them. 
[]int counts; 
boolean[5000] occupied; 

5b.
int[] counts;
boolean[] occupied = new boolean[5000];

6a. Given the following variable declarations:
double[] readings;
String[] urls;
TicketMachine[] machines; 
write assignments that accomplish the following tasks: (a) Make the readings variable refer to an 
array that is able to hold 60 double values; (b) Make the urls variable refer to an array that is able 
to hold 90 String objects; (c) Make the machines variable refer to an array that is able to hold 5 
TicketMachine objects. 

6b. double[] readings = new double[60];
String[] urls = new String[90];
TicketMachine[] machines = new TicketMachine[5];

7a. How many String objects are created by the following declaration? 
String[] labels = new String[20]; 

7b. 0 String objects. You just create the collection, not what is stored within.
to fill it ex:
for(i = 0; i < labels.length; i++)
{
   labels[i] = "CHICKEN POUTINE."
}

8a. What is wrong with the following array creation? Correct it. 
double[] prices = new double(50);

8b. double[] prices = new double[50];//the square brackets were wrongly replaced with parenthesis.

9a. Check to see what happens if the for loop’s condition is incorrectly written using the <= operator in 
printHourlyCounts: 
for(int hour = 0; hour <= hourCounts.length; hour++)

9b.An error titled "java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 24", becasue the indexes of
this array only goes up to 23, so the index 24 is none existent or as the error states "out of bounds". The length and 
indexes differ due to their starting values being different by 1. So 0 for the indexes and the length starting at 1.

10a. Rewrite the body of printHourlyCounts so that the for loop is replaced by an equivalent while 
loop. Call the rewritten method to check that it prints the same results as before. 

10b.
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while(hour < hourCounts.length){
            System.out.println(hour + ": " + hourCounts[hour]);//3
            hour ++;
        }
    }
EXTRA FOREACH LOOP
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        for(int count : hourCounts){
            System.out.println(hour + ": " + count);
            hour ++;
        }
    }

11a. Correct all the errors in the following method. 
/** * Print all the values in the marks array that are greater than mean.
 * @param marks An array of mark values.
 * @param mean The mean (average) mark. */ 
public void printGreater(double marks, double mean) { 
for(index = 0; index <= marks.length; index++) {
if(marks[index] > mean) {
System.out.println(marks[index]);
} 
} 
}

11b.
/** * Print all the values in the marks array that are greater than mean.
 * @param marks An array of mark values.
 * @param mean The mean (average) mark. */ 
public void printGreater(double[] marks, double[] mean) { 
for(int index = 0; index < marks.length; index++) {
if(marks[index] > mean) {
System.out.println(marks[index]);
} 
} 
}

12a. Modify the LogAnalyzer class so that it has a constructor that can take the name of the log file to 
be analyzed. Have this constructor pass the file name to the constructor of the LogfileReader
class. Use the LogfileCreator class to create your own file of random log entries, and analyze the 
data. 

12b.
     /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];//1
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

13a. Complete the numberOfAccesses method, below, to count the total number of accesses recorded in the 
log file. Complete it by using a for loop to iterate over hourCounts: 
/** * Return the number of accesses recorded in the log file. */ 
public int numberOfAccesses() { 
int total = 0;
// Add the value in each element of hourCounts to total. ...
return total; 
} 

13b.
/** * Return the number of accesses recorded in the log file. */ 
    public int numberOfAccesses() { 
        int total = 0;
        // Add the value in each element of hourCounts to total. ...
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            total = total + hourCounts[hour];
        }
        return total; 
    } 

14a. Add your numberOfAccesses method to the LogAnalyzer class and check that it gives the correct result.
Hint: You can simplify your checking by having the analyzer read log files containing just a few lines of 
data. That way you will find it easier to determine whether or not your method gives the correct answer. 
The LogfileReader class has a constructor with the following header, to read from a particular file: 
 /** * Create a LogfileReader that will supply data from a particular log file.
 * @param filename The file of log data. */ 
 public LogfileReader(String filename) 

14b.Yes, it did work as intended!

15a. Add a method busiestHour to LogAnalyzer that returns the busiest hour. You can do this by looking 
through the hourCounts array to find the element with the biggest count. Hint: Do you need to check 
every element to see if you have found the busiest hour? If so, use a for loop or a for-each loop. Which 
one is better in this case? 

15b.
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

16a. Add a method quietestHour to LogAnalyzer that returns the number of the least busy hour. Note: This 
sounds almost identical to the previous exercise, but there is a small trap for the unwary. Be sure to check
your method with some data in which every hour has a non-zero count. 

16b.
public String quietestHours()
    {
        ArrayList<Integer> quietestHours = new ArrayList<Integer>();
        int quietest = hourCounts[0];
        String listOfHours = "";
        StringBuilder string = new StringBuilder();
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hourCounts[hour] == quietest)
            {
                    quietestHours.add(hour);
            }else
            {
                if(hourCounts[hour] < quietest)
                {
                    quietestHours.clear();
                    quietest = hourCounts[hour];
                    quietestHours.add(hour);
                }else
                {
                    //move to the next hour without doing anything with the Arraylist.
                }
            }
        }
        for(int heure : quietestHours)
        {
            string.append(heure +", ");
        }
        string.deleteCharAt(string.length()-2);
        listOfHours = string.toString();
        return "Quietest hours of traffic is: " + listOfHours + "with "+ quietest + " visits.";
    }


17a. Which hour is returned by your busiestHour method if more than one hour has the biggest count? 

17b. It displays the latest one, or the one being processed at the latest time that fits
the condition of being the highest/busiest hour. So, 1 = 50 && 23 = 50, it would display hour
23 rather than both or 1.

18a. Add a method to LogAnalyzer that finds which two-hour period is the busiest. Return 
the value of the first hour of this period. 

18b.
public int busiestTwoHourPeriod()
    {
        int busiest = hourCounts[0] + hourCounts[1];
        int busiestHour = 0;
        for(int hour = 0; hour + 1 < hourCounts.length; hour++)
        {
            if(hourCounts[hour] + hourCounts[hour + 1] > busiest)
            {
                busiest = hourCounts[hour] + hourCounts[hour + 1];
                busiestHour = hour;
            }
        }
        return busiestHour;
    }
