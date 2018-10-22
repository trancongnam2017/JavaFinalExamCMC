package com.Java.model;

import java.util.Scanner;



public class InternCandidate extends Candidate {
        private String majors;
        private String semester;
        private String  universityName;
        public String getMajors() {
            return majors;
        }
        public void setMajors(String majors) {
            this.majors = majors;
        }
        public String getSemester() {
            return semester;
        }
        public void setSemester(String semester) {
            this.semester = semester;
        }
        public String getUniversityName() {
            return universityName;
        }
        public void setUniversityName(String universityName) {
            this.universityName = universityName;
        }
        public InternCandidate(String firstName, String lastName, int birthDate, String address, String phone, String email,
                int candidateType, String majors, String semester, String universityName) {
            super(firstName, lastName, birthDate, address, phone, email, candidateType);
            this.majors = majors;
            this.semester = semester;
            this.universityName = universityName;
        }
        public InternCandidate() {
        }
        @Override
        public void enterCandidate() {
            super.enterCandidate();
            System.out.println("Enter major:");
            this.majors = new Scanner(System.in).nextLine();
            System.out.println("Enter current sem:");
            this.semester = new Scanner(System.in).nextLine();
            System.out.println("In College");
            this.universityName = new Scanner(System.in).nextLine();
        }
        @Override
        public void showCandidate() {
            super.showCandidate();
            System.out.println(this.majors);
            System.out.println(this.semester);
            System.out.println(this.universityName);
        }
    }

