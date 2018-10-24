package com.Java.business;

import java.util.ArrayList;
import java.util.List;

import com.Java.dbo.ExperienceCandidateDAO;
import com.Java.dbo.DAOInterface;
import com.Java.model.ExperienceCandidate;



public class ExperienceCandidateBUS implements BusinessInterface<ExperienceCandidate> {
        DAOInterface<ExperienceCandidate> experienceCandidateDAO;
        @Override
        public ExperienceCandidate addNew(ExperienceCandidate experienceCandidate) {
            experienceCandidateDAO =  new ExperienceCandidateDAO();
            return experienceCandidateDAO.addNew(experienceCandidate);
        }

        @Override
        public List<ExperienceCandidate> getAll() {
            List<ExperienceCandidate> list = new ArrayList<>();
            experienceCandidateDAO = new ExperienceCandidateDAO();
            list = experienceCandidateDAO.getAll();
            return list;
        }
        

        public static void enterExperienceCandidate() {
            ExperienceCandidate experienceCandidate = new ExperienceCandidate();
            experienceCandidate.enterCandidate();
            
            ExperienceCandidateBUS experienceCandidateBUS = new ExperienceCandidateBUS();
            experienceCandidateBUS.addNew(experienceCandidate);
        }
        
        public static void showExperienceCandidate() {
            List<ExperienceCandidate> list = new ArrayList<>();
            ExperienceCandidateBUS experienceCandidateBUS = new ExperienceCandidateBUS();
            list = experienceCandidateBUS.getAll();
            for (ExperienceCandidate experienceCandidate : list) {
                experienceCandidate.showCandidate();
            }
        }
    }
