package com.Java.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.Java.business.ExperienceCandidateBUS;
import com.Java.business.FresherCandidateBUS;
import com.Java.business.InternCandidateBUS;

public class MainMenu {
        public static void main(String[] args) {
            while (true) {
                System.out.println("Enter your option: ");
                System.out.println("1. Experienced candidate");
                System.out.println("2. fresher candidate");
                System.out.println("3. intern candidate");
                System.out.println("4: exit"); 
                
                int opt = 0;
                try {
                    opt = new Scanner(System.in).nextInt();
                        while (opt < 1) {
                            System.out.println("re-enter option");
                            opt = new Scanner(System.in).nextInt();
                        }
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                switch (opt) {
                case 1:
                    ExperienceCandidateBUS.enterExperienceCandidate();
                    ExperienceCandidateBUS.showExperienceCandidate();
                    break;
                case 2:
                    FresherCandidateBUS.enterFresherCandidate();
                    FresherCandidateBUS.showFresherCandidate();
                    break;
                case 3:
                    InternCandidateBUS.enterInternCandidate();
                    InternCandidateBUS.showInternCandidate();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Re-input options : 1-4");
                    break;
                }
            }
        }
    }


