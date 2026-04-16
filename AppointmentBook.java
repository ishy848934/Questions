import java.util.Arrays;
public class AppointmentBook {
    private boolean schedule[][];

    public AppointmentBook(){
    {
      schedule = new boolean[8][60];
      for (int period = 0; period < 8; period++)
          Arrays.fill(schedule[period], true);
    }
    }

    /**
     * Returns true if minute in period is available for an appointment and returns
     * false otherwise
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
     */
    private boolean isMinuteFree(int period, int minute)
    {
        return schedule[period-1][minute];
    }

    /**
     * Marks the block of minutes that starts at startMinute in period and
     * is duration minutes long as reserved for an appointment
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
     * 1 <= duration <= 60
     */
    private void reserveBlock(int period, int startMinute, int duration)
    {
        for (int minute = startMinute; minute < startMinute + duration; minute++)
            schedule[period-1][minute] = false;
    }

    /******************  Part (a) ******************/

    public int findFreeBlock(int period, int duration)
    {
        for (int start = 0; start <= 60 - duration; start++)
        {
            boolean ok = true;

            for (int minute = start; minute < start + duration; minute++)
            {
                if (!isMinuteFree(period, minute))
                {
                    ok = false;
                    break;
                }
            }

            if (ok)
                return start;
        }
        return -1;
    }

    /******************  Part (b) ******************/

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration)
    {
        for (int period = startPeriod; period <= endPeriod; period++)
        {
            int start = findFreeBlock(period, duration);

            if (start != -1)
            {
                reserveBlock(period, start, duration);
                return true;
            }
        }
        return false;
    }
}
