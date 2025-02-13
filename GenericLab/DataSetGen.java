package default1;

/**
   Computes the average and maximum of a set of measurable data values.
   @param <T> the type of objects that are measurable
*/
public class DataSetGen<T extends Measurable>
{
   private double sum;
   private T maximum;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSetGen()
   {
      sum = 0;
      count = 0;
      maximum = null;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */
   public void add(T x)
   {
      sum += x.getMeasure();

      if (maximum == null || maximum.getMeasure() < x.getMeasure())
      {
         maximum = x;
      }

      count++;
   }

   /**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
   */
   public double getAverage()
   {
      return (count == 0) ? 0 : sum / count;
   }

   /**
      Gets the largest of the added data.
      @return the maximum or null if no data has been added
   */
   public T getMaximum()
   {
      return maximum;
   }
}
