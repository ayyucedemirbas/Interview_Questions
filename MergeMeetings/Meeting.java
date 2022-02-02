import java.util.*;

import javax.sound.sampled.SourceDataLine;



  
  public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // make a copy so we don't destroy the input
        List<Meeting> sortedMeetings = new ArrayList<>();
        for (Meeting meeting: meetings) {
            Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
            sortedMeetings.add(meetingCopy);
        }
    
        // sort by start time
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });
    
        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));
    
        for (Meeting currentMeeting : sortedMeetings) {
    
            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);
    
            // if the current meeting overlaps with the last merged meeting, use the
            // later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
    
            // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }
    
        return mergedMeetings;
    }

    public static void main(String[] args) {
        Meeting m = new Meeting(1,3);
        Meeting m1 = new Meeting(3,4);
        Meeting m2 = new Meeting(4,5);
        Meeting m3 = new Meeting(7,9);
        List<Meeting> myMeetings = new ArrayList<>();
        myMeetings.add(m);
        myMeetings.add(m1);
        myMeetings.add(m2);
        myMeetings.add(m3);
        List<Meeting> sortedMeetings = new ArrayList<>();
        sortedMeetings= mergeRanges(myMeetings);
        
        //sortedMeetings.forEach(System.out::println);
        sortedMeetings.get(0).getStartTime();

        for(int i=0;i<sortedMeetings.size();i++){
            System.out.print("("+sortedMeetings.get(i).getStartTime()+ ", ");
            System.out.print(sortedMeetings.get(i).getEndTime()+ ")");
            System.out.println();
        } 
        


    }
}