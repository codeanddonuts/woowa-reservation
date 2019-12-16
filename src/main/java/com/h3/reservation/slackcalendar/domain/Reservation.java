package com.h3.reservation.slackcalendar.domain;

import com.h3.reservation.common.MeetingRoom;
import com.h3.reservation.common.ReservationDetails;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-11
 */
public class Reservation {
    private final ReservationDetails details;
    private final DateTime time;

    private Reservation(final ReservationDetails details, final DateTime dateTime) {
        this.details = details;
        this.time = dateTime;
    }

    /**
     * @param date      yyyy-MM-dd
     * @param startTime HH:mm
     * @param endTime   HH:mm
     * @return
     */
    public static Reservation of(final MeetingRoom room, final String booker, final String purpose
        , final String date, final String startTime, final String endTime) {
        return new Reservation(ReservationDetails.of(room, booker, purpose)
            , DateTime.of(date, startTime, endTime));
    }

    public static Reservation of(final MeetingRoom room, final String booker, final String purpose
        , final LocalDate date, final LocalTime startTime, final LocalTime endTime) {
        return new Reservation(ReservationDetails.of(room, booker, purpose)
            , DateTime.of(date, startTime, endTime));
    }

    public static Reservation of(final ReservationDetails details, final DateTime time) {
        return new Reservation(details, time);
    }

    public MeetingRoom getRoom() {
        return details.getMeetingRoom();
    }

    public String getBooker() {
        return details.getBooker();
    }

    public String getDescription() {
        return details.getDescription();
    }

    public String getFormattedDate() {
        return time.getFormattedDate();
    }

    public String getFormattedStartTime() {
        return time.getFormattedStartTime();
    }

    public String getFormattedEndTime() {
        return time.getFormattedEndTime();
    }

    public ReservationDetails getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "details=" + details +
            ", time=" + time +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (!Objects.equals(details, that.details)) return false;
        return Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        int result = details != null ? details.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}