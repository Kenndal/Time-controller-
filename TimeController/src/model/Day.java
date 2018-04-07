package model;


import exceptions.DayException;
import exceptions.ExceptionEvent;

import java.util.ArrayList;

public class Day {

    private ArrayList<Event> workEvents = new ArrayList<>();
    private ArrayList<Event> responsibilitiesEvents = new ArrayList<>();
    private ArrayList<Event> otherEvents = new ArrayList<>();


    public ArrayList<Event> getWorkEvent() {
        return workEvents;
    }

    public ArrayList<Event> getResponsibilitiesEvent() {
        return responsibilitiesEvents;
    }

    public ArrayList<Event> getOtherEvent() {
        return otherEvents;
    }

    public Event searchEvent(String eventTitle, String eventStatus ) throws DayException {
        if(eventStatus.equals("Work")) {
            for (int i = 0; i < workEvents.size();i++)
                if(eventTitle.equals(workEvents.get(i).getEventTitle())){
                    return workEvents.get(i);
                }
        }else
        if(eventStatus.equals("Responsibilities")) {
            for (int i = 0; i < responsibilitiesEvents.size();i++)
                if(eventTitle.equals(responsibilitiesEvents.get(i).getEventTitle())){
                    return responsibilitiesEvents.get(i);
                }
        }else
        if(eventStatus.equals("Other")) {
            for (int i = 0; i < otherEvents.size();i++)
                if(eventTitle.equals(otherEvents.get(i).getEventTitle())){
                    return otherEvents.get(i);
                }
        }else
            throw new DayException("Nie ma takiego wydarzenia");
        return null;
    }

    public void addNewEvent(Event event){
        if(event.getWork()){
            workEvents.add(event);
        }
        else {
            if(event.getResponsibilities()){
                responsibilitiesEvents.add(event);
            }
            else
                otherEvents.add(event);
        }
    }

    public void rmEvent(Event event) throws DayException{
        if(event.getWork()){
            workEvents.remove(event);
        }
        else {
            if(event.getResponsibilities()){
                responsibilitiesEvents.remove(event);
            }
            else
                if(event.getOther())
                   otherEvents.remove(event);
        }
    }

    public static void main(String[] args) {

        try {
            Event event = new Event.EventBuilder("KEK", "Work").setWork(true).setEventTime("12:00").build();
            Day day =  new Day();
            day.addNewEvent(event);
            day.rmEvent(day.searchEvent("KEK", "Work"));
        } catch (ExceptionEvent exceptionEvent) {
            System.out.println(exceptionEvent.getMessage());
        } catch (DayException e) {
            e.printStackTrace();
        }

    }
}
