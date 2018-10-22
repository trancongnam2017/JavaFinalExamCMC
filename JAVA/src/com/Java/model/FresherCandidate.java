package com.Java.model;

import java.util.Scanner;



public class FresherCandidate extends Candidate {
        private String graduationDate;
        private String graduationRank;
        private String education;

        public String getGraduationDate() {
            return graduationDate;
        }

        public void setGraduationDate(String graduationDate) {
            this.graduationDate = graduationDate;
        }

        public String getGraduationRank() {
            return graduationRank;
        }

        public void setGraduationRank(String graduationRank) {
            this.graduationRank = graduationRank;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public FresherCandidate(String firstName, String lastName, int birthDate, String address, String phone,
                String email, int candidateType, String graduationDate, String graduationRank, String education) {
            super(firstName, lastName, birthDate, address, phone, email, candidateType);
            this.graduationDate = graduationDate;
            this.graduationRank = graduationRank;
            this.education = education;
        }

        public FresherCandidate() {
            // TODO Auto-generated constructor stub
        }

        @Override
        public void enterCandidate() {
            super.enterCandidate();
            System.out.println("Granduated date:");
            this.graduationDate = new Scanner(System.in).nextLine();
            System.out.println(" Granduated Rank");
            this.graduationRank = new Scanner(System.in).nextLine();
            while (!(this.graduationRank.equals("Excellence") || this.graduationRank.equals("Poor")
                    || this.graduationRank.equals("Good") || this.graduationRank.equals("Fair"))) {
                System.out.println("Graduation_rank: (Excellence, Good, Fair, Poor),please re-input values");
                this.graduationRank = new Scanner(System.in).nextLine();
            }
            System.out.println(" in College:");
            this.education = new Scanner(System.in).nextLine();
        }

        @Override
        public void showCandidate() {
            super.showCandidate();
            System.out.println(this.graduationDate);
            System.out.println(this.graduationRank);
            System.out.println(this.education);
        }
    }
