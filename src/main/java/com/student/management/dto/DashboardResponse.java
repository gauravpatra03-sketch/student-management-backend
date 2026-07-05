package com.student.management.dto;

public class DashboardResponse {

    private long totalStudents;
    private long totalCourses;
    private long totalMale;
    private long totalFemale;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalStudents, long totalCourses,
                             long totalMale, long totalFemale) {
        this.totalStudents = totalStudents;
        this.totalCourses = totalCourses;
        this.totalMale = totalMale;
        this.totalFemale = totalFemale;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(long totalCourses) {
        this.totalCourses = totalCourses;
    }

    public long getTotalMale() {
        return totalMale;
    }

    public void setTotalMale(long totalMale) {
        this.totalMale = totalMale;
    }

    public long getTotalFemale() {
        return totalFemale;
    }

    public void setTotalFemale(long totalFemale) {
        this.totalFemale = totalFemale;
    }
}