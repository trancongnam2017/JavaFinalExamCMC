package com.Java.business;

import java.util.ArrayList;
import java.util.List;

import com.Java.dbo.FresherCandidateDAO;
import com.Java.dbo.DAOInterface;
import com.Java.model.FresherCandidate;



public class FresherCandidateBUS implements BusinessInterface<FresherCandidate> {
        DAOInterface<FresherCandidate> fresherCandidateDAO;
        @Override
        public FresherCandidate addNew(FresherCandidate fresherCandidate) {
            fresherCandidateDAO =  new FresherCandidateDAO();
            return fresherCandidateDAO.addNew(fresherCandidate);
        }

        @Override
        public List<FresherCandidate> getAll() {
            List<FresherCandidate> list = new ArrayList<>();
            fresherCandidateDAO =  new FresherCandidateDAO();
            list = fresherCandidateDAO.getAll();
            return list;
        }
        

        public static void enterFresherCandidate() {
            FresherCandidate fresherCandidate = new FresherCandidate();
            fresherCandidate.enterCandidate();
            
            FresherCandidateBUS fresherCandidateBUS = new FresherCandidateBUS();
            fresherCandidateBUS.addNew(fresherCandidate);
        }
        
        public static void showFresherCandidate() {
            List<FresherCandidate> list = new ArrayList<>();
            FresherCandidateBUS fresherCandidateBUS = new FresherCandidateBUS();
            list = fresherCandidateBUS.getAll();
            for (FresherCandidate fresherCandidate : list) {
                fresherCandidate.showCandidate();
            }
        }

    }

