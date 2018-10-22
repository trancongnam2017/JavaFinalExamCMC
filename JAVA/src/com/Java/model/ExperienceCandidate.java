package com.Java.model;

import java.util.Scanner;



public class ExperienceCandidate extends Candidate {
        private int expInYear;
        private  String proSkill;
        public int getExpInYear() {
            return expInYear;
        }
        public void setExpInYear(int expInYear) {
            this.expInYear = expInYear;
        }
        public String getProSkill() {
            return proSkill;
        }
        public void setProSkill(String proSkill) {
            this.proSkill = proSkill;
        }
        public ExperienceCandidate(String firstName, String lastName, int birthDate, String address, String phone,
                String email, int candidateType, int expInYear, String proSkill) {
            super(firstName, lastName, birthDate, address, phone, email, candidateType);
            this.expInYear = expInYear;
            this.proSkill = proSkill;
        }
        
        public ExperienceCandidate() {
        }
        
        @Override
        public void enterCandidate() {
            super.enterCandidate();
            System.out.println("Enter number of experience year :");
            this.expInYear = new Scanner(System.in).nextInt();

            System.out.println("Enter skill:");
            this.proSkill = new Scanner(System.in).nextLine();
        }
        @Override
        public void showCandidate() {
            super.showCandidate();
            System.out.println(this.expInYear);
            System.out.println(this.proSkill);
        }
    }
