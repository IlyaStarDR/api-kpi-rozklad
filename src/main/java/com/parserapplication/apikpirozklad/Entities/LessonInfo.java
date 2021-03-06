package com.parserapplication.apikpirozklad.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
public class LessonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JsonViews.defaultJsonView.class)
    private int lessonID;

    @JsonView(JsonViews.defaultJsonView.class)
    private String dayNumber;

    @JsonView(JsonViews.defaultJsonView.class)
    private String nameDay;

    @JsonView(JsonViews.defaultJsonView.class)
    private String lessonNumber;

    @JsonView(JsonViews.defaultJsonView.class)
    private String numberWeek;

    @JsonView(JsonViews.defaultJsonView.class)
    private String timeStartLesson;

    @JsonView(JsonViews.defaultJsonView.class)
    private String timeEndLesson;

    @JsonView(JsonViews.defaultJsonView.class)
    private String lessonName;

    @JsonView(JsonViews.defaultJsonView.class)
    private String teacherName;

    @JsonView(JsonViews.defaultJsonView.class)
    private String roomNumber;

    @JsonView(JsonViews.defaultJsonView.class)
    private String roomType;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private GroupInfo lessonOfGroupId;

    /**
     * Creates a new LessonInfo without params
     */
    public LessonInfo() {
    }

    /**
     * Creates a new GroupInfo with params
     *
     * @param dayNumber       day of the week
     * @param nameDay         name of the week
     * @param lessonNumber    number of the lesson
     * @param numberWeek      number of week
     * @param timeStartLesson time of starting lesson
     * @param timeEndLesson   time of ending lesson
     * @param lessonName      name of lesson
     * @param teacherName     name of the teacher
     * @param roomNumber      number of room
     * @param roomType        type of room
     */
    public LessonInfo(String dayNumber, String nameDay, String lessonNumber, String numberWeek, String timeStartLesson, String timeEndLesson, String lessonName, String teacherName, String roomNumber, String roomType) {
        this.dayNumber = dayNumber;
        this.nameDay = nameDay;
        this.lessonNumber = lessonNumber;
        this.numberWeek = numberWeek;
        this.timeStartLesson = timeStartLesson;
        this.timeEndLesson = timeEndLesson;
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }


    /**
     * This method is used to set lesson info such as lessonName, teacherName, roomNumber, roomType.
     *
     * @param parseLessonFromString ArrayList containing parsed lesson info
     */
    public void setLessonInfo(ArrayList<String> parseLessonFromString) {
        if (parseLessonFromString.size() == 3) {
            setLessonName(parseLessonFromString.get(0));
            setTeacherName(parseLessonFromString.get(1));
            if (parseLessonFromString.get(2).split(" ").length == 2) {
                setRoomNumber(parseLessonFromString.get(2).split(" ")[0]);
                setRoomType(parseLessonFromString.get(2).split(" ")[1]);
            }
        } else {
            if (parseLessonFromString.size() == 0) {
                setLessonName(null);
            } else {
                setLessonName(parseLessonFromString.get(0));
            }
            setTeacherName(null);
            setRoomNumber(null);
            setRoomType(null);
        }
    }
}
