package model;

import exceptions.ExceptionEvent;
public class Event {

    private String eventTitle;
    private String eventTime;
    private String eventStatus; // ? to do okreslenia kategori
    private String eventAdditionalInformation;

    private Boolean work;
    private Boolean responsibilities;
    private Boolean other;

    private Boolean completeStatus;


    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public String getEventAdditionalInformation() {
        return eventAdditionalInformation;
    }

    public Boolean getWork() {
        return work;
    }

    public Boolean getResponsibilities() {
        return responsibilities;
    }

    public Boolean getOther() {
        return other;
    }

    public Boolean getCompleteStatus() {
        return completeStatus;
    }




    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setEventAdditionalInformation(String eventAdditionalInformation) {
        this.eventAdditionalInformation = eventAdditionalInformation;
    }

    public void setWork(Boolean work) {
        this.work = work;
    }

    public void setResponsibilities(Boolean responsibilities) {
        this.responsibilities = responsibilities;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }

    private Event(EventBuilder builder) {
        this.eventTitle = builder.eventTitle;
        this.eventTime = builder.eventTime;
        this.eventStatus = builder.eventStatus;
        this.eventAdditionalInformation = builder.eventAdditionalInformation;
        this.work = builder.work;
        this.responsibilities = builder.responsibilities;
        this.other = builder.other;
        this.completeStatus = false;
    }

    public void setCompleteStatus(Boolean complete) {
        this.completeStatus = complete;
    }


    public static class EventBuilder {

        private String eventTitle;
        private String eventTime;
        private String eventStatus; // ? to do okreslenia kategori
        private String eventAdditionalInformation;

        private Boolean work = false;
        private Boolean responsibilities = false;
        private Boolean other = true;

        public EventBuilder(String eventTitle, String eventStatus) throws ExceptionEvent {
            if(eventStatus.equals("Work") || eventStatus.equals("Responsibilities") || eventStatus.equals("Others")) {
                this.eventTitle = eventTitle;
                this.eventStatus = eventStatus;
            }
            else
                throw new ExceptionEvent("Podaj odpowiedni status wydarzenia");
        }

        public EventBuilder setEventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public EventBuilder setEventAdditionalInformation(String eventAdditionalInformation) {
            this.eventAdditionalInformation = eventAdditionalInformation;
            return this;
        }

        public EventBuilder setWork(Boolean work) {
            this.other = false;
            this.work = work;
            return this;
        }

        public EventBuilder setResponsibilities(Boolean responsibilities) {
            this.other = false;
            this.responsibilities = responsibilities;
            return this;
        }

        public EventBuilder setOther(Boolean other) {
            this.other = other;
            return this;
        }

        public Event build() {
            return new Event(this);
        }


    }
}
