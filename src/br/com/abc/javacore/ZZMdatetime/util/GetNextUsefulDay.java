package br.com.abc.javacore.ZZMdatetime.util;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class GetNextUsefulDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int nextUsefulDay = 1;
        switch (dayOfWeek) {
            case FRIDAY:
                nextUsefulDay = 3;
                break;
            case SATURDAY:
                nextUsefulDay = 2;
                break;
        }
        return temporal.plus(nextUsefulDay, ChronoUnit.DAYS);
    }
}
