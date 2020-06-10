/* *****************************************************************************
 *  Compilation : javac BarChartRacer.javac
 *  Excecution : java BarChartRacer endgame.txt 10
 *
 *  Dependencies : Seven additional files.
 *                1. BarChart.java
 *                2. Bar.java
 *                3. In.java
 *                4. StdDraw.java
 *                5. StdAudio.java
 *                6. endgame.txt
 *                7. The-avengers-.wav
 *
 *  NOTE::
 *  Place all these files in the same directory along with the main program file.
 *
 *
 *  For more info, visit
 *  https://coursera.cs.princeton.edu/introcs/assignments/barchart/specification.php
 *
 *
 *
 *  @author: KRS Nandhan
 *
 *  Last modified:    8/06/2020
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {


    public static void main(String[] args) {

        // reading command line arguments.
        int count = Integer.parseInt(args[1]);
        In in = new In(args[0]);

        // reading from the input source.
        String title = in.readLine();
        String xaxis = in.readLine();
        String source = in.readLine();

        // creating new barchart object.
        BarChart chart = new BarChart(title, xaxis, source);

        // Creating output window and its dimensions.
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        StdAudio.loop("The-Avengers-.wav");

        // reading the input form the source untill it reaches the end of the file.
        while (in.hasNextLine()) {

            StdDraw.clear();

            String s = in.readLine();  //  read a empty line.
            int n = Integer.parseInt(in.readLine());

            // create n number of bars to store the data from the input.
            Bar[] bar = new Bar[n];

            // read n records from the source.
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                String[] arr = line.split(",");
                String v = arr[3];
                int value = Integer.parseInt(v);
                bar[i] = new Bar(arr[1], value, arr[4]);  // creating new bar for each line.
                chart.setCaption(arr[0]);

            } // for loop

            Arrays.sort(bar);  // sorting the array by values.

            // display the bars that are greater than zero.
            if (bar[bar.length-count].getValue() > 0) {
            
            // adding the bars to the barchart object.
            for (int i = (bar.length - 1); i >= (bar.length - count); i--) {
                chart.add(bar[i].getName(), bar[i].getValue(), bar[i].getCategory());
            }

            // Output display.
            chart.draw();
            StdDraw.show();
            StdDraw.pause(35);
            chart.reset();

          } // if statement.

        } // while loop

    } // main method.

} // class
