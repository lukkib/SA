package at.tugraz.sa.io;

import java.io.*;

public class CsvWriter
{
    private String path;
    BufferedWriter output;

    public CsvWriter(String path)
    {
        this.path = path;

        try
        {
            output = new BufferedWriter(new FileWriter(path, true));
        }
        catch(IOException e)
        {
          e.printStackTrace();
        }
    }

    public void writeLine(String line)
    {
        try
        {
            output.write(line);
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

