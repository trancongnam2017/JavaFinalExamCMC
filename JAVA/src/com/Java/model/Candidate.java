package com.Java.model;

import java.util.Scanner;



public abstract class Candidate implements ICandidate{
        private String firstName;
        private String lastName;
        private int birthDate;
        private String address;
        private String phone;
        private String email;
        private int candidateType;
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public int getBirthDate() {
            return birthDate;
        }
        public void setBirthDate(int birthDate) {
            this.birthDate = birthDate;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public int getCandidateType() {
            return candidateType;
        }
        public void setCandidateType(int candidateType) {
            this.candidateType = candidateType;
        }
        public Candidate(String firstName, String lastName, int birthDate, String address, String phone, String email,
                int candidateType) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.address = address;
            this.phone = phone;
            this.email = email;
            this.candidateType = candidateType;
        }
        public Candidate() {
        }
        
        public void enterCandidate() {
            System.out.println("Enter FirstName:");
            this.firstName = new Scanner(System.in).nextLine();
            System.out.println("Enter LastName:");
            this.lastName = new Scanner(System.in).nextLine();
            System.out.println("Enter Birthday:");
            this.birthDate = new Scanner(System.in).nextInt();
            while (this.birthDate < 1900 || this.birthDate > 2018) {
                System.out.println("BirthDay must be > 1900 and <2000");
                this.birthDate = new Scanner(System.in).nextInt();
            }
            System.out.println("Enter Address:");
            this.address = new Scanner(System.in).nextLine();
            System.out.println("Enter phone numer :");        
            this.phone = new Scanner(System.in).nextLine();
            while (this.phone.length() < 7 && this.phone.matches("[0-9]+")) {
                System.out.println("Phone number must be more than 6 digits");
                this.phone = new Scanner(System.in).nextLine();
                }   
            System.out.println("enter your email :");
            this.email = new Scanner(System.in).nextLine();
            while (this.email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
                System.out.println("Wrong email format, re-input email");
                this.email = new Scanner(System.in).nextLine();
            }
            
        };
        public void showCandidate() {
            System.out.println(this.firstName); 
            System.out.println(this.lastName);
            System.out.println(this.birthDate);
            System.out.println(this.address);
            System.out.println(this.phone);
            System.out.println(this.email);
            System.out.println(this.candidateType);
        }
    }
